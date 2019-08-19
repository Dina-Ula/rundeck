/**
 * 
 */
package com.hbg.rundeck.authprovider;

import java.util.List;
import java.util.Map.Entry;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.hbg.rundeck.auth.model.User;
import com.hbg.rundeck.config.RundeckConfiguration;

/**
 * @author dinulaga
 *
 */
@Component
public class RundeckAuthProviderClient {

	@Autowired
	private User user;

	@Autowired
	private RundeckConfiguration rundeckConfiguration;

	public boolean authenticate(String username, Object password) {

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

		RestTemplate restTemplate = new RestTemplate(factory);

		HttpHeaders authRequestHeaders = new HttpHeaders();

		MultiValueMap<String, Object> authBody = new LinkedMultiValueMap<String, Object>();
		authBody.add(rundeckConfiguration.getAuthentication().getUsername(), username);
		authBody.add(rundeckConfiguration.getAuthentication().getPassword(), password);

		HttpEntity<MultiValueMap<String, Object>> authRequestEntity = new HttpEntity<>(authBody, authRequestHeaders);

		ResponseEntity<String> authResponseEntity = restTemplate.exchange(
				rundeckConfiguration.getAuthentication().getEndpoint(), HttpMethod.POST, authRequestEntity,
				String.class);

		for (Entry<String, List<String>> authResponseHeader : authResponseEntity.getHeaders().entrySet()) {
			if (HttpHeaders.LOCATION.equals(authResponseHeader.getKey())) {
				for (String headerValue : authResponseHeader.getValue()) {
					if (!headerValue.equals(rundeckConfiguration.getAuthentication().getSuccessURL())) {
						return Boolean.FALSE;
					}
				}
			}
		}

		for (Entry<String, List<String>> authResponseHeader : authResponseEntity.getHeaders().entrySet()) {
			if (HttpHeaders.SET_COOKIE.equals(authResponseHeader.getKey())) {
				for (String headerValue : authResponseHeader.getValue()) {
					HttpHeaders exportJobHeader = new HttpHeaders();
					exportJobHeader.add(HttpHeaders.COOKIE, headerValue);
					exportJobHeader.add(HttpHeaders.ACCEPT, MediaType.ALL_VALUE);

					user.setHeaders(exportJobHeader);
					return Boolean.TRUE;
				}
			}
		}

		return Boolean.FALSE;
	}
}
