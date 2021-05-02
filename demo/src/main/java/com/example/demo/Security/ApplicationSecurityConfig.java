package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) //COMING NEXT SECTION VERY IMPORTANT CSRF TOKEN "cross site request forgery"
            //.and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/", "index", "/css/", "/js/*").permitAll()
            .antMatchers("/api/v1/students/*").hasRole(ApplicationUserRole.STUDENT.name())
            //.antMatchers(HttpMethod.DELETE, "/management/api/v1/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
            //.antMatchers(HttpMethod.POST, "/management/api/v1/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
            //.antMatchers(HttpMethod.PUT, "/management/api/v1/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
            //.antMatchers(HttpMethod.GET, "/management/api/v1/**").hasAnyRole(ApplicationUserRole.ADMIN.name(), ApplicationUserRole.ADMINTRAINEE.name())
            .anyRequest()
            .authenticated()
            .and()
            .formLogin();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        UserDetails gregerUser = User.builder()
            .username("Greger")
            .password(passwordEncoder.encode("password"))
            //.roles(ApplicationUserRole.STUDENT.name()) // ROLE_STUDENT*/
            .authorities(ApplicationUserRole.STUDENT.getGrantedAuthorities())
            .build();

        UserDetails ragnarUser = User.builder()
            .username("Ragnar")
            .password(passwordEncoder.encode("password123"))
            //.roles(ApplicationUserRole.ADMIN.name()) //ROLE_ADMIN*/
            .authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
            .build();

        UserDetails tomUser = User.builder()
            .username("Tom")
            .password(passwordEncoder.encode("password123"))
            //.roles(ApplicationUserRole.ADMINTRAINEE.name()) //ROLE_ADMINTRAINEE*/
            .authorities(ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities())
            .build();

        return new InMemoryUserDetailsManager(
            gregerUser, 
            ragnarUser,
            tomUser
        );
    };
};
