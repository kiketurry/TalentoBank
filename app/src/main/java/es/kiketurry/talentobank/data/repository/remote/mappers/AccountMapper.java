package es.kiketurry.talentobank.data.repository.remote.mappers;

import es.kiketurry.talentobank.data.repository.remote.entities.AccountEntity;
import es.kiketurry.talentobank.data.repository.remote.mappers.base.ResponseMapper;
import es.kiketurry.talentobank.domain.models.AccountModel;

public class AccountMapper implements ResponseMapper<AccountEntity, AccountModel> {
    
    @Override
    public AccountModel fromResponse(AccountEntity accountEntity) {
        AccountModel accountModel = new AccountModel();
        
        accountModel.setAccountBalanceInCents(accountEntity.accountBalanceInCents);
        accountModel.setAccountCurrency(accountEntity.accountCurrency);
        accountModel.setAccountId(accountEntity.accountId);
        accountModel.setAccountName(accountEntity.accountName);
        accountModel.setAccountNumber(accountEntity.accountNumber);
        accountModel.setAccountType(accountEntity.accountType);
        accountModel.setAlias(accountEntity.alias);
        accountModel.setVisible(accountEntity.isVisible);
        accountModel.setIban(accountEntity.iban);
        
        return accountModel;
    }
}
