package com.digitalhouse.gestion_odontologica.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/turno").hasAnyRole("USER", "ADMIN")
                .antMatchers("/odontologo", "/paciente", "/usuario").hasRole("ADMIN")
                .and()
                .formLogin().defaultSuccessUrl("/index.html", true)
                .and()
                .rememberMe().userDetailsService(userDetailsService).alwaysRemember(true)
                .and().logout().deleteCookies("JSESSIONID");
                /*
                    En caso de el uso de postman usar
                    .httpBasic();
                    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                */

        http.cors().disable();
        http.csrf().disable();
    }

    @Bean
    public DaoAuthenticationProvider authProvicer(UserDetailsService userDetailsService, PasswordEncoder encoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder);
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
