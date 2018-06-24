package es.kiketurry.talentobank.data.repository;

import es.kiketurry.talentobank.domain.models.AccountsListModel;
import io.reactivex.Observable;

public interface DataSource {
    Observable<AccountsListModel> listAccounts();
}
