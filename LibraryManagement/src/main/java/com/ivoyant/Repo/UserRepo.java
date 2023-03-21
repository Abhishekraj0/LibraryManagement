package com.ivoyant.Repo;

import com.ivoyant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findByusername(String username);
}
