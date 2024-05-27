package com.example.metronome;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/metronome-sessions/**").authenticated()
                                .anyRequest().permitAll()
                )
                .formLogin(login -> login
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();

        var user = User.withUsername("user")
                .password("{noop}password")
                .roles("USER")
                .build();

        var admin = User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();

        userDetailsService.createUser(user);
        userDetailsService.createUser(admin);

        return userDetailsService;
    }
}
