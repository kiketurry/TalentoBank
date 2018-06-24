package es.kiketurry.talentobank.domain.usecase;

import javax.inject.Inject;

import es.kiketurry.talentobank.TalentoBankApplication;
import es.kiketurry.talentobank.data.repository.DataProvider;
import io.reactivex.disposables.Disposable;

public abstract class UseCase {
    
    @Inject
    protected DataProvider dataProvider;
    
    protected Disposable disposable;
    
    public UseCase() {
        TalentoBankApplication.getComponent().inject(this);
    }
    
    public void dispose() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
