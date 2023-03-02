package br.com.security.repository;

import br.com.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRespository extends JpaRepository<User, Long> {
    @Query(" select u from User u"
         +" left join fetch u.authorities"
         +" where u.username = :username")
    User findUserByUserName(String username);
}


