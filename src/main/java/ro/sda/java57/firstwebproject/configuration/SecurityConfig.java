package ro.sda.java57.firstwebproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        PasswordEncoder bcrypt = passwordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.builder().username("user").password("password").roles("USER").passwordEncoder(bcrypt::encode).build());
//        manager.createUser(User.builder().username("user2").password("password").roles("USER").passwordEncoder(bcrypt::encode).build());
//        manager.createUser(User.builder().username("user3").password("password").roles("ADMIN").passwordEncoder(bcrypt::encode).build());
//        manager.createUser(User.builder().username("user4").password("password").roles("ADMIN").passwordEncoder(bcrypt::encode).build());
//        return manager;
//    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( auth -> auth.requestMatchers(
                        antMatcher("/webjars/**"),
                        antMatcher("/user"),
                        antMatcher("/h2/**"),
                        antMatcher("/")
                                ).permitAll()
                        .requestMatchers(
                                antMatcher("/secured")
                        ).hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .logout(logout->logout.permitAll().clearAuthentication(true).invalidateHttpSession(true));
        return http.build();
    }
}
