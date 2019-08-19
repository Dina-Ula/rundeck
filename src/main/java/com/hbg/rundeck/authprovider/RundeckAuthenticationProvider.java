/**
 * 
 */
package com.hbg.rundeck.authprovider;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author dinulaga
 *
 */
@Component
public class RundeckAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private RundeckAuthProviderClient rundeckAuthProviderClient;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		Object password = authentication.getCredentials();

		if (rundeckAuthProviderClient.authenticate(userName, password)) {
			return new UsernamePasswordAuthenticationToken(userName, password, Collections.emptyList());
		}

		System.out.println("Authentication failed for the user: " + userName);

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
