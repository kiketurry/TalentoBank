package es.kiketurry.talentobank.data.repository.remote;

import es.kiketurry.talentobank.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TalentoBankRetrofitClient {
    
    private Retrofit marvelRetrofit = null;
    private TalentoBankApiService talentoBankApiService = null;
    
    public TalentoBankRetrofitClient() {
        if (marvelRetrofit == null) {
            marvelRetrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.TALENTO_BANK_API_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        talentoBankApiService = marvelRetrofit.create(TalentoBankApiService.class);
    }
    
    public TalentoBankApiService getTalentoBankApiService() {
        return talentoBankApiService;
    }
}
