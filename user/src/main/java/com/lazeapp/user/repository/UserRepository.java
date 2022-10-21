package com.lazeapp.user.repository;

import com.lazeapp.user.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 20/10/2022
 **/
public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update AppUser  a set a.active = true , a.locked = false where a.email = ?1")
    void enableUser(String email);
}
