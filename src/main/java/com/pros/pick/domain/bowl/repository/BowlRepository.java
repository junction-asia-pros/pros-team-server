package com.pros.pick.domain.bowl.repository;

import com.pros.pick.domain.bowl.entity.Bowl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlRepository extends JpaRepository<Bowl, Long> {

}
