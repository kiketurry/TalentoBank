package es.kiketurry.talentobank.data.repository.remote;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import es.kiketurry.talentobank.TalentoBankApplication;
import es.kiketurry.talentobank.data.repository.DataSource;
import es.kiketurry.talentobank.domain.models.AccountsListModel;
import io.reactivex.Observable;
import io.reactivex.Observer;

public class RemoteDataSource implements DataSource {
    
    private Context context;
    
    public RemoteDataSource() {
        context = TalentoBankApplication.getComponent().getContext();
    }
    
    @Override
    public Observable<AccountsListModel> listAccounts() {
        
        String json = readJSONFromAsset("accounts_list_ok.json");
        
        AccountsListModel accountsListModel = new Gson().fromJson(json, AccountsListModel.class);
        
        return new Observable<AccountsListModel>() {
            @Override
            protected void subscribeActual(Observer<? super AccountsListModel> observer) {
                observer.onNext(accountsListModel);
                observer.onComplete();
            }
        };
    }
    
    private String readJSONFromAsset(String nameJson) {
        String json;
        try {
            InputStream is = context.getAssets().open(nameJson);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
