package com.lazeapp.user.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "events")
@Entity
public class Events extends BaseEntity implements Serializable {

    private String name;

    private String description;


}