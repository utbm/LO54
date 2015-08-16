package com.mycompany.sp4.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.savedrequest.NullRequestCache;
import com.oakfusion.security.CookieSecurityContextRepository;
import com.oakfusion.security.SecurityCookieService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

    public SecurityContextRepository securityContextRepository() {
        return new CookieSecurityContextRepository(securityCookieService());
    }

    private SecurityCookieService securityCookieService() {
        return new SecurityCookieService("spring-cookie-session", "jmccu2j73983kjiw88");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .securityContext()
                .securityContextRepository(securityContextRepository())
                .and()
                .requestCache().requestCache(new NullRequestCache())
                .and()
                .formLogin()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }
}
