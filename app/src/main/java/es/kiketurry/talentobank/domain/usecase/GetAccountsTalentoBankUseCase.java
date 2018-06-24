package es.kiketurry.talentobank.domain.usecase;

import es.kiketurry.talentobank.domain.models.AccountsListModel;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class GetAccountsTalentoBankUseCase extends UseCase {
    
    public void execute(Action actionComplete, Consumer<AccountsListModel> success, Consumer<Throwable> failure) {
        disposable = dataProvider.listAccounts().subscribe(success, failure, actionComplete);
    }
}
