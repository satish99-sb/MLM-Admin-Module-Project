<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

  <!--Import jQuery before materialize.js-->
	
  <!-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script> -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"> </script>
  
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/materialize.min.js"> </script>
  
  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  
  <!--Import materialize.css-->
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/materialize.min.css">
  
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">

  <!--Let browser know website is optimized for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  
  <title>MLM</title>
  
</head>

<body class="grey lighten-4">

  <nav class="blue darken-2">
    <div class="">
      <div class="nav-wrapper">
        <h3 class="brand-logo">Admin</h3>
        <a href="#" data-activates="side-nav" class="button-collapse show-on-large right">
          <i class="material-icons">menu</i>
        </a>
        <ul class="right hide-on-med-and-down">
          <li class="active">
            <a href="${pageContext.request.contextPath}">Dashboard</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/viewPinRequestAdmin">View Pin Request</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/showUsersRevenue">Revenue</a>
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
                <span class="name white-text"> ${sessionScope.username} </span>
              </a>
            </div>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/adminDashboard">
              <i class="material-icons">dashboard</i> Dashboard</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/viewPinRequestAdmin">View Pin Request</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/showUsersRevenue">Revenue</a>
          </li>
          <li>
            <div class="divider"></div>
          </li>
          <form:form action="${pageContext.request.contextPath}/adminLogout" method="post">
          	<li>
		 		<button type="submit" class="btn waves-effect blue logout"> Logout </button>
		  	</li>
		  </form:form>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Section: Stats -->
  <section class="section admin-stats section-stats center">
    <div class="row admin-stats">
      <div class="col s12 m6 l3">
        <div class="card-panel blue lighten-1 white-text center">
          <i class="material-icons medium">group</i>
          <!-- <h5>Total Users</h5> -->
          <h5> <a href="${pageContext.request.contextPath}/showAllUsers" class="white-text"> Total Users </a> </h5>
          <h3 class="count"> ${usersCount} </h3>
        </div>
      </div>
      <div class="col s12 m6 l3">
        <div class="card-panel center">
          <i class="material-icons medium">mode_edit</i>
          <h5> <a href="${pageContext.request.contextPath}/viewPinRequestAdmin" class="black-text"> Total Pin Request </a> </h5>
          <h3 class="count"> ${usersCount} </h3>
        </div>
      </div>
      <div class="col s12 m6 l3">
        <div class="card-panel blue lighten-1 white-text center">
          <i class="material-icons medium">mode_comment</i>
          <h5> Total Amount </h5>
          <h3 class="count"> ${totalAmount} </h3>
        </div>
      </div>
      <div class="col s12 m6 l3">
        <div class="card-panel center">
          <i class="material-icons medium">attach_money</i>
          <h5> <a href="${pageContext.request.contextPath}/showUsersRevenue" class="black-text"> Total Revenue </a> </h5>
          <h3 class="count"> ${finalAmount} </h3>
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

