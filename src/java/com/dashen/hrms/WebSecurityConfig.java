/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dashen.hrms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 *
 * @author MulugetaK
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService uds;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(uds);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/javax.faces.resource/**", "/resources/**").permitAll()
                .antMatchers("/login.xhtml").permitAll()
                .antMatchers("/admin/**").hasAuthority(UserAuthority.ADMIN)
                .antMatchers("/user/**").hasAuthority(UserAuthority.USER)
                .antMatchers("/profile/edit/**").hasAuthority(UserAuthority.PROFILE_MAKER) 
                .antMatchers("/profile/approve/**").hasAuthority(UserAuthority.PROFILE_CHECKER)
                .antMatchers("/leave/approve/**").hasAuthority(UserAuthority.PROFILE_CHECKER)
                .antMatchers("/leave/LeaveType.xhtml").hasAuthority(UserAuthority.ADMIN)
                .antMatchers("/hr/**").hasAuthority(UserAuthority.HR_ADMIN)          
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.xhtml").permitAll()
                .defaultSuccessUrl("/dashboard.xhtml")
                .failureUrl("/login.xhtml?error")
                .and()
                .logout()
                .logoutUrl("/logout.xhtml")
                .logoutSuccessUrl("/login.xhtml?logout")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling().accessDeniedPage("/accessdenied.xhtml")
                .and()
                .csrf().disable();        
    }

}
