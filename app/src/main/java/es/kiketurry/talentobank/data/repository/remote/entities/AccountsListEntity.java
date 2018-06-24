package es.kiketurry.talentobank.data.repository.remote.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AccountsListEntity {
    
    @SerializedName("accounts")
    public List<AccountEntity> accounts;
    
    @SerializedName("failedAccountTypes")
    public String failedAccountTypes;
    
    @SerializedName("returnCode")
    public String returnCode;
}
