<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" href="profile.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
 <header class="navbar">
        <p>User Profile</p>
        <form >
            <div class="search">
                <input type="text" placeholder=" Search.......">
                <button type="submit"><i class="fa fa-search"></i></button>
            </div>
        </form>
        <button id="first" value="Register" ><a href="index.html">Register</a></button>
        <button id="second" value="Login"><a href="login.html">Login</a></button>
    </header>
    <div class="main-content">
        <h2>Personal Details</h2>
        <ul>
            <li>First Name: ${firstName}</li><hr>
            <li>Last Name: ${lastName}</li><hr>
            <li>Email: ${email}</li><hr>
            <li>Mobile No.: ${mobNo}</li><hr>
            <li>Date of Birth: ${dob}</li><hr>
            <li>Gender: ${gender}</li><hr>
        </ul>
    </div>
    <div class="main-content-2">
        <h2>Educational Information</h2>
        <ul>
            <li>Current Semester: ${semester}</li><hr>
            <li>Class 10th Percentage: ${class10 }</li><hr>
            <li>Class 12th Percentage: ${class12 }</li><hr>
            <li>Graduation Percentage: ${graduation }<li><hr>
            <li>Specialization: ${ special}</li><hr>
            <li>Experience Status: ${status}</li><hr>
        </ul>
    </div>

</body>
</html>
