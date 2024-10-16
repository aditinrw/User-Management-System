<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" href="stylelogin.css">
</head>
<body>
    <div class="outer-box">
        <div class="inner-box">
            <h1>Log In</h1>
            <form action="LoginServlet" method="post" >
                <p>
                    <label for="email">Email:</label>
                    <input type="email" placeholder="Enter your email" name="email" id="email" required>
                </p>
                <p id="forget-pass">
                    <a href="forget.html">Forgot password?</a>
                </p>
                <p>
                    <label for="password">Password:</label>
                    <input type="password" placeholder="Enter your password" name="password" id="password" required>
                </p>
                
                <p>
                    <input type="submit" id="submit" value="Log In">
                </p>
                <span id="bottom">Don't have an account? <a href="index.html">  Register</a></span>
                
                <p style="color:red" id="errorMessage">${errorMessage}</p>
            </form>
        </div>
    </div>
</body>
</html>
