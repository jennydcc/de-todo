package edu.integrador2.serviciosgenerales.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.request.RequestContextListener;

import edu.integrador2.serviciosgenerales.security.AppAuthenticationEntryPoint;
import edu.integrador2.serviciosgenerales.security.AppUrlAuthenticationFailureHandler;
import edu.integrador2.serviciosgenerales.security.PathTokens;
import edu.integrador2.serviciosgenerales.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  AppAuthenticationEntryPoint authenticationEntryPoint;

  @Autowired
  AppUrlAuthenticationFailureHandler appUrlAuthenticationFailureHandler;

  @Autowired
  UsuarioService usuarioService;

  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  @Bean
  public PathTokens pathTokens() {
    return new PathTokens(Arrays.asList("cliente", "especialista", "administrador"));
  }
  @Bean 
  public RequestContextListener requestContextListener(){
      return new RequestContextListener();
  } 
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
      .antMatchers(
        "/",
        "/error",
        "/images/*",
        "/js/*",
        "/styles/*",
        "/login",
        "/api/**",
        "/usuario-login",
        "/cliente/login*",
        "/cliente/registrar*",
        "/especialista/registrar*",
        "/especialista/login*",
        "/administrador/registrar*",
        "/administrador/login*"
        //"/**"
      ).permitAll()
      .anyRequest()
      .authenticated()

      .and()
      .formLogin()
      .loginPage("/j_spring_security_check")
      .defaultSuccessUrl("/")
      .failureHandler(appUrlAuthenticationFailureHandler)

      .and()
      .logout()
      .logoutUrl("/logout")
      .logoutSuccessUrl("/")
      .deleteCookies("JSESSIONID");
    http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
  }
  @Autowired
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(usuarioService).passwordEncoder(bCryptPasswordEncoder);
  }
}
