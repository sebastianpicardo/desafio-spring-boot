package com.sp.api_spa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.http.HttpMethod;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SecurityConfig {

	@Autowired
	private JwtUtil jwtUtil;
	@Bean
	public JwtFilter jwtFilter() {
	    return new JwtFilter(jwtUtil);
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desactiva CSRF para permitir autenticación basada en tokens.
            .authorizeHttpRequests(auth -> auth
            		 .requestMatchers("/auth/login", "/swagger-ui/**","/swagger-ui/index.html", "/v3/api-docs/**").permitAll() // Permite accesoW sin autenticación
            		 .requestMatchers(HttpMethod.POST, "/api/tareas").authenticated()
                     .requestMatchers(HttpMethod.GET, "/api/tareas").authenticated()
            		 .anyRequest().authenticated()
            )
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //Asocia el filtro JWT  antes del UsernamePasswordAuthenticationFilter
            .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}