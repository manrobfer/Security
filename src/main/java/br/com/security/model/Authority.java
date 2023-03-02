package br.com.security.model;

import br.com.security.CustomSecurityUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Log4j2
@Entity
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = -7972053982472389157L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {

        this.authority = authority;
        log.info("Autoriddes "+this.authority);
    }

    public User getUser() {
        return user;
    }

    public void setUser(CustomSecurityUser user) {
        this.user = user;
    }

    @Override
    public String getAuthority() {

        log.info("Autoriddes "+this.authority);
        return this.authority;
    }


}
