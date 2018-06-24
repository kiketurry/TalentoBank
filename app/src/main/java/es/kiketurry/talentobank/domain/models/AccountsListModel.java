package es.kiketurry.talentobank.domain.models;

import java.util.ArrayList;

public class AccountsListModel {
    
    private ArrayList<AccountModel> accounts;
    private String failedAccountTypes;
    private String returnCode;
    
    public ArrayList<AccountModel> getAccounts() {
        return accounts;
    }
    
    public void setAccounts(ArrayList<AccountModel> accounts) {
        this.accounts = accounts;
    }
    
    public String getFailedAccountTypes() {
        return failedAccountTypes;
    }
    
    public void setFailedAccountTypes(String failedAccountTypes) {
        this.failedAccountTypes = failedAccountTypes;
    }
    
    public String getReturnCode() {
        return returnCode;
    }
    
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
}
