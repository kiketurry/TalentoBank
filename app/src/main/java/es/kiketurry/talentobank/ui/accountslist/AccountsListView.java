package es.kiketurry.talentobank.ui.accountslist;

import java.util.List;

import es.kiketurry.talentobank.domain.models.AccountModel;

public interface AccountsListView {
    
    void showLoading();
    
    void hideLoading();
    
    void showAccounts(List<AccountModel> accountModels);
    
    void showProblem(String message);
}
