package es.kiketurry.talentobank;

import android.app.Application;

import es.kiketurry.talentobank.di.component.ApplicationComponent;
import es.kiketurry.talentobank.di.component.DaggerApplicationComponent;
import es.kiketurry.talentobank.di.module.ApplicationModule;

public class TalentoBankApplication extends Application {
    protected static ApplicationComponent applicationComponent;
    
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }
    
    public static ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
