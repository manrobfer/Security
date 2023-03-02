package br.com.security.configs;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.logging.Logger;

@Log4j2
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserDetailsService userDetailService;
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
      auth
              .userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder);


   }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info(":: >> SecurityClass :::  Starting user authentication proccess");
            http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().hasAnyRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin/dashboard")
                .permitAll();
    }

}
