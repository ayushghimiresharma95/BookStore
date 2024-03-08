package fi.haagaHelia.BookStore;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import fi.haagaHelia.BookStore.service.UserDetailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableWebSecurity
@ComponentScan("fi.haagaHelia.BookStore")
public class WebSecurityConfiguration {
    @Autowired
    private UserDetailServiceImpl userDetailsService;
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception{
        MvcRequestMatcher.Builder mvcMatchBuilder = new MvcRequestMatcher.Builder(introspector);
        return http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests.requestMatchers("/content/**").permitAll()
        .requestMatchers("/booklist/**").hasRole("ADMIN")
        .requestMatchers("/booklist/**").hasRole("USER")
        .requestMatchers("/**").permitAll())
        .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/booklist", true).permitAll())
        .logout(logout -> logout.permitAll()).build();
    
    }
    
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
            .inMemoryAuthentication()
                .passwordEncoder(bcryptPasswordEncoder())
                .withUser("user").password(bcryptPasswordEncoder().encode("user")).roles("USER")
            .and()
                .passwordEncoder(bcryptPasswordEncoder())
                .withUser("admin").password(bcryptPasswordEncoder().encode("admin")).roles("ADMIN");
	}
}

