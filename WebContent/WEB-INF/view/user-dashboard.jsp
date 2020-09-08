<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  
  <!--Import materialize.css-->
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/materialize.min.css" media="screen,projection">
  
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">

  <!--Let browser know website is optimized for mobile-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  
  <title>MLM</title>
  
</head>

<body class="grey lighten-4">
  <nav class="blue darken-2">
    <div class="">
      <div class="nav-wrapper">
        <a class="brand-logo">User</a>
        <a href="#" data-activates="side-nav" class="button-collapse show-on-large right">
          <i class="material-icons"> menu </i>
        </a>
        <ul class="right hide-on-med-and-down">
          <li class="active">
            <a href="${pageContext.request.contextPath}">Dashboard</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/viewAllPinOfUser">View Pin</a>
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
            <a href="">
              <i class="material-icons">dashboard</i> Dashboard</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/viewAllPinOfUser">View Pin</a>
          </li>
          <li>
            <a href="#">User's Tree</a>
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

  <!-- Section: Stats -->
  <section class="section user-stats section-stats center">
    <div class="row user-stats">
      <div class="col s12 m6 l3">
        <div class="card-panel blue lighten-1 white-text center">
          <i class="material-icons medium">group</i>
          <h5> <a href="${pageContext.request.contextPath}/showAllUsersInUser" class="white-text"> Total Users </a> </h5>
          <h3 class="count"> ${usersCount} </h3>
        </div>
      </div>
      <div class="col s12 m6 l3">
        <div class="card-panel center">
          <i class="material-icons medium">attach_money</i>
          <h5> <a href="${pageContext.request.contextPath}/viewAllPinOfUser" class="black-text"> Total Pin Request </a> </h5>
          <h3 class="count"> ${usersPinCount} </h3>
        </div>
      </div>
      <div class="col s12 m6 l3">
        <div class="card-panel blue lighten-1 white-text center">
          <i class="material-icons medium">attach_money</i>
          <h5> Total Income </h5>
          <h3 class="count"> ${totalAmount} </h3>
        </div>
      </div>
      <div class="col s12 m6 l3">
        <div class="card-panel center">
          <i class="material-icons medium">attach_money</i>
          <h5> Total Revenue </h5>
          <h3 class="count"> ${finalCommission} </h3>
        </div>
      </div>
    </div>
  </section>

  <!-- Footer -->
  <footer class="section blue darken-2 white-text center">
    <p>MLM Copyright &copy; 2019</p>
  </footer>

  <!-- Add Post Modal -->
  <div id="post-modal" class="modal">
    <div class="modal-content">
      <h4>Add Post</h4>
      <form>
        <div class="input-field">
          <input type="text" id="title">
          <label for="title">Title</label>
        </div>
        <div class="input-field">
          <select>
            <option value="" disabled selected>Select option</option>
            <option value="1">Web Development</option>
            <option value="2">Graphic Design</option>
            <option value="3">Tech Gadgets</option>
            <option value="4">Other</option>
          </select>
          <label>Category</label>
        </div>
        <div class="input-field">
          <textarea name="body" id="body" class="materialize-textarea"></textarea>
          <label for="body">Body</label>
        </div>
      </form>
      <div class="modal-footer">
        <a href="#!" class="modal-action modal-close btn blue white-text">Submit</a>
      </div>
    </div>
  </div>

  <!-- Add Category Modal -->
  <div id="category-modal" class="modal">
    <div class="modal-content">
      <h4>Add Category</h4>
      <form>
        <div class="input-field">
          <input type="text" id="title">
          <label for="title">Title</label>
        </div>
      </form>
      <div class="modal-footer">
        <a href="#!" class="modal-action modal-close btn blue white-text">Submit</a>
      </div>
    </div>
  </div>

  <!-- Add User Modal -->
  <div id="user-modal" class="modal">
    <div class="modal-content">
      <h4>Add User</h4>
      <form>
        <div class="input-field">
          <input type="text" id="name">
          <label for="name">Name</label>
        </div>
        <div class="input-field">
          <input type="email" id="email">
          <label for="email">Email</label>
        </div>
        <div class="input-field">
          <input type="password" id="password">
          <label for="password">Password</label>
        </div>
        <div class="input-field">
          <input type="password" id="password2">
          <label for="password2">Confirm Password</label>
        </div>
      </form>
      <div class="modal-footer">
        <a href="#!" class="modal-action modal-close btn blue white-text">Submit</a>
      </div>
    </div>
  </div>


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

  <!--Import jQuery before materialize.js-->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"> </script>
  
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/materialize.min.js"> </script>
  
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

        CKEDITOR.replace('body');

      });
    }, 1000);
  </script>
</body>

</html>