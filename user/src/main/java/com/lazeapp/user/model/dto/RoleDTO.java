package com.lazeapp.user.model.dto;

import lombok.*;

import java.util.List;

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
public class RoleDTO {

        private String name;

        private String description;

        private List<RoleDTO> eventsList;
}
