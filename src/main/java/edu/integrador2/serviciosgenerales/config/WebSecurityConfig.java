package edu.integrador2.serviciosgenerales.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.integrador2.serviciosgenerales.service.EspecialistaService;
import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  private final EspecialistaService especialistaService;

  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(
          "/images/**",
          "/js/**",
          "/styles/**",
          "/login-cliente",
           "/registrar-especialista",
           "/registrar-cliente", "/**").permitAll()
           .anyRequest().authenticated()
           .and().formLogin().loginPage("/login-especialista").permitAll()
           .defaultSuccessUrl("/")
           .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
           .invalidateHttpSession(true)
           .deleteCookies("JSESSIONID").permitAll();
  }

  /*
   * @Bean
   * 
   * @Override public UserDetailsService userDetailsService() { UserDetails user =
   * User.withDefaultPasswordEncoder().username("user").password("password").roles
   * ("USER").build();
   * 
   * return new InMemoryUserDetailsManager(user); }
   */

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(especialistaService).passwordEncoder(bCryptPasswordEncoder);
  }
}