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
	<link rel="stylesheet" href="css/navbar.css" />
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
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Email</th>
                  <th>Username</th>
                  <th>Birthdate</th>
                  <th>Gender</th>
                  <th>Known Languages</th>
                  <th>View Addresses</th>
                  <th>Update</th>
                  <th>Delete</th>
                </tr>
              </thead>
              <tbody>
              <core:forEach var="user" items="${sessionScope.allUsersData}">
                <tr>
                  <form action="register.jsp" method="post" class="form-inline">
                    <div class="mainDiv">
                      <td>
                      	<input type="hidden" value="${user.profile_pic_string}" name="profile_pic" />
                      	<input type="hidden" value="${user.id}" name="user_id" />
                      	<input type="hidden" value="${user.user_uuid}" name="user_uuid" />
                        <div class="form-group">
                          <input
                            type="text"
                            class="form-control"
                            id="firstname"
                            name="firstname"
                            readonly
                            value="${user.firstName}"
                          />
                        </div>
                      </td>
                      <td>
                        <div class="form-group">
                          <input
                            type="text"
                            class="form-control"
                            id="lastname"
                            name="lastname"
                            readonly
                            value="${user.lastName}"
                          />
                        </div>
                      </td>
                      <td>
                        <div class="form-group">
                          <input
                            type="email"
                            class="form-control"
                            id="email"
                            name="email"
                            readonly
                            value="${user.email}"
                          />
                        </div>
                      </td>
                      <td>
                        <div class="form-group">
                          <input
                            type="text"
                            class="form-control"
                            id="username"
                            name="username"
                           	readonly
                            value="${user.userName}"
                          />
                        </div>
                      </td>
                      <td>
                        <div class="form-group">
                          <input
                            type="date"
                            class="form-control"
                            id="birthdate"
                            name="birthdate"
                            readonly
                            value="${user.birthDate}"
                          />
                        </div>
                      </td>
                      <td>
                        <div class="form-check form-check-inline">
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="radio"
                              name="gender"
                              id="male"
                              value="Male"
                              readonly
                              <core:if test="${user.gender eq 'Male'}">
                              	checked
                              </core:if>	
                            />
                            <label class="form-check-label" for="male"
                              >Male</label
                            >
                          </div>
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="radio"
                              name="gender"
                              id="female"
                              value="Female"
                              readonly
                              <core:if test="${user.gender eq 'Female'}">
                              	checked
                              </core:if>
                            />
                            <label class="form-check-label" for="female"
                              >Female</label
                            >
                          </div>
                        </div>
                      </td>
                      <td>
                        <div class="form-check form-check-inline">
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="checkbox"
                              name="english"
                              id="english"
                              value="English"
                               <core:forTokens var="language" delims=", " items="${user.knownLanguages}">
                              	<core:if test="${language eq 'English'}">
                              		checked
                              	</core:if>
                              </core:forTokens>
                            />
                            <label class="form-check-label" for="english"
                              >English</label
                            >
                          </div>
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="checkbox"
                              name="hindi"
                              id="hindi"
                              value="Hindi"
                              <core:forTokens var="language" delims=", " items="${user.knownLanguages}">
                              	<core:if test="${language eq 'Hindi'}">
                              		checked
                              	</core:if>
                              </core:forTokens>
                            />
                            <label class="form-check-label" for="hindi"
                              >Hindi</label
                            >
                          </div>
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="checkbox"
                              name="gujarati"
                              id="gujarati"
                              value="Gujarati"
                               <core:forTokens var="language" delims=", " items="${user.knownLanguages}">
                              	<core:if test="${language eq 'Gujarati'}">
                              		checked
                              	</core:if>
                              </core:forTokens>
                            />
                            <label class="form-check-label" for="gujarati">
                              Gujarati
                            </label>
                          </div>
                        </div>
                      </td>
                      <td>
                        <div class="form-group mx-sm-3 mb-2">
                        	<core:forEach items="${user.addresses}" var="address">
                        		<p>${address.id}</p>
                        		<p>${address.addressLine1}</p>
                        		<p>${address.addressLine2}</p>
                        		<p>${address.country.id}</p>
                        		<p>${address.country.name}</p>
                        		<p>${address.state.id}</p>
                        		<p>${address.state.name}</p>
                        		<p>${address.city.id}</p>
                        		<p>${address.city.name}</p>
                        		<p>${address.pincode}</p>
                        	</core:forEach>
                          <!-- <button class="btn btn-secondary btn-sm">
                            View Addresses
                          </button> -->
                        </div>
                      </td>
                      <td>
                        <div class="form-group mx-sm-3 mb-2">
                          <button type="submit" class="btn btn-primary btn-sm">Update</button>
                        </div>
                      </td>
                      <td>
                        <div class="form-group mx-sm-3 mb-2">
                          <button class="btn btn-danger btn-sm">Delete</button>
                        </div>
                      </td>
                    </div>
                  </form>
                </tr>
                </core:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </section>

	  <script src="js/jquery-3.7.0.min.js"></script>
	  <script src="js/jquery.repeater.js"></script>
	  <script src="js/popper.min.js"></script>
	  <script src="js/bootstrap.min.js"></script>
  </body>
</html>