package com.lazeapp.user.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 21/10/2022
 **/

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ErrorResponse {

    private String message;

    private String code;

    private LocalDateTime time;
}
