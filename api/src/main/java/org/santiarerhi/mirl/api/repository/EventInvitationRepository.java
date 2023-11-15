package org.santiarerhi.mirl.api.repository;

import org.santiarerhi.mirl.api.model.EventInvitation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class EventInvitationRepository implements CrudRepository<EventInvitation, Long> {
    
    @Override
    public <S extends EventInvitation> S save(S entity) {
        return null;
    }
    
    @Override
    public <S extends EventInvitation> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
    
    @Override
    public Optional<EventInvitation> findById(Long aLong) {
        return Optional.empty();
    }
    
    @Override
    public boolean existsById(Long aLong) {
        return false;
    }
    
    @Override
    public Iterable<EventInvitation> findAll() {
        return null;
    }
    
    @Override
    public Iterable<EventInvitation> findAllById(Iterable<Long> longs) {
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
    public void delete(EventInvitation entity) {
    
    }
    
    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
    
    }
    
    @Override
    public void deleteAll(Iterable<? extends EventInvitation> entities) {
    
    }
    
    @Override
    public void deleteAll() {
    
    }
}
