package com.lazeapp.user.model.response;

import com.lazeapp.user.model.request.UserRegistrationDTO;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 20/10/2022
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationResponse {

    private UserRegistrationDTO userRegistrationDTO;

    private String message;

    private String code;

    private LocalDateTime time;
}
