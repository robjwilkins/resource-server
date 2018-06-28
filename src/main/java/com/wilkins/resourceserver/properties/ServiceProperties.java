package com.wilkins.resourceserver.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "service")
@Data
@NoArgsConstructor
public class ServiceProperties {
    private String securityRealm;
    private String resourceId;
    private String clientId;
    private String clientSecret;
}
