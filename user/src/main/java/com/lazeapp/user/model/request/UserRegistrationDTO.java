package com.lazeapp.user.model.request;

import com.lazeapp.user.model.AddressDTO;
import com.lazeapp.user.model.Events;
import com.lazeapp.user.model.UserInfo;
import com.lazeapp.user.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 20/10/2022
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationDTO {



    private String userName;

    private String firstName;

    private String lastName;

    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Enter a valid email!")
    private String email;

    @NotBlank(message = "Email cannot be blank!")
    @Size(min = 8, max = 30, message = "Password length must be between 8 and 30!")
    private String password;

    private AddressDTO address;

    private Set<Events> eventsSet;

    private UserInfo userInfo;

    private UserType userType;
}
