<%
boolean isLoggedIn = 
		request.getSession().getAttribute("isLoggedIn") != null && 
		request.getSession().getAttribute("isLoggedIn").equals(true);
%>
<form id="registerForm" <% if(isLoggedIn){ %>action="UpdateServlet" <% }else{ %> action="RegisterServlet" <% } %> method="post" enctype="multipart/form-data" onsubmit="return validateFields()">
<div class="form-group">
	<% 
   		if (isLoggedIn) {
   	%>
   		<div class="profile-pic">	
			<img
			  class="img-fluid"
			  src="data:image;base64,<%=request.getParameter("profile_pic")%>"
			  alt="profile_pic"
			/>
		</div>
		<input type="hidden" name="profile_pic_data" value="data:image;base64,<%=request.getParameter("profile_pic")%>" />
		<div class="change-pic-btn mt-4">
          <input
            type="file"
            name="profile_picture"
            id="profile_picture"
            class="d-none"
          />
          <label for="profile_picture" class="changeBtn"
            >Change Photo</label
          >
        </div>
	<% } else { %>
		<label for="profilepic" class="fileLabel"
		  ><b class="addIcon">Add Image</b></label>
		<input
		  type="file"
		  id="profilepic"
		  name="profilepic"
		  class="form-control"
		  required
		/>
	<% } %>
</div>
<div class="form-group">
	<label for="firstname">First Name :</label>
	<input
	  type="text"
	  name="firstname"
	  id="firstname"
	  class="form-control"
	  <% if(isLoggedIn) { %>
	  	value="<%=request.getParameter("firstname") %>"
	  <% } %>
	  required
	/>
	<small id="firstNameMessage"></small>
</div>
<div class="form-group">
	<label for="lastname">Last Name :</label>
	<input
	  type="text"
	  name="lastname"
	  id="lastname"
	  class="form-control"
	  <% if(isLoggedIn) { %>
	  	value="<%=request.getParameter("lastname") %>"
	  <% } %>
	  required
	/>
	<small id="lastNameMessage"></small>
</div>
<div class="form-group">
	<label for="email">Email :</label>
	<input
	  type="email"
	  name="email"
	  id="email"
	  class="form-control"
	  <% if(isLoggedIn) { %>
	  	value="<%=request.getParameter("email") %>"
	  <% } %>
	  required
	/>
	<small id="emailMessage"></small>
</div>
<div class="form-group">
	<label for="username">Username :</label>
	<input
	  type="text"
	  name="username"
	  id="username"
	  class="form-control"
	  <% if(isLoggedIn) { %>
	  	value="<%=request.getParameter("username") %>"
	  <% } %>
	  required
	/>
	<small id="userNameMessage"></small>
</div>
<% if(!isLoggedIn) { %>
<div class="form-group">
	<label for="password">Password :</label>
	<input
	  type="password"
	  name="password"
	  id="password"
	  class="form-control"
	  required
	/>
	<small id="passwordMessage"></small>
</div>
<% } %>
<div class="form-group">
	<label for="birthdate">Birth Date :</label>
	<input
	  type="date"
	  name="birthdate"
	  id="birthdate"
	  class="form-control"
	  <% if(isLoggedIn) { %>
	  	value="<%=request.getParameter("birthdate") %>"
	  <% } %>
	  required
	/>
	<small id="birthDateMessage"></small>
</div>
<jsp:include page="addressForProfile.jsp" />
<div data-repeater-list="items">
	<div data-repeater-item>
	  	<jsp:include page="address.jsp" />
	</div>
</div>
<div class="form-group">
	<button
	  id="addAnotherBtn"
	  data-repeater-create
	  type="button"
	  class="btn btn-secondary"
	>
	  Add another
	</button>
</div>
<div class="form-group">
	<p>Gender :</p>
	<input type="radio" name="gender" id="male" value="Male"
	<% if(request.getParameter("gender")!=null && request.getParameter("gender").equals("Male") && isLoggedIn) { %>
	 checked
	<% } %>	
	 required />
	<label for="male">Male</label>
	<br />
	<input type="radio" name="gender" id="female" value="Female"
	<% if(request.getParameter("gender")!=null && request.getParameter("gender").equals("Female") && isLoggedIn) { %>
	 checked
	<% } %>	
	 required />
	<label for="female">Female</label>
</div>
<div class="form-group">
	<p>Known Languages :</p>
	<input type="checkbox" name="languages" id="english" value="English" 
	<%
		if(request.getParameter("english")!=null){
	%>
	checked
	<% } %>
	/>
	<label for="english">English</label>
	<br />
	<input type="checkbox" name="languages" id="hindi" value="Hindi" 
	<%
		if(request.getParameter("hindi")!=null){
	%>
	checked
	<% } %>
	/>
	<label for="hindi">Hindi</label>
	<br />
	<input type="checkbox" name="languages" id="gujarati" value="Gujarati" 
	<%
		if(request.getParameter("gujarati")!=null){
	%>
	checked
	<% } %>
	/>
	<label for="gujarati">Gujarati</label>
</div>
<div class="d-flex justify-content-around">
	<% if(isLoggedIn) { %>
		<button type="submit" class="btn btn-success">Save Changes</button>
	<% }else{ %>
	<button type="submit" class="btn btn-success">Register</button>
    <a class="btn btn-primary" href="login.jsp"> Login </a>
    <% } %>
</div>
</form>
<% if(isLoggedIn){ %>
<script>
	$(function(){
		$("#removeBtnForRepeater").click();
		$(".removeBtnForSavedAddress").click(function () {
			/* $(this).closest("div.form-group").prop("disabled", true); */
	        let item = $(this).closest("div.form-group");
			item.find("input").prop("disabled",true);
			item.find("select").prop("disabled",true);
			item.slideUp(400);
	    });
	});
</script>
<% } %>