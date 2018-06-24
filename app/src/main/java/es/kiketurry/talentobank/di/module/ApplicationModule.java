package es.kiketurry.talentobank.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.kiketurry.talentobank.data.repository.DataProvider;
import es.kiketurry.talentobank.data.repository.remote.RemoteDataSource;
import es.kiketurry.talentobank.data.repository.remote.TalentoBankRetrofitClient;
import es.kiketurry.talentobank.di.ApplicationContext;
import es.kiketurry.talentobank.domain.usecase.GetAccountsTalentoBankUseCase;

@Module
public class ApplicationModule {
    
    private final Application mApplication;
    
    public ApplicationModule(Application app) {
        mApplication = app;
    }
    
    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }
    
    @Provides
    Application provideApplication() {
        return mApplication;
    }
    
    @Provides
    @Singleton
    DataProvider provideDataProvider() {
        return new DataProvider();
    }
    
    @Provides
    @Singleton
    RemoteDataSource provideRemoteDataSource() {
        return new RemoteDataSource();
    }
    
    @Provides
    @Singleton
    TalentoBankRetrofitClient provideRetrofitClient() {
        return new TalentoBankRetrofitClient();
    }
    
    @Provides
    GetAccountsTalentoBankUseCase provideAccountsTalentoBankUseCase() {
        return new GetAccountsTalentoBankUseCase();
    }
}
