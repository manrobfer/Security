package br.com.security.model;

import br.com.security.model.Authority;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Log4j2
@Entity
//public class User implements UserDetailsService {
public class User implements Serializable {
    private static final long serialVersionUID = 8898894395155022873L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    public Set<Authority> authorities = new HashSet<>();
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<Authority> getAuthorities() {
        log.warn("Authories retrieved "+ this.authorities);
        return authorities;
    }
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
           return "User{" +
                " id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}