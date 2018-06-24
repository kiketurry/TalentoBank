package es.kiketurry.talentobank.domain.models;

public class AccountModel {
    
    private long accountBalanceInCents;
    private String accountCurrency;
    private long accountId;
    private String accountName;
    private String accountNumber;
    private String accountType;
    private String alias;
    private boolean isVisible;
    private String iban;
    
    
    public long getAccountBalanceInCents() {
        return accountBalanceInCents;
    }
    
    public void setAccountBalanceInCents(long accountBalanceInCents) {
        this.accountBalanceInCents = accountBalanceInCents;
    }
    
    public String getAccountCurrency() {
        return accountCurrency;
    }
    
    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }
    
    public long getAccountId() {
        return accountId;
    }
    
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
    
    public String getAccountName() {
        return accountName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public String getAlias() {
        return alias;
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public boolean isVisible() {
        return isVisible;
    }
    
    public void setVisible(boolean visible) {
        isVisible = visible;
    }
    
    public String getIban() {
        return iban;
    }
    
    public void setIban(String iban) {
        this.iban = iban;
    }
}
