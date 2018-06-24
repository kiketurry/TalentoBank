package es.kiketurry.talentobank.data.repository.remote.entities;

import com.google.gson.annotations.SerializedName;

public class AccountEntity {
    
    @SerializedName("accountBalanceInCents")
    public long accountBalanceInCents;
    
    @SerializedName("accountCurrency")
    public String accountCurrency;
    
    @SerializedName("accountId")
    public long accountId;
    
    @SerializedName("accountName")
    public String accountName;
    
    @SerializedName("accountNumber")
    public String accountNumber;
    
    @SerializedName("accountType")
    public String accountType;
    
    @SerializedName("alias")
    public String alias;
    
    @SerializedName("isVisible")
    public boolean isVisible;
    
    @SerializedName("iban")
    public String iban;
}
