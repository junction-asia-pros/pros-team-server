package com.pros.pick.domain.user.repository;

import com.pros.pick.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByDeviceKey(String deviceKey);
}
