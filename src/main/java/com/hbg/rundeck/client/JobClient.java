/**
 * 
 */
package com.hbg.rundeck.client;

import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hbg.rundeck.job.Joblist;
import com.hbg.rundeck.project.model.Project;

/**
 * @author dinulaga
 *
 */
@Component
public class JobClient {

	/*
	 * @Autowired private MarshallingHttpMessageConverter
	 * marshallingHttpMessageConverter;
	 */

	public ResponseEntity<List<Project>> getAllProjects(String uri, HttpHeaders headers) {
		return new RestTemplate().exchange(uri, HttpMethod.GET, new HttpEntity<>(headers),
				new ParameterizedTypeReference<List<Project>>() {
				}, new Object());
	}

	public ResponseEntity<Joblist> getProjectById(String uri, HttpHeaders headers) {

		RestTemplate restTemplate = new RestTemplate();

		/*
		 * List<HttpMessageConverter<?>> messageConverters = new
		 * ArrayList<HttpMessageConverter<?>>();
		 * messageConverters.add(marshallingHttpMessageConverter);
		 * 
		 * restTemplate.setMessageConverters(messageConverters);
		 */

		return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), Joblist.class, new Object());
	}

	public ResponseEntity<String> editProjectById(String uri, HttpEntity<Joblist> requestEntity, Joblist joblist) {

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

		RestTemplate restTemplate = new RestTemplate(factory);

		/*
		 * List<HttpMessageConverter<?>> messageConverters = new
		 * ArrayList<HttpMessageConverter<?>>();
		 * messageConverters.add(marshallingHttpMessageConverter);
		 * restTemplate.setMessageConverters(messageConverters);
		 */
		
		/* restTemplate.getMessageConverters().add(marshallingHttpMessageConverter); */

		return restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
	}

}
