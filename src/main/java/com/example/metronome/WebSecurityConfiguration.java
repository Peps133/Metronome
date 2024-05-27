package com.example.metronome;

import Entity.User;
import Repository.UserRepository;
import Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Optional;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        prePostEnabled = true, proxyTargetClass = true
)
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
                        (req) -> req.requestMatchers(
                                        AntPathRequestMatcher.antMatcher("/h2-console/**"),
                                        AntPathRequestMatcher.antMatcher("/init/**"),
                                        AntPathRequestMatcher.antMatcher("/"),
                                        AntPathRequestMatcher.antMatcher("/css/**"),
                                        AntPathRequestMatcher.antMatcher("/js/**"),
                                        AntPathRequestMatcher.antMatcher("/img/**"),
                                        AntPathRequestMatcher.antMatcher("/register/**")
                                )
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                ).formLogin(
                        (form) -> form.loginPage("/login").defaultSuccessUrl("/", true).permitAll())
                .rememberMe(
                        (rememberMe) -> rememberMe.key("remember-me-key").tokenValiditySeconds(7 * 24 * 60 * 60)
                ).logout(
                        (logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll())
                .headers(
                        (headers) -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                )
                .exceptionHandling(
                        (exceptionHandling) -> exceptionHandling.accessDeniedPage("/error"));
        return http.build();
    }

    @Primary
    @Bean
    public UserDetailsService getUserDetailsService() {
        return new UserService();
    }

    @Bean
    public UserRepository userRepository() {
        // Optional: You can inject dependencies here if needed for UserRepository
        return new UserRepository() {
            @Override
            public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<User> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<User> findAll() {
                return null;
            }

            @Override
            public Iterable<User> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(User entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends User> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public User findByUsername(String username) {
                return null;
            }

            @Override
            public Optional<User> findByLoginOrEmail(String username, String username1) {
                return Optional.empty();
            }

            @Override
            public User save(User user) {
                return null;
            }
        };
    }
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean

    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(getPasswordEncoder());
        return auth;
    }

}
