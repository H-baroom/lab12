package com.example.lab12w10day2.Repository;

import com.example.lab12w10day2.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

public interface AuthRepository extends JpaRepository<MyUser, Integer> {
    MyUser findMyUserByUsername(String username);
    MyUser findMyUserById(Integer id);

}
