package com.lazeapp.user.model.entity;

import com.lazeapp.user.model.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "role")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseEntity implements Serializable {


    private String name;

    private String description;

    @Enumerated
    private UserType userType;
}