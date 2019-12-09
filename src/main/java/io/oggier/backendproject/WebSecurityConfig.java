package io.oggier.backendproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // Creating two user for the demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("student").password("{noop}student").roles("STUDENT")
                .and()
                .withUser("teacher").password("{noop}teacher").roles("STUDENT", "TEACHER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/**").hasAnyRole("STUDENT", "TEACHER")
                .antMatchers(HttpMethod.POST, "/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.PUT, "/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.DELETE, "/**").hasRole("TEACHER")
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}
