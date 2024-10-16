
console.log("forgot.js loaded"); 

function validatePassword() {
    console.log("Validation function called!");  

    const password = document.getElementById('newPassword').value;
    const errorElement = document.getElementById('error');

    errorElement.textContent = '';

    if (password === '') {
        errorElement.textContent = 'Password is required.';
        console.log('Password is empty.');
        return false;
    }

    if (password.length < 8) {
        errorElement.textContent = 'Password must be at least 8 characters long.';
        console.log('Password too short.');
        return false;
    }

    if (!/[A-Z]/.test(password)) {
        errorElement.textContent = 'Password must contain at least one uppercase letter.';
        console.log('Missing uppercase letter.');
        return false;
    }

    if (!/[a-z]/.test(password)) {
        errorElement.textContent = 'Password must contain at least one lowercase letter.';
        console.log('Missing lowercase letter.');
        return false;
    }

    if (!/[0-9]/.test(password)) {
        errorElement.textContent = 'Password must contain at least one number.';
        console.log('Missing number.');
        return false;
    }

    if (!/[!@#$%^&*(),.?":{}|<>]/.test(password)) {
        errorElement.textContent = 'Password must contain at least one special character.';
        console.log('Missing special character.');
        return false;
    }

    if (/\s/.test(password)) {
        errorElement.textContent = 'Password must not contain spaces.';
        console.log('Password contains spaces.');
        return false;
    }

    console.log("Password validation passed.");
    return true;  
}
