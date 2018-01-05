package com.los.config;

import com.los.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nuwantha on 11/21/16.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;


//    @Override
//    public void configure(WebSecurity web) throws Exception {
//
//       // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        //System.out.println("authentication.getName():"+authentication.getName());
//        //User user=((UserDetailsServiceImpl)userDetailsService).getUserService().getUserByName(authentication.getName());
//        //String url = "/users/"+user.getUserId()+"/graph/**";
//
////        web
////                .ignoring()
////                .antMatchers(url);
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        final class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//            @Override
//            public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException {
//                response.sendRedirect("/403");
//            }
//
//        }
        http.csrf().disable();
//        http
//                .csrf()
//                .ignoringAntMatchers("/google-login/**","/api**")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/resources/**","/google-login/**","/login","/errorcustom/**","/403","/","/api**").permitAll()
//                .antMatchers("/registration").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/bulk-leave").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/users/graph/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/users/**/graph/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_PM')")
//                .anyRequest().authenticated()//.antMatchers("/users/18/**/graph/**").permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .and();
////                .exceptionHandling().authenticationEntryPoint(new MyAuthenticationEntryPoint()).accessDeniedPage("/403");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetailsService userDetailsService = new UserDetailsServiceImpl();
        return userDetailsService;
    }


}
