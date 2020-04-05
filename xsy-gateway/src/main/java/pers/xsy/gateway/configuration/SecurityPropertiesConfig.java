package pers.xsy.gateway.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import pers.xsy.gateway.properties.SecurityProperties;

/**
 * @ClassName SecurityPropertiesConfig
 * @Description:
 * @Author XsYounG. Tribute to Alan Turing
 * @Date 2020/4/5
 * @Version V1.0
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityPropertiesConfig {
}
