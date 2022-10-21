package com.lazeapp.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 20/10/2022
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginRequest {

    private String email;

    private String password;
}
