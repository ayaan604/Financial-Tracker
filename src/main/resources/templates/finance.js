const userName = 'John Doe'; // Replace with dynamic value from the server
        document.getElementById('user-name').textContent = userName;

        const submitBtn = document.getElementById('submit-btn');
        const expenseInput = document.getElementById('expense-input');
        const responseMessage = document.getElementById('response-message');

        submitBtn.addEventListener('click', async () => {
            const expense = expenseInput.value.trim();
            if (!expense || isNaN(expense) || parseFloat(expense) <= 0) {
                responseMessage.textContent = "Please enter a valid amount.";
                responseMessage.className = "response-message error";
                responseMessage.style.display = "block";
                return;
            }

            try {
                const response = await fetch('/FinancialTracker/addExpense', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({ amount: parseFloat(expense) }),
                });

                if (response.ok) {
                    responseMessage.textContent = "Expense added successfully.";
                    responseMessage.className = "response-message success";
                } else {
                    responseMessage.textContent = "Unable to add expense.";
                    responseMessage.className = "response-message error";
                }
            } catch (error) {
                responseMessage.textContent = "Unable to add expense.";
                responseMessage.className = "response-message error";
            }

            responseMessage.style.display = "block";
        });