package com.lazeapp.user.model.dto;

import com.lazeapp.user.model.Events;
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
public class EventDTO {

    private String name;

    private String description;

    private List<Events> eventsList;
}
