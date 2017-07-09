package com.fast87.journal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableAuthorizationServer
@EnableResourceServer
public class Resource0AuthSercurityConfiguration extends ResourceServerConfigurerAdapter{
    /**
     * 호출 : curl -i localhost:8080/oauth/token -d "grant_type=password&scope=read&username=test&password=testpw" -u e61fd6fb-641d-41d7-a883-359e1f40b870:5067556e-9712-41f8-bc3c-2071349dd67a
     * 액세스토큰 이용 : curl -i -H "Authorization: bearer 56a5705f-bc41-4766-9931-1e56343b3232" localhost:8080/api
    * */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/**").authenticated();
    }
}

