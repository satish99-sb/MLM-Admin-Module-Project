<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

  <!--Import jQuery before materialize.js-->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"> </script>
  
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/materialize.min.js"> </script>

  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  
  <!--Import materialize.css-->
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/materialize.min.css" media="screen,projection" />
  
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" />

  <!--Let browser know website is optimized for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  
  <title>MLM</title>
  
</head>

<body class="grey lighten-4">

  <nav class="blue darken-2">
    <div class="">
      <div class="nav-wrapper">
        <a href="${pageContext.request.contextPath}/join-user" class="brand-logo">User SignUp</a>
      </div>
    </div>
  </nav>

  <section class="section section-add-user">
    <div class="container">
      <div class="row">
        <div class="col s12 m10 offset-m2 l10">
          <div class="card-panel login blue darken-2 white-text center">
           
            <h3> ADD NEW USER </h3>
            
            <form:form action="${pageContext.request.contextPath}/registerUser" modelAttribute="user" method="post" onsubmit="return validateForm()">
              
              <h4> ${msg} </h4>
              
              <div class="input-field">
                <input type="text" id="top-user-id" name="topuserid">
                <label class="white-text" for="top-user-id">Top User ID</label>
                <span id="Topuserid" class="red-text darken-4"> </span>
              </div>
              
              <div class="input-field">
                <input type="email" id="email" name="email">
                <label class="white-text" for="email">Email</label>
                <span id="Email" class="red-text darken-4"> </span>
              </div>
              
              <div class="input-field">
                <select name="gender" id="gender">
                  <option value="select"> Select Gender </option>
                  <option value="Male"> Male </option>
                  <option value="Female"> Female </option>
                  <option value="Other"> Other </option>
                </select>
                <span id="Gender" class="red-text darken-4"> </span>
              </div>
              
              <div class="input-field">
                <input type="text" id="mobile" name="mobileno">
                <label class="white-text" for="mobile">Mobile</label>
                <span id="Mobileno" class="red-text darken-4"> </span>
              </div>
              
              <div class="input-field">
                <input type="text" id="amount" name="amount">
                <label class="white-text" for="amount">Amount</label>
                <span id="Amount" class="red-text darken-4"> </span>
              </div>
              
              <div class="input-field">
                <input type="text" id="account" name="accountno">
                <label class="white-text" for="account">Account</label>
                <span id="Accountno" class="red-text darken-4"> </span>
              </div>
              
              <div class="input-field">
                <textarea id="address" class="materialize-textarea" name="address"></textarea>
                <label class="white-text" for="textarea">Address</label>
                <span id="Address" class="red-text darken-4"> </span>
              </div>
              
              <div class="input-field">
                <select name="userside" id="userside">
                  <option value="select"> Select New User's Side For Top User </option>
                  <option value="Left"> Left Side </option>
                  <option value="Right"> Right Side </option>
                </select>
                <span id="Userside" class="red-text darken-4"> </span>
              </div>
              
              <button type="submit" id="submit" class="btn btn-large waves-effect btn-extended grey lighten-4 black-text"> SignUp </button>
              
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
  

  <script>

    // Hide Sections
    
    $('.section').hide();

    setTimeout(function () 
    {

      $(document).ready(function () 
      {

        // Show sections
        $('.section').fadeIn();

        // Hide preloader
        $('.loader').fadeOut();

      });
      
    }, 1000);

    $(document).ready(function()
    {

     	$('select').material_select();

    });

  </script>
  
  
  <!-- Form Validation -->
  <script type="text/javascript">

    function validateForm()
    {

      var topuserid = document.getElementById('top-user-id').value;
      var email = document.getElementById('email').value;
      var gender = document.getElementById('gender').value;
      var mobile = document.getElementById('mobile').value;
      var amount = document.getElementById('amount').value;
      var account = document.getElementById('account').value;
      var address = document.getElementById('address').value;
      var userside = document.getElementById('userside').value;

      
      // TopUserID Validation
      if(topuserid == "")
      {
        document.getElementById('Topuserid').innerHTML = '**Please fill the Top User ID field';
        return false;
      }

      if( topuserid.indexOf('@') <=0 )
      {
        document.getElementById('Topuserid').innerHTML = '**Please Enter Valid Top User ID field';
        return false;
      }

      // Email Validation
      if(email == "")
      {
        document.getElementById('Email').innerHTML = '**Please fill the field';
        return false;
      }

      if( email.indexOf('@') <=0 )
      {
        document.getElementById('Topuserid').innerHTML = '**Please Enter Valid Email ID field';
        return false;
      }

      // Gender Validation
      if (gender == "select") 
      {
        document.getElementById('Gender').innerHTML = '**Please fill the field';
        return false;
      }

      // Mobile Number Validation
      if(mobile == "")
      {
        document.getElementById('Mobileno').innerHTML = '**Please fill the field';
        return false;
      }

      if( (mobile.length < 10) || (mobile.length > 10) )
      {
        document.getElementById('Mobileno').innerHTML = '**Please Enter Valid Value for the field';
        return false;
      }
      
   	  // Amount Validation
      if(amount == "")
      {
        document.getElementById('Amount').innerHTML = '**Please fill the field';
        return false;
      }
   	  
   	  if( isNan(amount) )
   	  {
   		document.getElementById('Amount').innerHTML = '**Please Enter Valid Value, Only Contains Numbers';
        return false;
   	  }

      // Account Number Validation
      if(account == "")
      {
        document.getElementById('Accountno').innerHTML = '**Please fill the field';
        return false;
      }

      // Address Validation
      if(address == "")
      {
        document.getElementById('Address').innerHTML = '**Please fill the field';
        return false;
      }

      // User Side Validation
      if (userside == "select") 
      {
        document.getElementById('Userside').innerHTML = '**Please fill the field';
        return false;
      }

    }
    
    $(document).ready(function()
    {
    					  
    	$('#email').keyup(function()
    	{
    							
    		$.ajax
    		({
    			
    			method: 'POST',
    								
    			url: 'checkEmailid',
    								
    			data: { emailId: $("#email").val() },
    								
    			success: function(data)
    			{
    									
    				$('#Email').html(data);
    									
    			}

    		});
    							
    	});
    					  
    });

  </script>
  
</body>

</html>