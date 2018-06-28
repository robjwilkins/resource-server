package com.wilkins.resourceserver.config;

import com.wilkins.resourceserver.properties.ServiceProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration @AllArgsConstructor
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final ServiceProperties serviceProperties;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(serviceProperties.getResourceId()).tokenServices(tokenServices()).stateless(true);
    }

    @Bean @Primary
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
        tokenServices.setClientId(serviceProperties.getClientId());
        tokenServices.setClientSecret(serviceProperties.getClientSecret());
        return tokenServices;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers("/actuator/**", "/api-docs/**", "/api/account/*/unlock", "/api/account/lock").permitAll()
                .antMatchers("/api/**").authenticated();
    }
}
