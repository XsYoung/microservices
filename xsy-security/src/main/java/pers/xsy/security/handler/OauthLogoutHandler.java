package pers.xsy.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import pers.xsy.security.utils.AuthUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName OauthLogoutHandler
 * @Description: TODO
 * @Author XsYounG. Tribute to Alan Turing
 * @Date 2020/4/5
 * @Version V1.0
 **/
@Slf4j
public class OauthLogoutHandler implements LogoutHandler {
	@Autowired
	private TokenStore tokenStore;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		Assert.notNull(tokenStore, "tokenStore must be set");
		String token = request.getParameter("token");
		if (StringUtils.isEmpty(token)) {
			token = AuthUtils.extractToken(request);
		}
		if(!StringUtils.isEmpty(token)){
			OAuth2AccessToken existingAccessToken = tokenStore.readAccessToken(token);
			OAuth2RefreshToken refreshToken;
			if (existingAccessToken != null) {
				if (existingAccessToken.getRefreshToken() != null) {
					log.info("remove refreshToken!", existingAccessToken.getRefreshToken());
					refreshToken = existingAccessToken.getRefreshToken();
					tokenStore.removeRefreshToken(refreshToken);
				}
				log.info("remove existingAccessToken!", existingAccessToken);
				tokenStore.removeAccessToken(existingAccessToken);
			}
		}
	}
}
