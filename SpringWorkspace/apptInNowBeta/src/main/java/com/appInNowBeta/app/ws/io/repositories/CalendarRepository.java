package com.appInNowBeta.app.ws.io.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.appInNowBeta.app.ws.io.entity.CalendarEntity;

@Repository
public interface CalendarRepository extends CrudRepository<CalendarEntity, Long>  {

	CalendarEntity findCalendarByEmail(String Email);
	CalendarEntity findCalendarByUserId(String userId);
	
	@Query(value = "select * from calendar where user_id = :userId",nativeQuery = true)
	List<CalendarEntity> findCalendarAppointmentsByUserId(@Param("userId") String userId);

	
}
