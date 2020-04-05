/**
 * 
 */
package pers.xsy.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserDetailsServiceImpl
 * @Description: TODO
 * @Author XsYounG. Tribute to Alan Turing
 * @Date 2020/4/5
 * @Version V1.0
 **/
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/** (non-Javadoc)
	 * @see UserDetailsService#loadUserByUsername(String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return User.withUsername(username)
					.password(passwordEncoder.encode("123456"))
					.authorities("ROLE_ADMIN")
					.build();
	}

}
