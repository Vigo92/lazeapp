package com.lazeapp.user.service.impl;

import com.lazeapp.user.exceptions.ResourceNotFoundException;
import com.lazeapp.user.model.AddressDTO;
import com.lazeapp.user.model.UserInfo;
import com.lazeapp.user.model.entity.Address;
import com.lazeapp.user.model.entity.AppUser;
import com.lazeapp.user.model.entity.ConfirmationToken;
import com.lazeapp.user.model.request.UserLoginRequest;
import com.lazeapp.user.model.request.UserRegistrationDTO;
import com.lazeapp.user.model.response.ResponseCodes;
import com.lazeapp.user.model.response.ResponseMessage;
import com.lazeapp.user.model.response.UserLoginResponse;
import com.lazeapp.user.model.response.UserRegistrationResponse;
import com.lazeapp.user.repository.UserRepository;
import com.lazeapp.user.service.ConfirmationTokenService;
import com.lazeapp.user.service.EmailService;
import com.lazeapp.user.service.UserService;
import com.lazeapp.user.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 20/10/2022
 **/

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder bcryptPasswordEncoder;
    private final EmailService emailService;
    private final ConfirmationTokenService confirmationTokenService;

    @Value("base-url:http://localhost:8080/api/v1/registration/confirm?token=")
    private String baseUrl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public UserRegistrationResponse register(UserRegistrationDTO userRegistrationDTO) throws MessagingException {
      validateEmail(userRegistrationDTO.getEmail());
        AppUser appUser = convertDataToEntity(userRegistrationDTO);
        userRepository.save(appUser);
        ConfirmationToken confirmationToken = buildConfirmationToken(appUser);
        String confirmationLink = baseUrl + confirmationToken.getToken();
        emailService.sendEmail(userRegistrationDTO.getEmail(), EmailUtil.buildEmail(userRegistrationDTO.getFirstName().concat(" ").concat(userRegistrationDTO.getLastName()),confirmationLink));
        return UserRegistrationResponse.builder().code(ResponseCodes.SUCCESS).message(ResponseMessage.SUCCESSFUL_SIGNUP).time(LocalDateTime.now()).build();
    }

    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        return null;
    }

    @Override
    @Cacheable(value = "userCache")
    public UserRegistrationResponse getUserDetails(String email) throws ResourceNotFoundException {
        return convertEntityToData(userRepository.findByEmail(email).orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    @Transactional
    public UserRegistrationResponse confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);
        if(Objects.nonNull(confirmationToken.getConfirmedAt())){
            throw new RuntimeException("");
        }
        if(LocalDateTime.now().isAfter(confirmationToken.getExpiresAt())){
            throw new RuntimeException("");
        }
        confirmationToken.setConfirmedAt(LocalDateTime.now());
        confirmationTokenService.updateConfirmationToken(token, LocalDateTime.now());
        userRepository.enableUser(confirmationToken.getAppUser().getEmail());
        return UserRegistrationResponse.builder().code(ResponseCodes.SUCCESS).message(ResponseMessage.CONFIRMED).time(LocalDateTime.now()).build();
    }

    private void validateEmail(String email){
        if(userRepository.findByEmail(email).isPresent()){
            throw new RuntimeException("");
        }
    }

    private AppUser convertDataToEntity(UserRegistrationDTO userRegistrationDTO){
        return AppUser.builder().email(userRegistrationDTO.getEmail())
        .password(bcryptPasswordEncoder.encode(userRegistrationDTO.getPassword()))
        .address(Address.builder().address(userRegistrationDTO.getAddress().getAddress())
                .city(userRegistrationDTO.getAddress().getCity()).country(userRegistrationDTO.getAddress().getCountry())
                .build()).userName(userRegistrationDTO.getUserName()).firstName(userRegistrationDTO.getFirstName())
                .lastName(userRegistrationDTO.getLastName()).gender(userRegistrationDTO.getUserInfo().getGender())
                .build();
    }

    private UserRegistrationResponse convertEntityToData(AppUser appUser){
        return UserRegistrationResponse.builder().userRegistrationDTO(UserRegistrationDTO.builder().email(appUser.getEmail())
                .address(AddressDTO.builder().address(appUser.getAddress().getAddress())
                        .city(appUser.getAddress().getCity()).country(appUser.getAddress().getCountry())
                        .build()).userName(appUser.getUsername()).firstName(appUser.getFirstName())
                .lastName(appUser.getLastName()).userInfo(UserInfo.builder().gender(appUser.getGender())
                        .build())
                .build()).time(LocalDateTime.now()).message(ResponseMessage.SUCCESS).code(ResponseCodes.SUCCESS).build();
    }

    private ConfirmationToken buildConfirmationToken(AppUser appUser){
        return ConfirmationToken.builder().appUser(appUser)
                .token(UUID.randomUUID().toString()).expiresAt(LocalDateTime.now().plusMinutes(15))
                .build();
    }
}
