package org.santiarerhi.mirl.api.repository;

import org.santiarerhi.mirl.api.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long>, CrudRepository<Event, Long> {

}
