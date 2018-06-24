package es.kiketurry.talentobank.ui.accountslist;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import es.kiketurry.talentobank.R;
import es.kiketurry.talentobank.domain.models.AccountModel;
import es.kiketurry.talentobank.domain.models.AccountsListModel;
import es.kiketurry.talentobank.ui.base.BaseActivity;
import io.reactivex.functions.Consumer;

public class AccountsListActivity extends BaseActivity<AccountsListPresenter> implements AccountsListView {
    
    private static final String TAG = AccountsListActivity.class.getSimpleName();
    
    @BindView(R.id.rv_accounts_list)
    RecyclerView rvAccountsList;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    
    RecyclerView.LayoutManager layoutManager;
    AccountsListAdapter accountsListAdapter;
    Consumer<AccountModel> actionClickAccount = this::clickAccountModel;
    
    @Override
    protected int getLayout() {
        return R.layout.activity_accounts_list;
    }
    
    @Override
    protected AccountsListPresenter initializePresenter() {
        return new AccountsListPresenter(this);
    }
    
    @Override
    protected void initView() {
        configureActionbar();
        
        rvAccountsList.setHasFixedSize(true);
        
        layoutManager = new LinearLayoutManager(this);
        rvAccountsList.setLayoutManager(layoutManager);
        
        accountsListAdapter = new AccountsListAdapter(this, actionClickAccount);
        rvAccountsList.setAdapter(accountsListAdapter);
    }
    
    private void configureActionbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.title_actionbar_list_activity));
    }
    
    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }
    
    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }
    
    @Override
    public void showSuperHeroes(AccountsListModel accountsListModel) {
        accountsListAdapter.addAccounts(accountsListModel.getAccounts());
    }
    
    @Override
    public void showProblem(String message) {
        Toast.makeText(this, getString(R.string.problem_download_accounts), Toast.LENGTH_LONG).show();
        Log.e(TAG, "l> Problem download accounts: " + message);
    }
    
    private void clickAccountModel(AccountModel accountModel) {
        presenter.clickAccount(accountModel);
    }
}
