package com.sms;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {

    SubscriptionPlan findByPlanName(String planName);
}
