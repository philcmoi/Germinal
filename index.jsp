<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<!doctype html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Signin Template · Bootstrap</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.2/examples/sign-in/">

    <!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<link href="csspersonnel/csspersonnel.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>
  <body class="text-center">

  <form class="form-signin" action="/Germinal/Login" method="post" >
<!--   <img class="mb-4" src="/docs/4.2/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> -->
  <h1 class="h3 mb-3 font-weight-normal">Connection</h1>
  <h1 for="inputEmail" class="sr-only"></h1>
  <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Entrer votre email"  autofocus>
  <h1 for="inputPassword" class="sr-only"></h1>
  <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password"  >
<%--   <%! String valeur; %> --%>
<%-- <% valeur = ((Double)(Math.random() * 10000)).toString(); %> --%>
<!--  <input type="hidden" name="token" placeholder="valeur"/> -->
  </br>
  <div class="checkbox mb-3">
  
  <label>
  <input type="checkbox" name="rememberme" value="seRappelerDeMoi" checked>se souvenir de moi
  
  </label>
  </div>
  <h4>
  <%=request.getAttribute("text")!=null?request.getAttribute("text"):""%>
  </h4>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
  <a href="enregistrement.jsp" title="S enregistrer" target="_blank" rel="noopener noreferrer">S'enregistrer</a>
  <br>
  <a href="rappelleMotPasse.jsp" title="Mot passe oublié" target="_blank" rel="noopener noreferrer">Mot de passe oublié</a>
  <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
</form>
 
  

</body>
</html>

