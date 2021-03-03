package com.au.service_project.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ServiceCountResponse {

    private List<String > serviceNames;
    private List<Integer> transactionCounts;
	public List<String> getServiceNames() {
		return serviceNames;
	}
	public void setServiceNames(List<String> serviceNames) {
		this.serviceNames = serviceNames;
	}
	public List<Integer> getTransactionCounts() {
		return transactionCounts;
	}
	public void setTransactionCounts(List<Integer> transactionCounts) {
		this.transactionCounts = transactionCounts;
	}
    
    
    
    
}
