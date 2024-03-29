/**
 * 
 */
package com.hbg.rundeck.operation.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author dinulaga
 *
 */
@Component
public class OperationHelper {

	private static final String GET = "get";
	private static final String SET = "set";

	public Object getElement(Object element, List<String> pSelectedElements) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		for (String entry : pSelectedElements) {

			if (element == null) {
				return null;
			}

			element = element.getClass().getMethod(GET + StringUtils.capitalize(entry)).invoke(element);
		}

		return element;
	}

	public void setElement(Object element, Map<String, String> addElements) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		for (Map.Entry<String, String> entry : addElements.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();

			Object existingValue = element.getClass().getMethod(GET + StringUtils.capitalize(key)).invoke(element);
			System.out.println("The existing value of " + key + " is, " + existingValue);

			element.getClass().getMethod(SET + StringUtils.capitalize(key), String.class).invoke(element, value);

			Object newValue = element.getClass().getMethod(GET + StringUtils.capitalize(key)).invoke(element);
			System.out.println("The existing value of " + key + " is, " + newValue);
		}
	}

	public String getElementValueAsString(Object element, String id) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if (StringUtils.isEmpty(id)) {
			return StringUtils.EMPTY;
		}

		String value = (String) element.getClass().getMethod(GET + StringUtils.capitalize(id)).invoke(element);

		return value;
	}

	public boolean ignoreJob(Object element, String elementId, String regex) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		if (StringUtils.isEmpty(elementId)) {
			return Boolean.FALSE;
		}

		String elementValue = getElementValueAsString(element, elementId);

		return elementValue.matches(regex);
	}
}
