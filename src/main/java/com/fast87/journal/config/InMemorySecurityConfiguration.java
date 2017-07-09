package com.fast87.journal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

//@Configuration
//@EnableGlobalMethodSecurity
public class InMemorySecurityConfiguration {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user").password("passwd")
                .roles("USER").and().withUser("admin").password("passwdadm").roles("USER" , "ADMIN");
    }
}
