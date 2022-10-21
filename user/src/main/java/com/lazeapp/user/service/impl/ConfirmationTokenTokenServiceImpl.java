package com.lazeapp.user.service.impl;

import com.lazeapp.user.model.entity.ConfirmationToken;
import com.lazeapp.user.repository.ConfirmationRepository;
import com.lazeapp.user.service.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 21/10/2022
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public class ConfirmationTokenTokenServiceImpl implements ConfirmationTokenService {

    private final ConfirmationRepository confirmationRepository;

    @Override
    public ConfirmationToken findConfirmationTokenByToken(String token) {
       return confirmationRepository.findByToken(token).orElseThrow(RuntimeException::new);
    }

    @Override
    public int updateConfirmationToken(String token, LocalDateTime confirmedAt) {
        return confirmationRepository.updateConfirmationToken(token,confirmedAt);
    }
}
