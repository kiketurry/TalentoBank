package es.kiketurry.talentobank.ui.accountslist;

import es.kiketurry.talentobank.domain.models.AccountsListModel;

public interface AccountsListView {
    
    void showLoading();
    
    void hideLoading();
    
    void showSuperHeroes(AccountsListModel accountsListModel);
    
    void showProblem(String message);
}
