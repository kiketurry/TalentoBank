package es.kiketurry.talentobank.ui.accountslist;

import android.util.Log;

import javax.inject.Inject;

import es.kiketurry.talentobank.TalentoBankApplication;
import es.kiketurry.talentobank.domain.models.AccountModel;
import es.kiketurry.talentobank.domain.usecase.GetAccountsTalentoBankUseCase;
import es.kiketurry.talentobank.ui.base.BasePresenter;

public class AccountsListPresenter extends BasePresenter {
    
    private static final String TAG = AccountsListPresenter.class.getSimpleName();
    
    @Inject
    GetAccountsTalentoBankUseCase getAccountsTalentoBankUseCase;
    
    AccountsListView view;
    
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
                }, listSuperHeroesModel -> {
                    view.hideLoading();
                    view.showSuperHeroes(listSuperHeroesModel);
                }, throwable -> {
                    view.hideLoading();
                    view.showProblem(throwable.getMessage());
                }
        );
    }
    
    @Override
    public void destroy() {
        getAccountsTalentoBankUseCase.dispose();
    }
    
    public void clickAccount(AccountModel accountModel) {
        Log.i(TAG, "l> Click in account with number: " + accountModel.getAccountNumber());
    }
}
