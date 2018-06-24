package es.kiketurry.talentobank.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import es.kiketurry.talentobank.TalentoBankApplication;
import es.kiketurry.talentobank.data.repository.remote.RemoteDataSource;
import es.kiketurry.talentobank.domain.models.AccountsListModel;
import io.reactivex.Observable;

@Singleton
public class DataProvider implements DataSource {
    
    @Inject
    RemoteDataSource remoteDataSource;
    
    public DataProvider() {
        TalentoBankApplication.getComponent().inject(this);
    }
    
    @Override
    public Observable<AccountsListModel> listAccounts() {
        return remoteDataSource.listAccounts();
    }
}
