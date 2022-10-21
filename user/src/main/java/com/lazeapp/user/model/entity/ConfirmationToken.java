package com.lazeapp.user.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 20/10/2022
 **/

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "confirmation_token", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"token" } )
})
public class ConfirmationToken extends BaseEntity {

    @Column(nullable = false)
    private String token;

    @ManyToOne
    @JoinColumn(nullable = false, name = "appuser_id")
    private AppUser appUser;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;


}
