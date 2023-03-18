package com.myproject.habitapp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myproject.habitapp.model.Routine;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Integer> {
	@Query("SELECT r FROM Routine r WHERE r.user.userId = :userId")
    List<Routine> findAllByUserId(@Param("userId") int userId);
	Optional<Routine> findById(int id);	
}
