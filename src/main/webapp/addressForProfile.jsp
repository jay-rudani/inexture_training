<%@page import="utility.Address"%>
<%@page import="java.util.List"%>
<%
	List<Address> addresses;
	int n=0;
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
          required
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
          required
        />
      </div>
    </div>
    <div class="d-flex justify-content-around">
      <div class="w-100 p-2">
        <label for="country<%=n %>">Country</label>
        <select name="country<%=n %>" id="country<%=n %>" class="form-control country" required>
        	<option value="<%=address.getCountry().getId() %>"><%=address.getCountry().getName() %></option>
        </select>
      </div>
      <div class="w-100 p-2">
        <label for="state<%=n %>">State</label>
        <select name="state<%=n %>" id="state<%=n %>" class="form-control state" required>
        	<option value="<%=address.getState().getId() %>"><%=address.getState().getName() %></option>
        </select>
      </div>
      <div class="w-100 p-2">
        <label for="city<%=n %>">City</label>
        <select name="city<%=n %>" id="city<%=n %>" class="form-control city" required>
        	<option value="<%=address.getCity().getId() %>"><%=address.getCity().getName() %></option>
        </select>
      </div>
    </div>
    <div class="d-flex justify-content-between">
      <div class="p-2 w-50">
        <label for="pincode">Pincode</label>
        <input type="number" id="pincode" name="pincode" class="form-control" value="<%=address.getPincode() %>" required/>
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
<% n++; } } %>
