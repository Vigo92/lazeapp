package com.lazeapp.user.service;

import com.lazeapp.user.exceptions.ResourceNotFoundException;
import com.lazeapp.user.model.request.UserLoginRequest;
import com.lazeapp.user.model.request.UserRegistrationDTO;
import com.lazeapp.user.model.response.UserLoginResponse;
import com.lazeapp.user.model.response.UserRegistrationResponse;

import javax.mail.MessagingException;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 20/10/2022
 **/
public interface UserService {

    UserRegistrationResponse register(UserRegistrationDTO userRegistrationDTO) throws MessagingException;

    UserLoginResponse login(UserLoginRequest userLoginRequest);

    UserRegistrationResponse getUserDetails(String email) throws ResourceNotFoundException;

    UserRegistrationResponse confirmToken(String token);
}
