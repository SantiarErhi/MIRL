package org.santiarerhi.mirl.api.repository;

import org.santiarerhi.mirl.api.model.EventParticipationRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class EventParticipationRequestRepository implements CrudRepository<EventParticipationRequest, Long> {
    @Override
    public <S extends EventParticipationRequest> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends EventParticipationRequest> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<EventParticipationRequest> findById(Long aLong) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Long aLong) {
        return false;
    }
    
    @Override
    public Iterable<EventParticipationRequest> findAll() {
        return null;
    }
    
    @Override
    public Iterable<EventParticipationRequest> findAllById(Iterable<Long> longs) {
        return null;
    }
    
    @Override
    public long count() {
        return 0;
    }
    
    @Override
    public void deleteById(Long aLong) {
    
    }
    
    @Override
    public void delete(EventParticipationRequest entity) {
    
    }
    
    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends EventParticipationRequest> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
