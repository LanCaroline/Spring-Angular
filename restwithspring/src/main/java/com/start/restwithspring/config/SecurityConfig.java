package com.start.restwithspring.config;

import com.start.restwithspring.jwt.JwtAuthenticationEntryPoint;
import com.start.restwithspring.jwt.JwtRequestFilter;
import com.start.restwithspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    @Autowired
    public UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("kaique")
                .password("{noop}123456")
                .roles("USER");
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/auth/signin").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/produto/**").hasAnyRole("ADMIN")
                .antMatchers("/order/**").authenticated()
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        //{noop} usado para ignorar a necessidade de criptografia de senha do usuário
//        //sem {noop} é necessário a utilização de criptografica de senha
//        auth.inMemoryAuthentication()
//        .withUser("usuario")
//        .password("{noop}password")
//        .roles("USER");
//    }
}
