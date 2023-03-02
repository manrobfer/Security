package br.com.security;

import br.com.security.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;

public class CustomSecurityUser extends User implements UserDetails {
    private static final long serialVersionUID = -894872301428618658L;

    public CustomSecurityUser() {
    };

    public CustomSecurityUser(User user) {
       System.out.println(" :::: User do CustomSecurityUser " + user);
       this.setAuthorities(user.getAuthorities());
       this.setId(user.getId());
       this.setPassword(user.getPassword());
       this.setUsername(user.getUsername());
       //System.out.println("Authorities found.: " + user.toString());
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


