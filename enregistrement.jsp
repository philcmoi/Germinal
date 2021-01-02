<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<link href="css2/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">


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


<form class="form-signin" action="/Germinal/Enregistrer" method="post" >
<!--     <img class="mb-4" src="/docs/4.2/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> -->
   
    <h1 for="inputEmail" class="sr-only"></h1>
    
    <input type="text" name="pseudo" id="inputEmail2" class="form-control" placeholder="Entrer votre pseudo" required >
    <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Entrer votre email" required autofocus>
	<h1 for="inputPassword" class="sr-only"></h1>
<!--     <input type="text" name="prenom" id="inputEmail" class="form-control" placeholder="Entrer votre prenoml" required autofocus> -->
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required><br>
    <input type="password" name="password2" id="inputPassword2" class="form-control" placeholder="Password de confirmation" required>
<%-- <%! String valeur; %> --%>
<%-- <% valeur = ((Double)(Math.random() * 10000)).toString(); %> --%>
 <input type="hidden" name="token" value="valeur"/>    
 <input id="validate" name="validate" type="hidden" value="question">
    </br>
<button class="btn btn-lg btn-primary btn-block" type="submit">S'enregistrer</button>
<h4>
 <%=request.getAttribute("text")!=null?request.getAttribute("text"):""%>
 </h4>