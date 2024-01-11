package com.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/subscriptions")

public

class SubscriptionController {

    @Autowired
    private SubscriptionPlanManager subscriptionPlanManager;

    @Autowired
    private SubscriptionPlanRepository subscriptionRepository; // For user subscriptions
    private SubscriptionPlan subscription;

    @GetMapping
    public long getAllPlans() {
        return subscriptionPlanManager.getTotalPlans();
    }

    @GetMapping("/{planId}")
    public SubscriptionPlan getPlanById(@PathVariable Long planId) {
        return subscriptionPlanManager.getPlanByName(String.valueOf(planId));
    }

    @PostMapping("/create")
    public SubscriptionPlan createSubscription(@RequestBody User request) {
        // Assuming SubscriptionRequest (User) contains user email and planName
        User user = UserRepository.findByEmail(request.getEmail());
        //SubscriptionPlan plan = subscriptionPlanManager.getPlanByName(request.getPlanName());

        // ... (validate user and plan, create subscription, handle exceptions)

        return subscriptionRepository.save(subscription);
    }

    // ... Endpoints for updating payment status, cancelling subscriptions, etc.,
    // utilizing subscriptionRepository and potentially other services
}
