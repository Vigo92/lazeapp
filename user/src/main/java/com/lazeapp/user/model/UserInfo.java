package com.lazeapp.user.model;

import com.lazeapp.user.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 20/10/2022
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {

    private Gender gender;

    private LocalDate dob;

    private String dateRange;

}
