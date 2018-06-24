package es.kiketurry.talentobank.data.repository.remote;

import es.kiketurry.talentobank.data.repository.remote.entities.AccountsListEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TalentoBankApiService {
    
    @GET("bins/l0f92")
    Observable<AccountsListEntity> getAccountsList();
}
