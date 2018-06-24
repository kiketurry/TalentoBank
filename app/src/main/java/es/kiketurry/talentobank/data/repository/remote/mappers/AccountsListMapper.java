package es.kiketurry.talentobank.data.repository.remote.mappers;

import java.util.ArrayList;

import es.kiketurry.talentobank.data.repository.remote.entities.AccountEntity;
import es.kiketurry.talentobank.data.repository.remote.entities.AccountsListEntity;
import es.kiketurry.talentobank.data.repository.remote.mappers.base.ResponseMapper;
import es.kiketurry.talentobank.domain.models.AccountModel;
import es.kiketurry.talentobank.domain.models.AccountsListModel;

public class AccountsListMapper implements ResponseMapper<AccountsListEntity, AccountsListModel> {
    @Override
    public AccountsListModel fromResponse(AccountsListEntity accountsListEntity) {
        AccountsListModel accountsListModel = new AccountsListModel();
        
        accountsListModel.setFailedAccountTypes(accountsListEntity.failedAccountTypes);
        accountsListModel.setReturnCode(accountsListEntity.returnCode);
        
        ArrayList<AccountModel> accountModels = new ArrayList<>();
        if (!accountsListEntity.accounts.isEmpty()) {
            AccountMapper accountMapper = new AccountMapper();
            for (AccountEntity account : accountsListEntity.accounts) {
                accountModels.add(accountMapper.fromResponse(account));
            }
        }
        
        accountsListModel.setAccounts(accountModels);
        
        return accountsListModel;
    }
}
