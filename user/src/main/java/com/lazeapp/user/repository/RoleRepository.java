package com.lazeapp.user.repository;

import com.lazeapp.user.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 20/10/2022
 **/
public interface RoleRepository  extends JpaRepository<Role, Long> {
}
