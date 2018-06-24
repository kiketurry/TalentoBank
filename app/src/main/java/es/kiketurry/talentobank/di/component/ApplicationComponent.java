package es.kiketurry.talentobank.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import es.kiketurry.talentobank.TalentoBankApplication;
import es.kiketurry.talentobank.data.repository.DataProvider;
import es.kiketurry.talentobank.data.repository.remote.RemoteDataSource;
import es.kiketurry.talentobank.data.repository.remote.TalentoBankRetrofitClient;
import es.kiketurry.talentobank.di.ApplicationContext;
import es.kiketurry.talentobank.di.module.ApplicationModule;
import es.kiketurry.talentobank.domain.usecase.GetAccountsTalentoBankUseCase;
import es.kiketurry.talentobank.domain.usecase.UseCase;
import es.kiketurry.talentobank.ui.accountslist.AccountsListPresenter;
import es.kiketurry.talentobank.ui.accountslist.AccountsListView;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    
    void inject(TalentoBankApplication talentoBankApplication);
    
    void inject(GetAccountsTalentoBankUseCase getAccountsTalentoBankUseCase);
    
    void inject(RemoteDataSource remoteDataSource);
    
    void inject(DataProvider dataProvider);
    
    void inject(AccountsListPresenter accountsListPresenter);
    
    void inject(UseCase useCase);
    
    void inject(AccountsListView accountsListView);
    
    @ApplicationContext
    Context getContext();
    
    Application getApplication();
    
    DataProvider getDataProvider();
    
    TalentoBankRetrofitClient getTalentoBankRetrofitClient();
}
