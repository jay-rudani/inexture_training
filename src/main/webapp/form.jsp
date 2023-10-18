<%@page import="dto.User"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="utility.Address"%>
<%@page import="java.util.List"%>
<%!User user; %>
<%
	boolean isLoggedIn = 
		request.getSession().getAttribute("isLoggedIn") != null && 
		request.getSession().getAttribute("isLoggedIn").equals(true);

	if(isLoggedIn){
		if(request.getSession().getAttribute("userData")!=null && request.getSession().getAttribute("manageUserData")!=null){
			
			user = (User) request.getSession().getAttribute("manageUserData");
			
		}else{
			
			user = (User) request.getSession().getAttribute("userData");
		}
		
		user.setProfile_pic_string(user.getProfile_pic());
		List<Address> addressList = user.getAddresses();
		Gson gson = new Gson();
		String addressListAsJSON = gson.toJson(addressList); // Using Gson library to convert to JSON
		request.setAttribute("addressListAsJSON", addressListAsJSON);
	}
%>
<form id="registerForm" <% if(isLoggedIn){ %>action="UpdateServlet" <% }else{ %> action="RegisterServlet" <% } %> method="post" enctype="multipart/form-data" onsubmit="return validateFields()">
<input type="hidden" name="user_id" <% if(isLoggedIn) { %> value="<%=user.getId()%>" <%} %> />
<input type="hidden" name="user_uuid" <% if(isLoggedIn) { %> value="<%=user.getId()%>" <%} %> />
<div class="form-group">
	<% 
   		if (isLoggedIn) {
   	%>
   		<div class="profile-pic">	
			<img
			  class="img-fluid"
			  src="data:image;base64,<%=user.getProfile_pic_string() %>"
			  alt="profile_pic"
			/>
		</div>
		<input type="hidden" name="profile_pic_data" value="data:image;base64,<%=user.getProfile_pic_string() %>" />
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
	  	value="<%=user.getFirstName() %>"
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
	  	value="<%=user.getLastName()%>"
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
	  	value="<%=user.getEmail() %>"
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
	  	value="<%=user.getUserName()%>"
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
	  	value="<%=user.getBirthDate() %>"
	  <% } %>
	  required
	/>
	<small id="birthDateMessage"></small>
</div>
<%-- <jsp:include page="addressForProfile.jsp" /> --%>
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
	<% if(isLoggedIn){ if(user.getGender()!=null && user.getGender().equals("Male")) { %>
	 checked
	<% }} %>	
	 required />
	<label for="male">Male</label>
	<br />
	<input type="radio" name="gender" id="female" value="Female"
	<% if(isLoggedIn){ if(user.getGender()!=null && user.getGender().equals("Female")) { %>
	 checked
	<% }} %>	
	 required />
	<label for="female">Female</label>
</div>
<div class="form-group">
	<p>Known Languages :</p>
	<input type="checkbox" name="languages" id="english" value="English" 
	<%
		if(isLoggedIn){
		if(user.getKnownLanguages().contains("English")){
	%>
	checked
	<% }} %>
	/>
	<label for="english">English</label>
	<br />
	<input type="checkbox" name="languages" id="hindi" value="Hindi" 
	<%
		if(isLoggedIn){
		if(user.getKnownLanguages().contains("Hindi")){
	%>
	checked
	<% }} %>
	/>
	<label for="hindi">Hindi</label>
	<br />
	<input type="checkbox" name="languages" id="gujarati" value="Gujarati" 
	<%
		if(isLoggedIn){
		if(user.getKnownLanguages().contains("Gujarati")){
	%>
	checked
	<% }} %>
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

<script>
var addressList = ${addressListAsJSON};

$(document).ready(function () {
	var registrationForm = $('#registerForm');
    var addressesListContainer = registrationForm.find('[data-repeater-list="items"]');

    let myIndex = 0;
    addressList.forEach(function (address, newIndex) {
        // Clone the first item in the repeater and set unique data attributes
        var addressTemplate = addressesListContainer.find('[data-repeater-item]:first').clone();

       	// Update the name attributes to be unique
       	addressTemplate.find('[name="items[0][addressId]"]').attr('name', 'items[' + newIndex + '][addressId]');
        addressTemplate.find('[name="items[0][addressLine1]"]').attr('name', 'items[' + newIndex + '][addressLine1]');
        addressTemplate.find('[name="items[0][addressLine2]"]').attr('name', 'items[' + newIndex + '][addressLine2]');
        addressTemplate.find('[name="items[0][country]"]').attr('name', 'items[' + newIndex + '][country]');
        addressTemplate.find('[name="items[0][state]"]').attr('name', 'items[' + newIndex + '][state]');
        addressTemplate.find('[name="items[0][city]"]').attr('name', 'items[' + newIndex + '][city]');
        addressTemplate.find('[name="items[0][pincode]"]').attr('name', 'items[' + newIndex + '][pincode]');

        // Set the values in the cloned template
        addressTemplate.find('[name="items[' + newIndex + '][addressId]"]').val(address.id);
        addressTemplate.find('[name="items[' + newIndex + '][addressLine1]"]').val(address.addressLine1);
        addressTemplate.find('[name="items[' + newIndex + '][addressLine2]"]').val(address.addressLine2);
        addressTemplate.find('[name="items[' + newIndex + '][country]"]').append('<option selected value="'+address.country.id+'">'+address.country.name+'</option>');
        addressTemplate.find('[name="items[' + newIndex + '][state]"]').append('<option selected value="'+address.state.id+'">'+address.state.name+'</option>');
        addressTemplate.find('[name="items[' + newIndex + '][city]"]').append('<option selected value="'+address.city.id+'">'+address.city.name+'</option>');
        addressTemplate.find('[name="items[' + newIndex + '][pincode]"]').val(address.pincode);
        // Continue with other fields as needed

        // Append the populated template to the repeater container
        addressesListContainer.append(addressTemplate);

        newIndex++; // Increment the index for the next item
        myIndex++;
    });
    
	setTimeout(function(){populateCountryDropdown(0);},100);

    setTimeout(function(){
    	for(let i=0;i<myIndex;i++){
    		setCountryValues(i);
    	}
    },500);
    setTimeout(function(){
    	for(let i=0;i<myIndex;i++){
    		setStateValues($("select#country_" + i).val(),i);
    	}
    },510);
    setTimeout(function(){
    	for(let i=0;i<myIndex;i++){
    		setCityValues($("select#state_" + i).val(),i);
    	}
    },600);
});
</script>
<% } %>