package com.lazeapp.user.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 21/10/2022
 **/

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResourceNotFoundException extends Exception{

    private String message;

    private String code;

}
