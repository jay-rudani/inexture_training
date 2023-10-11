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
  <div style="padding: 2%; border: 2px solid #babecc; border-radius: 25px">
    <div class="d-flex justify-content-around">
      <div class="w-100 p-2">
        <label for="addressLine1">Address line 1</label>
        <input
          class="form-control"
          id="addressLine1"
          name="addressLine1"
          type="text"
          value='<%=address.getAddressLine1() %>'
        />
      </div>
      <div class="w-100 p-2">
        <label for="addressLine2">Address line 2</label>
        <input
          class="form-control"
          id="addressLine2"
          name="addressLine2"
          type="text"
          value="<%=address.getAddressLine2() %>"
        />
      </div>
    </div>
    <div class="d-flex justify-content-around">
      <div class="w-100 p-2">
        <label for="country">Country</label>
        <select name="country" id="country_<%=n %>" class="form-control country" onchange="countryFn(this.id)">
        	<option selected value="<%=address.getCountry().getId() %>"><%=address.getCountry().getName() %></option>
        </select>
      </div>
      <div class="w-100 p-2">
        <label for="state">State</label>
        <select name="state" id="state_<%=n %>" onchange="stateFn(this.id)" class="form-control state" >
        	<option value="<%=address.getState().getId() %>"><%=address.getState().getName() %></option>
        </select>
      </div>
      <div class="w-100 p-2">
        <label for="city">City</label>
        <select name="city" id="city_<%=n %>" class="form-control city" >
        	<option value="<%=address.getCity().getId() %>"><%=address.getCity().getName() %></option>
        </select>
      </div>
    </div>
    <div class="d-flex justify-content-between">
      <div class="p-2 w-50">
        <label for="pincode">Pincode</label>
        <input type="number" id="pincode" name="pincode" class="form-control" value="<%=address.getPincode() %>"/>
      </div>
      <div class="p-2">
        <label for="removeBtn">&nbsp;</label>
        <div>
          <button type="button" class="btn btn-danger">
            Remove
          </button>
        </div>
      </div>
    </div>
  </div>
</div>
<% n++; }%> 

<script>
<%for(int a=n-1;a>0;a--){%>
populateCountryDropdown(<%=a%>);
<%}%>
</script>

<script>
$(function(){
<%for(int a=n-1;a>0;a--){%>
populateStateDropdown(<%=a%>,$("select#country_" + <%=a%>).val());
<%}%>
});
</script>

<script>
$(function(){
<%for(int a=n-1;a>0;a--){%>
setTimeout(function(){populateCityDropdown(<%=a%>,$("select#state_" + <%=a%>).val())},100);
<%}%>
});
</script>
	
<%} %>