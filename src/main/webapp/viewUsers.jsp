<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>View Users</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/userDataTable.css" />
	<link rel="stylesheet" href="css/profile.css" />
	<link rel="stylesheet" href="css/navbar.css" />
	<script src="js/jquery-3.7.0.min.js"></script>
</head>
  <body>
  	<jsp:include page="navbar.jsp" />
    <section class="userTableSection">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <table class="table table-responsive">
              <thead>
                <tr>
                  <th>Email</th>
                  <th>Username</th>
                  <th>Birthdate</th>
                  <th>View Addresses</th>
                  <th>Update</th>
                  <th>Delete</th>
                </tr>
              </thead>
              <tbody id="usersTableBody">
              	<tr>
              		<td></td>
              		<td></td>
              		<td></td>
              		<td></td>
              		<td></td>
              		<td></td>
              	</tr>
              </tbody>
            </table>
            <script>
	  		$(function(){
				$.get("ViewUsersServlet", function(users) {
					users.forEach(function(user) {
						var userForm = '';
						userForm+='<tr>'
						userForm+='<td><input type="text" class="form-control" value="'+user.email+'" /></td>';
						userForm+='<td><input type="text" class="form-control" value="'+user.userName+'" /></td>';
						userForm+='<td><input type="text" class="form-control" value="'+user.birthDate+'" /></td>';
						userForm+='<td><button type="button" class="btn btn-sm btn-secondary" >View Addresses</button></td>';
						userForm+='<td><a class="btn btn-sm btn-primary" href="GetUserDetailsServlet?user_id='+user.id+'" >Update</a></td>';
						userForm+='<td><button type="button" onclick="deleteUser(this.id)" class="btn btn-sm btn-danger" id="'+user.id+'" >Delete</button></td>';
						userForm+='</tr>';
						userForm+='';
						
						$("#usersTableBody").append(userForm);
					});
				});
				
			});
			function deleteUser(id){
				console.log(id);
				$.get("DeleteUserServlet?user_id=" + id,function(){
					window.location.href="viewUsers.jsp";
				});
			}
	  </script>
          </div>
        </div>
      </div>
    </section>
	  <script src="js/jquery.repeater.js"></script>
	  <script src="js/popper.min.js"></script>
	  <script src="js/bootstrap.min.js"></script>
  </body>
</html>