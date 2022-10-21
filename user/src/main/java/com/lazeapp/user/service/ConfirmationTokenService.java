package com.lazeapp.user.service;

import com.lazeapp.user.model.entity.ConfirmationToken;

import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 21/10/2022
 **/
public interface ConfirmationTokenService {

    ConfirmationToken findConfirmationTokenByToken(String token);

    int updateConfirmationToken(String token, LocalDateTime confirmedAt);
}
