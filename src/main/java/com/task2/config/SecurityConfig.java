package com.task2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.task2.security.CustomUserDetailsService;
import org.springframework.http.HttpMethod;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // Public Contact Submission
                .requestMatchers(HttpMethod.POST, "/api/contacts")
                .permitAll()

                // Admin Only
                .requestMatchers(HttpMethod.GET, "/api/contacts")
                .hasRole("ADMIN")

                // Dashboard
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")

                .anyRequest()
                .authenticated()
            )

            .formLogin(form -> form

                .defaultSuccessUrl("/admin/dashboard", true)

                .permitAll()
            )

            .exceptionHandling(exception -> exception

                .accessDeniedPage("/access-denied")
            )

            .logout(logout -> logout

                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider =
                new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(
                customUserDetailsService);

        authProvider.setPasswordEncoder(
                passwordEncoder());

        return authProvider;
    }
}