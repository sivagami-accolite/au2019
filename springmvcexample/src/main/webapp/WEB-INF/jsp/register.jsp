<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<form action="register" method="post" onsubmit="return ValidateForm(this);">
		
    <h1>Register</h1>
    <hr>

	<label><b>First Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required>
	<label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="pw" required>

    

    <button type="submit" >Register</button>
 </form>
 
  

</body>
</html>