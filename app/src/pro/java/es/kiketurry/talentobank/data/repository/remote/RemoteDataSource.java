package es.kiketurry.talentobank.data.repository.remote;

import javax.inject.Inject;

import es.kiketurry.talentobank.TalentoBankApplication;
import es.kiketurry.talentobank.data.repository.DataSource;
import es.kiketurry.talentobank.data.repository.remote.mappers.AccountsListMapper;
import es.kiketurry.talentobank.domain.models.AccountsListModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RemoteDataSource implements DataSource {
    
    @Inject
    TalentoBankRetrofitClient talentoBankRetrofitClient;
    
    public RemoteDataSource() {
        TalentoBankApplication.getComponent().inject(this);
    }
    
    @Override
    public Observable<AccountsListModel> listAccounts() {
        return talentoBankRetrofitClient.getTalentoBankApiService().getAccountsList()
                .map(accountsListEntity -> new AccountsListMapper().fromResponse(accountsListEntity))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread());
    }
}
