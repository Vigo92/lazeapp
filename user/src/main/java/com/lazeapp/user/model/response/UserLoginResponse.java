package com.lazeapp.user.model.response;

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
public class UserLoginResponse {

    private String message;

    private String code;

    private LocalDateTime time;
}
