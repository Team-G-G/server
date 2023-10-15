package com.jobpair.G.G.auth.Repository;

import com.jobpair.G.G.auth.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
