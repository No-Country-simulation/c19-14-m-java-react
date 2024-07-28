package com.example.appAdopcionDeMascota.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class UserDetailsImpl implements UserDetails {
    private Long userId;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    // Constructor
    public UserDetailsImpl(Long userId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Cambia esto según tu lógica de negocio
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Cambia esto según tu lógica de negocio
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Cambia esto según tu lógica de negocio
    }

    @Override
    public boolean isEnabled() {
        return true; // Cambia esto según tu lógica de negocio
    }
}
