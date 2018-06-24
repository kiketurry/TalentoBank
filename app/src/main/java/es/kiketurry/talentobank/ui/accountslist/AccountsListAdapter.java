package es.kiketurry.talentobank.ui.accountslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        @BindView(R.id.tvIban)
        TextView tvIban;
        
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
        accountViewHolder.tvName.setText(accountModel.getAccountName());
        accountViewHolder.tvIban.setText(accountModel.getIban());
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
