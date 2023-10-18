<%
	if(request.getSession().getAttribute("isLoggedIn")!=null
	&& request.getSession().getAttribute("isLoggedIn").equals(true)) {
%>
<section>
	<nav class="navbar navbar-expand-lg navbar-light">
	  <a class="navbar-brand p-2" href="home.jsp">Home</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarText">
	    <ul class="navbar-nav mr-auto">
	    	<%
	    		if(request.getSession().getAttribute("isADMIN")!=null
	    		&& request.getSession().getAttribute("isADMIN").equals(true)){
	    	%>
	    	<li class="nav-item">
        		<a class="nav-link" href="viewUsers.jsp">View Users</a>
      		</li>
      		<%
	    		}
      		%>
	    </ul>
	    <span class="navbar-text">
	      <a href="LogoutServlet" class="btn logoutBtn">Logout</a>
	    </span>
	  </div>
	</nav>
</section>
<% } %>