package dev.jaysyat.hospital_management_saiba.config;

import dev.jaysyat.hospital_management_saiba.services.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetails userDetails;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/js/**", "/css/**", "/images/**").permitAll()
                        .requestMatchers("/registerhospital").permitAll()
                        .requestMatchers("/hospital/registration").permitAll()
                        .requestMatchers("/createaccount").permitAll()
                        .requestMatchers("/useraccount/registration").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/hgrgomadashboard").hasRole("HGR-GOMA")
                        .requestMatchers("/healafricadashboard").hasRole("HEAL-AFRICA")
                        .requestMatchers("/registerpatienthealafrica").hasRole("HEAL-AFRICA")
                        .requestMatchers("/registerpatient/healafrica").hasRole("HEAL_AFRICA")
                        .requestMatchers("logout").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .successHandler(new AuthenticationSuccessHandler())
                        .loginPage("/login")
                )
                .logout(config -> config.logoutSuccessUrl("/"))
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetails);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


}
