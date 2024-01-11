package com.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionPlanManager {

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    public SubscriptionPlan getPlanByName(String planName) {
        return subscriptionPlanRepository.findByPlanName(planName);
    }

    public SubscriptionPlan createPlan(String planName, double amount, int duration) {
        SubscriptionPlan newPlan = new SubscriptionPlan();
        newPlan.setPlanName(planName);
        newPlan.setAmount(amount);
        newPlan.setDuration(duration);
        return subscriptionPlanRepository.save(newPlan);
    }

    public boolean updatePlan(Long planId, String planName, double amount, int duration) {
        SubscriptionPlan planToUpdate = subscriptionPlanRepository.findById(planId).orElse(null);
        if (planToUpdate != null) {
            planToUpdate.setPlanName(planName);
            planToUpdate.setAmount(amount);
            planToUpdate.setDuration(duration);
            subscriptionPlanRepository.save(planToUpdate);
            return true;
        }
        return false;
    }

    public boolean deletePlan(Long planId) {
        try {
            subscriptionPlanRepository.deleteById(planId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public long getTotalPlans() {
        return subscriptionPlanRepository.count();
    }
}

