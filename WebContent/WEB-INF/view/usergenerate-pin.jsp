<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
  
</head>

<body class="grey lighten-4">

  <nav class="blue darken-2">
    <div class="">
      <div class="nav-wrapper">
        <a href="${pageContext.request.contextPath}/viewAllPinOfUser" class="brand-logo">User</a>
        <a href="#" data-activates="side-nav" class="button-collapse show-on-large right">
          <i class="material-icons">menu</i>
        </a>
        <ul class="right hide-on-med-and-down">
          <li class="active">
            <a href="${pageContext.request.contextPath}/viewAllPinOfUser">Dashboard</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/">User's Tree</a>
          </li>
        </ul>
        <!-- Side nav -->
        <ul id="side-nav" class="side-nav">
          <li>
            <div class="user-view">
              <div class="background">
                <img src="${pageContext.request.contextPath}/resources/img/ocean.jpg" alt="">
              </div>
              <a href="#">
                <img src="${pageContext.request.contextPath}/resources/img/person1.jpg" alt="" class="circle">
              </a>
              <a href="#">
                <span class="name white-text"> ${sessionScope.email} </span>
              </a>
            </div>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/viewAllPinOfUser">
              <i class="material-icons">dashboard</i> Dashboard</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/">User's Tree</a>
          </li>
          <li>
            <div class="divider"></div>
          </li>
          <form:form action="${pageContext.request.contextPath}/userLogout" method="post">
          	<li>
		 		<button type="submit" class="btn waves-effect blue logout"> Logout </button>
		  	</li>
		  </form:form>
        </ul>
      </div>
    </div>
  </nav>

<section class="section section-login">
    <div class="container">
      <div class="row">
        <div class="col s12 m8 offset-m2 l9 offset-l2">
          <div class="card-panel login blue darken-2 white-text center">
            
            <h3> Pin Generate For User </h3>
            
            <form:form action="${pageContext.request.contextPath}/savePinForUser" modelAttribute="singleUser">
			
			
<!--    			  <div class="input-field">
                <input type="hidden" id="id" name="id">
              </div> -->
              
              <div class="input-field">
                <input type="email" id="topuserid" name="topuserid" value="${topUserId}">
                <label class="white-text" for="topUserId">TopUserId</label>
              </div>
              
              <div class="input-field">
                <input type="email" id="email" name="email" value="${downuserid}">
                <label class="white-text" for="email">Email-ID</label>
              </div>
              
              <div class="input-field">
                <input type="password" id="pin" name="pin" value="${pinPin}">
                <label class="white-text" for="pin">Pin</label>
              </div>
              
              <input type="submit" value="Generate Pin" 
              class="btn btn-large waves-effect btn-extended grey lighten-4 black-text">
              
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

    setTimeout(function () {
    	
      $(document).ready(function () {
        // Show sections
        $('.section').fadeIn();

        // Hide preloader
        $('.loader').fadeOut();

        //Init Side nav
        $('.button-collapse').sideNav();

        // Init Modal
        $('.modal').modal();

        // Init Select
        $('select').material_select();

        // Counter
        $('.count').each(function () {
          $(this).prop('Counter', 0).animate({
            Counter: $(this).text()
          }, {
              duration: 1000,
              easing: 'swing',
              step: function (now) {
                $(this).text(Math.ceil(now));
              }
            });
        });

      });
    }, 1000);

 </script>

</body>

</html>