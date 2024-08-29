package com.SprigMVC.demoSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoConfigSecurity {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select username,password,enabled from users where username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username,authority from roles where username=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure -> configure
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .requestMatchers("/register/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/showLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll())
                .logout(logout -> logout.permitAll())
                .exceptionHandling( configure -> configure.accessDeniedPage("/accessDenied"));
        return http.build();
    }

    /*
    @Bean
    public InMemoryUserDetailsManager UserDetails() {
        UserDetails gowtham = User.builder()
                .username("gowtham")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails vamsi = User.builder()
                .username("vamsi")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails viswa = User.builder()
                .username("viswa")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(gowtham, vamsi, viswa);
    }
    */
}
