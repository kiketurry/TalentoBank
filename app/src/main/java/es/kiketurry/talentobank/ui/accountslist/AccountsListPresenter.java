package es.kiketurry.talentobank.ui.accountslist;

import android.util.Log;

import java.util.ArrayList;

import javax.inject.Inject;

import es.kiketurry.talentobank.TalentoBankApplication;
import es.kiketurry.talentobank.domain.models.AccountModel;
import es.kiketurry.talentobank.domain.models.AccountsListModel;
import es.kiketurry.talentobank.domain.usecase.GetAccountsTalentoBankUseCase;
import es.kiketurry.talentobank.ui.base.BasePresenter;

public class AccountsListPresenter extends BasePresenter {
    
    private static final String TAG = AccountsListPresenter.class.getSimpleName();
    
    @Inject
    GetAccountsTalentoBankUseCase getAccountsTalentoBankUseCase;
    
    AccountsListView view;
    
    private ArrayList<AccountModel> allAccounts;
    private ArrayList<AccountModel> onlyVisible;
    
    public AccountsListPresenter(AccountsListView accountsListView) {
        TalentoBankApplication.getComponent().inject(this);
        this.view = accountsListView;
    }
    
    @Override
    public void setup() {
        getAccountsList();
    }
    
    private void getAccountsList() {
        view.showLoading();
        getAccountsTalentoBankUseCase.execute(
                () -> {
                }, listAcconts -> {
                    view.hideLoading();
                    prepareListAccounts(listAcconts);
                }, throwable -> {
                    view.hideLoading();
                    view.showProblem(throwable.getMessage());
                }
        );
    }
    
    private void prepareListAccounts(AccountsListModel listAcconts) {
        allAccounts = listAcconts.getAccounts();
        onlyVisible = filterOnlyVisible(listAcconts);
        view.showAccounts(onlyVisible);
    }
    
    private ArrayList<AccountModel> filterOnlyVisible(AccountsListModel listAcconts) {
        onlyVisible = new ArrayList<>();
        for (AccountModel accountModel : listAcconts.getAccounts()) {
            if (accountModel.isVisible()) {
                onlyVisible.add(accountModel);
            }
        }
        return onlyVisible;
    }
    
    @Override
    public void destroy() {
        getAccountsTalentoBankUseCase.dispose();
    }
    
    public void clickAccount(AccountModel accountModel) {
        Log.i(TAG, "l> Click in account with number: " + accountModel.getAccountNumber());
    }
    
    public void showHidden(boolean checked) {
        if (checked) {
            view.showAccounts(allAccounts);
        } else {
            view.showAccounts(onlyVisible);
        }
    }
}
