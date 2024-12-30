// script.js

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

    // Validate password
    if (password === '') {
        document.getElementById('password-error').style.display = 'block';
        isValid = false;
    }

    // If the form is valid, proceed (you can add your authentication logic here)
    if (isValid) {
        alert('Login successful!');
        // For now, submitting the form (this can be replaced with actual form submission logic)
        // document.getElementById('login-form').submit();
    }
});
