package es.kiketurry.talentobank.ui.accountslist;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.kiketurry.talentobank.R;
import es.kiketurry.talentobank.domain.models.AccountModel;
import io.reactivex.functions.Consumer;

public class AccountsListAdapter extends RecyclerView.Adapter<AccountsListAdapter.AccountViewHolder> {
    
    private static final String TAG = AccountsListAdapter.class.getSimpleName();
    
    private final Context context;
    private Consumer<AccountModel> actionClickAccount;
    private ArrayList<AccountModel> accountModels;
    
    public static class AccountViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.llContentAccount)
        LinearLayout llContentAccount;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvAlias)
        TextView tvAlias;
        @BindView(R.id.tvIban)
        TextView tvIban;
        @BindView(R.id.tvBalance)
        TextView tvBalance;
        @BindView(R.id.tvType)
        TextView tvType;
        
        public AccountViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    
    public AccountsListAdapter(Context context, Consumer<AccountModel> actionClickAccount) {
        this.context = context;
        this.actionClickAccount = actionClickAccount;
    }
    
    @Override
    public AccountViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_accounts, viewGroup, false);
        return new AccountViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(AccountViewHolder accountViewHolder, int position) {
        AccountModel accountModel = accountModels.get(position);
        accountViewHolder.tvName.setText(Html.fromHtml(String.format(context.getString(R.string.acount_name), accountModel.getAccountName())));
        accountViewHolder.tvAlias.setText(Html.fromHtml(String.format(context.getString(R.string.acount_alias), accountModel.getAlias())));
        accountViewHolder.tvIban.setText(Html.fromHtml(String.format(context.getString(R.string.acount_iban), accountModel.getIban())));
        accountViewHolder.tvBalance.setText(Html.fromHtml(String.format(context.getString(R.string.acount_balance), ((double) accountModel.getAccountBalanceInCents()) / 100d, accountModel.getAccountCurrency())));
        accountViewHolder.tvType.setText(Html.fromHtml(String.format(context.getString(R.string.acount_name), accountModel.getAccountType())));
        
        accountViewHolder.llContentAccount.setOnClickListener(view -> {
            try {
                actionClickAccount.accept(accountModel);
            } catch (Exception e) {
                Log.e(TAG, "l> Problem call action click in account: " + e.getMessage());
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return accountModels != null ? accountModels.size() : 0;
    }
    
    public void addAccounts(ArrayList<AccountModel> accountModels) {
        this.accountModels = accountModels;
        notifyDataSetChanged();
    }
}
