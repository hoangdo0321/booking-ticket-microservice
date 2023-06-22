package com.example.scheduleMovieservice.repo;

import com.example.scheduleMovieservice.entity.ScheduleMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleMovieRepository extends JpaRepository<ScheduleMovie, Long> {
    List<ScheduleMovie> findAllByMovieIdOrderByCinemaIdAsc(Long id);
}
