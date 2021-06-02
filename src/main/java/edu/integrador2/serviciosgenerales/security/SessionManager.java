package edu.integrador2.serviciosgenerales.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import edu.integrador2.serviciosgenerales.entity.Usuario;

public class SessionManager {

    private static final Logger log = LoggerFactory.getLogger(SessionManager.class);
    private static final SessionManager instance = new SessionManager();

    public static SessionManager getInstance() {
        return instance;
    }

    public static Usuario getUsuario() throws Exception {
        return instance.get();
    }

    public Usuario get() throws Exception {
        Usuario usuario = null;
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                usuario = (Usuario) auth.getPrincipal();
            }
        } catch (ClassCastException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return usuario;
    }

    public boolean isAutentication() {
        Usuario info = null;
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null) {
                info = (Usuario) auth.getPrincipal();
            }
        } catch (ClassCastException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return info != null;
    }

    public void add(Usuario info) {
        Collection<? extends GrantedAuthority> authorities = getAuthorities("ROLE_ADMIN");
        Authentication nwahtu = new UsernamePasswordAuthenticationToken(info, info.getId(), authorities);
        SecurityContextHolder.getContext().setAuthentication(nwahtu);
    }

    public void add(Usuario info, String rol) {
        Collection<? extends GrantedAuthority> authorities = getAuthorities(rol);
        Authentication nwahtu = new UsernamePasswordAuthenticationToken(info, info.getId(), authorities);
        SecurityContextHolder.getContext().setAuthentication(nwahtu);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String rol) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(rol));
        return authorities;
    }

}
