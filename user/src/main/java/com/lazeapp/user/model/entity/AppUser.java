package com.lazeapp.user.model.entity;

import com.lazeapp.user.model.enums.Gender;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

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
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email", "userName" })
})
public class AppUser extends BaseEntity implements UserDetails, Serializable {


    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private String password;

    @Embedded
    private Address address;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Events events;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Role> role;

   private boolean enabled = false;

   private boolean locked = false;

   private Gender gender;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
