document.getElementById('login-form').addEventListener('submit', function(event) {
    // Prevent the form from submitting
    event.preventDefault();

    // Get form values
    const email = document.getElementById('loginEmail').value;
    const password = document.getElementById('loginPassword').value;

    // Reset previous error messages
    document.getElementById('email-error').style.display = 'none';
    document.getElementById('password-error').style.display = 'none';

    let isValid = true;

    // Validate email (basic check)
    if (email === '' || !email.includes('@')) {
        document.getElementById('email-error').style.display = 'block';
        isValid = false;
    }

    // Validate password (check if it meets all requirements)
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    if (!passwordRegex.test(password)) {
        document.getElementById('password-error').style.display = 'block';
        isValid = false;
    }

    // If the form is valid, proceed (you can add your authentication logic here)
    if (isValid) {
        alert('Login successful!');
    } else {
        alert('Please fix the errors and try again.');
    }
});

// Enable/Disable login button based on password validity
document.getElementById('loginPassword').addEventListener('input', function() {
    const password = document.getElementById('loginPassword').value;
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    const loginButton = document.querySelector('button[type="submit"]');
    
    if (passwordRegex.test(password)) {
        loginButton.disabled = false; // Enable the login button
    } else {
        loginButton.disabled = true; // Disable the login button if the password doesn't meet the criteria
    }
});
