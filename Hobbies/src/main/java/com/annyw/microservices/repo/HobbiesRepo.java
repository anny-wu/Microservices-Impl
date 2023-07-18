package com.annyw.microservices.repo;

import com.annyw.microservices.bean.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbiesRepo extends JpaRepository<Hobbies, Integer> {
    @Query(value ="SELECT name From hobbies INNER JOIN user_hobbies uh on hobbies.id = uh.hobby_id where uh" +
        ".user_id = ?1", nativeQuery = true)
    List<String> getHobbies(@Param("id") int id);
}
