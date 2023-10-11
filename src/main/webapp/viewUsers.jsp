<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <tr>
                  <form class="form-inline">
                    <div class="mainDiv">
                      <td>
                        <div class="form-group">
                          <input
                            type="text"
                            class="form-control"
                            id="firstname"
                            name="firstname"
                            value=""
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
                            value=""
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
                            value=""
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
                            value=""
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
                            value=""
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
                              name="kl"
                              id="english"
                              value="English"
                            />
                            <label class="form-check-label" for="english"
                              >English</label
                            >
                          </div>
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="checkbox"
                              name="kl"
                              id="hindi"
                              value="Hindi"
                            />
                            <label class="form-check-label" for="hindi"
                              >Hindi</label
                            >
                          </div>
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="checkbox"
                              name="kl"
                              id="gujarati"
                              value="Gujarati"
                            />
                            <label class="form-check-label" for="gujarati">
                              Gujarati
                            </label>
                          </div>
                        </div>
                      </td>
                      <td>
                        <div class="form-group mx-sm-3 mb-2">
                          <button class="btn btn-secondary btn-sm">
                            View Addresses
                          </button>
                        </div>
                      </td>
                      <td>
                        <div class="form-group mx-sm-3 mb-2">
                          <button class="btn btn-primary btn-sm">Update</button>
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
                <tr>
                  <form class="form-inline">
                    <div class="mainDiv">
                      <td>
                        <div class="form-group">
                          <input
                            type="text"
                            class="form-control"
                            id="firstname"
                            name="firstname"
                            value=""
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
                            value=""
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
                            value=""
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
                            value=""
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
                            value=""
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
                              name="kl"
                              id="english"
                              value="English"
                            />
                            <label class="form-check-label" for="english"
                              >English</label
                            >
                          </div>
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="checkbox"
                              name="kl"
                              id="hindi"
                              value="Hindi"
                            />
                            <label class="form-check-label" for="hindi"
                              >Hindi</label
                            >
                          </div>
                          <div class="form-check form-check-inline">
                            <input
                              class="form-check-input"
                              type="checkbox"
                              name="kl"
                              id="gujarati"
                              value="Gujarati"
                            />
                            <label class="form-check-label" for="gujarati">
                              Gujarati
                            </label>
                          </div>
                        </div>
                      </td>
                      <td>
                        <div class="form-group mx-sm-3 mb-2">
                          <button class="btn btn-secondary btn-sm">
                            View Addresses
                          </button>
                        </div>
                      </td>
                      <td>
                        <div class="form-group mx-sm-3 mb-2">
                          <button class="btn btn-primary btn-sm">Update</button>
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