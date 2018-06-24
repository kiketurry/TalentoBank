package es.kiketurry.talentobank.data.repository.remote.mappers.base;

public interface RequestMapper<M, E> {
    
    E toRequest(M model);
}
