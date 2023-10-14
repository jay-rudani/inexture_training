<%@page import="utility.Address"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="dto.User"%>
<%!User user; %>
<%
	user = (User) request.getSession().getAttribute("userData");
%>
<section>
 <div class="container">
   <div class="row p-3">
     <div class="col-md-12">
       <form action="register.jsp" method="post" id="profileForm">
         <div class="form-div d-md-flex d-sm-block">
           <div class="profile-pic-div p-2 w-100">
             <div class="profile-pic">
               <% 
               		byte[] profile_pic = user.getProfile_pic();
               		if (profile_pic != null) { 
               			String base64Image = new String(Base64.getEncoder().encode(profile_pic)); %>
					<img
					  class="img-fluid"
					  src="data:image;base64,<%=base64Image%>"
					  alt="profile_pic"
					  
					/>
					<input type="hidden" value="<%=base64Image%>" name="profile_pic" />
				<% } %>	
             </div>
             <div class="birth-date mt-2">
               <div class="form-group">
                 <label for="birthdate">Birth Date :</label>
                 <input
                   type="date"
                   class="form-control"
                   name="birthdate"
                   id="birthdate"
                   value="<%=user.getBirthDate() %>"
                 />
               </div>
             </div>
           </div>
           <div class="profile-field-div p-2 w-100">
             <div class="d-flex justify-content-around">
               <div class="form-group p-2">
                 <label for="email">Email :</label>
                 <input
                   type="email"
                   id="email"
                   name="email"
                   class="form-control"
                   value="<%=user.getEmail() %>"
                 />
               </div>
               <div class="form-group p-2">
                 <label for="username">Username :</label>
                 <input
                   type="text"
                   id="username"
                   name="username"
                   class="form-control"
                   value="<%=user.getUserName() %>"
                 />
               </div>
             </div>
             <div class="d-flex justify-content-around">
               <div class="form-group p-2">
                 <label for="firstname">First Name :</label>
                 <input
                   type="text"
                   id="firstname"
                   name="firstname"
                   class="form-control"
                   value="<%=user.getFirstName() %>"
                 />
               </div>
               <div class="form-group p-2">
                 <label for="lastname">Last Name :</label>
                 <input
                   type="text"
                   id="lastname"
                   name="lastname"
                   class="form-control"
                   value="<%=user.getLastName() %>"
                 />
               </div>
             </div>
             <div class="d-flex justify-content-between">
               <div class="form-group p-2">
                 <label>Gender :</label>
                 <div>
                   <input
                     type="radio"
                     name="gender"
                     id="male"
                     value="Male"
                     <% if(user.getGender().equals("Male")) { %>
                     checked
                     <% } %>
                   />
                   <label for="male">Male</label>
                   <br />
                   <input
                     type="radio"
                     name="gender"
                     id="female"
                     value="Female"
                     <% if(user.getGender().equals("Female")) { %>
                     checked
                     <% } %>
                   />
                   <label for="female">Female</label>
                 </div>
               </div>
               <div class="form-group p-2">
               <%
               		String knownLanguages = user.getKnownLanguages();
                	List<String> languages = Arrays.asList(knownLanguages.split(", "));
               %>
                 <label>Known languages :</label>
                 <div>
                   <input
                     type="checkbox"
                     name="english"
                     id="english"
                     value="English"
                     <% if(languages.contains("English")) { %>
                     checked
                     <% } %>
                   />
                   <label for="english">English</label>
                   <br />
                   <input
                     type="checkbox"
                     name="hindi"
                     id="hindi"
                     value="Hindi"
                     <% if(languages.contains("Hindi")) { %>
                     checked
                     <% } %>
                   />
                   <label for="hindi">Hindi</label>
                   <br />
                   <input
                     type="checkbox"
                     name="gujarati"
                     id="gujarati"
                     value="Gujarati"
                     <% if(languages.contains("Gujarati")) { %>
                     checked
                     <% } %>
                   />
                   <label for="gujarati">Gujarati</label>
                 </div>
               </div>
             </div>
             <div>
				<jsp:include page="addressForProfile.jsp"></jsp:include>
             </div>
             
             <div class="d-flex justify-content-around">
               <button type="submit" class="btn btn-primary">Edit</button>
             </div>
           </div>
         </div>
       </form>
     </div>
   </div>
 </div>
</section>