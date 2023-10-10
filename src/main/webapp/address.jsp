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
          required
        />
      </div>
    </div>
    <div class="d-flex justify-content-around">
      <div class="w-100 p-2">
        <label for="country">Country</label>
        <select name="country" id="country" class="form-control country" onchange="myId(this.id)" required>
        </select>
      </div>
      <div class="w-100 p-2">
        <label for="state">State</label>
        <select name="state" id="state" class="form-control state" required>
        </select>
      </div>
      <div class="w-100 p-2">
        <label for="city">City</label>
        <select name="city" id="city" class="form-control city" required>
        </select>
      </div>
    </div>
    <div class="d-flex justify-content-between">
      <div class="p-2 w-50">
        <label for="pincode">Pincode</label>
        <input type="number" id="pincode" name="pincode" class="form-control" required/>
      </div>
      <div class="p-2">
        <label for="removeBtn">&nbsp;</label>
        <div>
          <button data-repeater-delete type="button" class="btn btn-danger">
            Remove
          </button>
        </div>
      </div>
    </div>
  </div>
</div>
