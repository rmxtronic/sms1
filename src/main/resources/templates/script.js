// Fetch and display available subscription plans
fetch('/api/subscriptions')
    .then(response => response.json())
    .then(plans => {
        const plansContainer = document.querySelector('.plans-container');
        plans.forEach(plan => {
            const planCard = document.createElement('div');
            planCard.classList.add('plan-card');
            // Populate card content with plan details (name, price, etc.)
            planCard.innerHTML = `
                <h3>${plan.planName}</h3>
                <p>Price: $${plan.amount}</p>
                <button class="subscribe-button" data-plan-id="${plan.id}">Subscribe</button>
            `;
            plansContainer.appendChild(planCard);
        });
    })
    .catch(error => console.error('Error fetching plans:', error));

// Handle create subscription form submission
const createSubscriptionForm = document.getElementById('create-subscription-form');
createSubscriptionForm.addEventListener('submit', (event) => {
    event.preventDefault();
    // Collect user input (email, plan name, payment details)
    const userEmail = ...;
    const chosenPlanId = ...;

    fetch('/api/subscriptions/create', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email: userEmail, planName: chosenPlanId })
    })
    .then(response => response.json())
    .then(subscription => {
        // Handle successful subscription creation (show confirmation, redirect)
    })
    .catch(error => {
        // Handle errors (display error message)
    });
});

// Handle subscribe button clicks
plansContainer.addEventListener('click', event => {
    if (event.target.classList.contains('subscribe-button')) {
        const planId = event.target.dataset.planId;
        // Handle subscription process for the selected plan
    }
});
