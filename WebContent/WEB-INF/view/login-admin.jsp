<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>

  <!--Import jQuery before materialize.js-->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"> </script>
  
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/materialize.min.js"> </script>

  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  
  <!--Import materialize.css-->
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/materialize.min.css">
  
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" />

  <!--Let browser know website is optimized for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  
  <title>MLM</title>
  
  <script>
  
    /* Hide Sections */
    $('.section').hide();

    setTimeout(function () 
    {

      $(document).ready(function () 
      {

        /* Show sections */
        $('.section').fadeIn();

        /* Hide preloader */
        $('.loader').fadeOut();

      });
      
    }, 1000);

    $(document).ready(function()
    {

    	$('select').material_select();

    });

  </script>
  
</head>

<body class="grey lighten-4">
  <nav class="blue darken-2">
    <div class="container">
      <div class="nav-wrapper">
        <a href="${pageContext.request.contextPath}/login-admin" class="brand-logo">MLM</a>
      </div>
    </div>
  </nav>

  <section class="section section-login">
    <div class="container">
      <div class="row">
        <div class="col s12 m8 offset-m2 l9 offset-l2">
          <div class="card-panel login blue darken-2 white-text center">
            
            <h3> Admin Sign In </h3>
            
            <form:form action="${pageContext.request.contextPath}/loginAdmin" modelAttribute="adminlogin" onsubmit="return loginAdminValidate()">
              <h4 class="error"> ${message} </h4>
              <div class="input-field">
                <input type="email" id="email" name="username">
                <label class="white-text" for="email">Email</label>
                <span id="Email" class="red-text darken-4"> </span>
              </div>
              <div class="input-field">
                <input type="password" id="password" name="password">
                <label class="white-text" for="password">Password</label>
                <span id="Password" class="red-text darken-4"> </span>
              </div>
              <input type="submit" value="Sign In" 
              class="btn btn-large waves-effect btn-extended grey lighten-4 black-text">
              <a class="white-text" href="${pageContext.request.contextPath}/showAdminRegister"> First time user? Register </a> | 
              <a class="white-text" href="#"> Forget Password </a>
            </form:form>
            
          </div>
        </div>
      </div>
    </div>
  </section>


  <!-- Footer -->
  <footer class="section blue darken-2 white-text center">
    <p>MLM Copyright &copy; 2019</p>
  </footer>



  <!-- Preloader -->
  <div class="loader preloader-wrapper big active">
    <div class="spinner-layer spinner-blue-only">
      <div class="circle-clipper left">
        <div class="circle"></div>
      </div>
      <div class="gap-patch">
        <div class="circle"></div>
      </div>
      <div class="circle-clipper right">
        <div class="circle"></div>
      </div>
    </div>
  </div>
  
  <script type="text/javascript"> 
  
  function loginAdminValidate()
  {
	  
	  var email = document.getElementById('email').value;
	  var password = document.getElementById('password').value;
	  
	  
	  // Email Validate
	  if(email == "")
	  {
		  document.getElementById('Email').innerHTML = '**Please fill the Email ID field';
		  return false;
	  }
	  
	  if(email.indexOf('@') <=0 )
	  {
		  document.getElementById('Email').innerHTML = '**Please Enter Valid Email ID ';
		  return false;
	  }
	  
	  // Pin Validate
	  if(password == "")
	  {
		  document.getElementById('Password').innerHTML = '**Please fill the Password field';
		  return false;
	  }
	  
  }
  
  </script>
  
</body>

</html>