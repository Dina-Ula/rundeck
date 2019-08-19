/**
 * 
 */
package com.hbg.rundeck.job.config;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;

/**
 * @author dinulaga
 *
 */
@Configuration
public class JobConfig {

	@Bean
	public MarshallingHttpMessageConverter getMarshallingHttpMessageConverter() {
		return new MarshallingHttpMessageConverter(getJaxb2Marshaller(), getJaxb2Marshaller());
	}

	@Bean
	public Jaxb2Marshaller getJaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();

		jaxb2Marshaller.setPackagesToScan("com.hbg.rundeck.job");

		Map<String, Object> marshallerProperties = new HashMap<String, Object>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		marshallerProperties.put("com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler", new NoEscapeHandler() {
			@Override
			public void escape(char[] var1, int var2, int var3, boolean var4, Writer var5) throws IOException {
				int var6 = var2 + var3;

				for (int var7 = var2; var7 < var6; ++var7) {
					switch (var1[var7]) {
					case '&':
						var5.write("&amp;");
						break;
					default:
						var5.write(var1[var7]);
					}
				}
			}
		});

		jaxb2Marshaller.setMarshallerProperties(marshallerProperties);

		return jaxb2Marshaller;
	}

}
