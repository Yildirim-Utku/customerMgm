package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) 
                                                             throws Exception{
        httpSecurity.cors().and().csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/users").hasRole("ROLE_ADMIN")
                .requestMatchers(HttpMethod.POST, "/files/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/customers/**").permitAll()
                .anyRequest().authenticated()	
        .and()
        .formLogin();
        return httpSecurity.build();
}
	}