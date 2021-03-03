package com.au.service_project.repository;

import com.au.service_project.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillingRepository extends JpaRepository<Billing,Integer> {

	@Query("SELECT SUM(transactionAmount) FROM Transaction t  WHERE t.billingId = ?1  GROUP BY t.billingId ")
	Float getBillingCostById(Integer billingId);
	
	@Query("SELECT SUM(originalCost) FROM Transaction t  WHERE t.billingId = ?1  GROUP BY t.billingId ")
	Float getOriginalCostById(Integer billingId);

	
}
