package pers.xsy.security.configuration;

import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.annotation.Resource;
import java.security.KeyPair;

/**
 * @ClassName OAuth2AuthServerConfig
 * @Description: 认证服务器使用 JWT RSA 非对称加密令牌
 * @Author XsYounG. Tribute to Alan Turing
 * @Date 2020/4/5
 * @Version V1.0
 **/
@Configuration
public class AuthJwtTokenStore {

    @Bean("keyProp")
    public KeyProperties keyProperties() {
        return new KeyProperties();
    }

    @Resource(name = "keyProp")
    private KeyProperties keyProperties;

    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory
                (keyProperties.getKeyStore().getLocation(), keyProperties.getKeyStore().getSecret().toCharArray())
                .getKeyPair(keyProperties.getKeyStore().getAlias());
        converter.setKeyPair(keyPair);
        DefaultAccessTokenConverter tokenConverter = (DefaultAccessTokenConverter)converter.getAccessTokenConverter();
        return converter;
    }

}
