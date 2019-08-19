package com.hbg.rundeck.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hbg.rundeck.operation.Operation;
import com.hbg.rundeck.operation.impl.AddOperation;
import com.hbg.rundeck.operation.impl.RemoveOperation;
import com.hbg.rundeck.operation.impl.ReorderOperation;
import com.hbg.rundeck.operation.impl.UpdateOperation;

@Configuration
public class BeanConfiguration {

	@Autowired
	private AddOperation addOperation;

	@Autowired
	private UpdateOperation updateOperation;

	@Autowired
	private RemoveOperation removeOperation;

	@Autowired
	private ReorderOperation reorderOperation;

	@Bean
	public Map<String, Operation> operations() {
		Map<String, Operation> operations = new HashMap<String, Operation>();

		operations.put("add", addOperation);
		operations.put("update", updateOperation);
		operations.put("remove", removeOperation);
		operations.put("reorder", reorderOperation);

		return operations;
	}

}
