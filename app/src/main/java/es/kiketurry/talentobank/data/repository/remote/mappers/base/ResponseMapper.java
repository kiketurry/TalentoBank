package es.kiketurry.talentobank.data.repository.remote.mappers.base;

public interface ResponseMapper<E, M> {
    M fromResponse(E entity);
}
