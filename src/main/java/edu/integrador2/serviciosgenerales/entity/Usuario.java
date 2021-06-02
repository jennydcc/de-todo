package edu.integrador2.serviciosgenerales.entity;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase base para Administrador/Cliente/Especialista
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Usuario extends BaseEntity<Long> implements UserDetails {

  private String nombre;
  private TipoUsuario tipoUsuario = TipoUsuario.ESPECIALISTA;

  @Column(unique = true, nullable = false)
  private String correo;

  private String contrasena;

  private Boolean bloqueado = false;

  private Boolean habilitado = true;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(tipoUsuario.name());
    return Collections.singletonList(simpleGrantedAuthority);
  }

  @Override
  public String getPassword() {
    return contrasena;
  }

  @Override
  public String getUsername() {
    return correo;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !bloqueado;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return habilitado;
  }
}
