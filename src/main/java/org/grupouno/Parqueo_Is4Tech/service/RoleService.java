package org.grupouno.Parqueo_Is4Tech.service;

import org.grupouno.Parqueo_Is4Tech.model.Role;
import org.grupouno.Parqueo_Is4Tech.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository repository;
    @Override
    public List<String> findRolesByProfileId(Long profileId) {
        List<Role> roles = repository.findRolesByProfileId(profileId);

        // Convertir la lista de objetos Role a una lista de cadenas (los nombres de los roles)
        return roles.stream()
                .map(Role::getRole)
                .collect(Collectors.toList());
    }
    public List<GrantedAuthority> getRolesByProfileId(Long profileId) {
        List<Role> roles = repository.findRolesByProfileId(profileId);
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
}
