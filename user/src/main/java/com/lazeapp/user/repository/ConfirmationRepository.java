package com.lazeapp.user.repository;

import com.lazeapp.user.model.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 21/10/2022
 **/
public interface ConfirmationRepository extends JpaRepository<ConfirmationToken,Long> {

    Optional<ConfirmationToken> findByToken(String token);

    @Modifying
    @Transactional
    @Query("update  ConfirmationToken  c set c.confirmedAt = ?1 where c.token = ?2")
    int updateConfirmationToken(String token, LocalDateTime confirmedAt);
}
