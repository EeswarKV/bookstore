package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  /**
   * Basic Auth users (simple + local-dev friendly).
   *
   * Credentials:
   *   username: admin
   *   password: admin123
   */
  @Bean
  public UserDetailsService userDetailsService(PasswordEncoder encoder) {
    UserDetails admin = User.withUsername("admin")
        .password(encoder.encode("admin123"))
        .roles("ADMIN")
        .build();

    return new InMemoryUserDetailsManager(admin);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        // REST API: no server-side sessions
        .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        // For browser-based frontend calls
        .cors(Customizer.withDefaults())
        // Disable CSRF for stateless APIs
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            // Let browser preflight requests through
            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            // Avoid Spring's /error being blocked into weird loops
            .requestMatchers("/error").permitAll()
            // Everything else must be authenticated
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults());

    return http.build();
  }
}
