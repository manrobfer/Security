package br.com.security.service;

import br.com.security.CustomSecurityUser;
import br.com.security.model.User;
import br.com.security.repository.UserRespository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    private UserRespository userRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         User user = userRespository.findUserByUserName(username);
         System.out.println("::: Usuario do loader "+user.getAuthorities());
         System.out.println("::: Authorities do loader "+user.getAuthorities().toString());
         if(user == null){
             throw new UsernameNotFoundException("Bad username or password");
         }
         log.info(" :: Fetched user's details " + user.getAuthorities());
        return new CustomSecurityUser(user);
    }
}
