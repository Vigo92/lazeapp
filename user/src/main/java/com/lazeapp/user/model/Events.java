package com.lazeapp.user.model;

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
public class Events {

    private String name;

    private String description;
}
