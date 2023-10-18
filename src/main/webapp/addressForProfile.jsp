<%@page import="utility.Address"%>
<%@page import="java.util.List"%>
<%
	List<Address> addresses;
	int n=1;
	if(request.getSession().getAttribute("userAddresses")!=null) {
		addresses = (List<Address>) request.getSession().getAttribute("userAddresses");
		for(Address address:addresses){
%>
<div class="form-group">
  <label>Address :</label>
  <div style="padding: 2%; border: 2px solid #babecc; border-radius: 25px" >
    <div class="d-flex justify-content-around">
      <div class="w-100 p-2">
      	<input type="hidden" name="savedAddressId_<%=n %>" value="<%=address.getId() %>" />
        <label for="addressLine1">Address line 1</label>
        <input
          class="form-control"
          id="savedAddressLine1_<%=n %>"
          name="savedAddressLine1_<%=n %>"
          type="text"
          value='<%=address.getAddressLine1() %>'
        />
      </div>
      <div class="w-100 p-2">
        <label for="addressLine2">Address line 2</label>
        <input
          class="form-control"
          id="savedAddressLine2_<%=n %>"
          name="savedAddressLine2_<%=n %>"
          type="text"
          value="<%=address.getAddressLine2() %>"
        />
      </div>
    </div>
    <div class="d-flex justify-content-around">
      <div class="w-100 p-2">
        <label for="country">Country</label>
        <select name="savedCountry_<%=n %>" id="savedCountry_<%=n %>" class="form-control country" onchange="savedCountryFn(this.id)">
        	<option selected value="<%=address.getCountry().getId() %>"><%=address.getCountry().getName() %></option>
        </select>
      </div>
      <div class="w-100 p-2">
        <label for="state">State</label>
        <select name="savedState_<%=n %>" id="savedState_<%=n %>" onchange="savedStateFn(this.id)" class="form-control state" >
        	<option value="<%=address.getState().getId() %>"><%=address.getState().getName() %></option>
        </select>
      </div>
      <div class="w-100 p-2">
        <label for="city">City</label>
        <select name="savedCity_<%=n %>" id="savedCity_<%=n %>" class="form-control city" >
        	<option value="<%=address.getCity().getId() %>"><%=address.getCity().getName() %></option>
        </select>
      </div>
    </div>
    <div class="d-flex justify-content-between">
      <div class="p-2 w-50">
        <label for="pincode">Pincode</label>
        <input type="number" id="savedPincode_<%=n %>" name="savedPincode_<%=n %>" class="form-control" value="<%=address.getPincode() %>"/>
      </div>
      <div class="p-2">
        <label for="removeBtn">&nbsp;</label>
        <div>
          <button type="button" class="btn btn-danger removeBtnForSavedAddress">
            Remove
          </button>
        </div>
      </div>
    </div>
  </div>
</div>
<% n++; }%> 

<%-- <script>
	<%for(int a=n-1;a>0;a--){%>
	populateSavedCountryDropdown(<%=a%>);
	<%}%>
</script>

<script>
	$(function(){
	<%for(int a=n-1;a>0;a--){%>
	setTimeout(function(){populateSavedStateDropdown(<%=a%>,$("select#savedCountry_" + <%=a%>).val())},50);
	<%}%>
	});
</script>

<script>
	$(function(){
	<%for(int a=n-1;a>0;a--){%>
	setTimeout(function(){populateSavedCityDropdown(<%=a%>,$("select#savedState_" + <%=a%>).val())},100);
	<%}%>
	});
</script> --%>
	
<% } %>