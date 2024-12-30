document.querySelector('form').addEventListener('submit', function(event) {
    // Basic validation for login form
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    if (!email || !password) {
        alert('Please fill out all fields!');
        event.preventDefault();
    }
});
