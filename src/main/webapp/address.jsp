<div class="form-group">
			<label>Address :</label>
			<div
				style="padding: 2%; border: 2px solid #BABECC; border-radius: 25px;">
				<div class="d-flex justify-content-around">
					<div class="w-100 p-2">
						<label for="addressLine1">Address line 1</label> <input class="form-control"
							id="addressLine1" name="addressLine1" type="text" />
					</div>
					<div class="w-100 p-2">
						<label for="addressLine2">Address line 2</label> <input class="form-control"
							id="addressLine2" name="addressLine2" type="text" />
					</div>
				</div>
				<div class="d-flex justify-content-around">
					<div class="w-100 p-2">
						<label for="city">City</label> <select name="city" id="city"
							class="form-control">
							<option selected disabled>-- Select City --</option>
							<option value="Rajkot">Rajkot</option>
							<option value="Ahmedabad">Ahmedabad</option>
						</select>
					</div>
					<div class="w-100 p-2">
						<label for="state">State</label> <select name="state" id="state"
							class="form-control">
							<option selected disabled>-- Select State --</option>
							<option value="Gujarat">Gujarat</option>
							<option value="Maharashtra">Maharashtra</option>
						</select>
					</div>
					<div class="w-100 p-2">
						<label for="country">Country</label> <select name="country"
							id="country" class="form-control">
							<option selected disabled>-- Select Country --</option>
							<option value="India">India</option>
							<option value="Australia">Australia</option>
						</select>
					</div>
				</div>
				<div class="d-flex justify-content-between">
					<div class="p-2 w-50">
						<label for="pincode">Pincode</label> <input type="number"
							name="pincode" id="pincode" class="form-control" />
					</div>
					<div class="p-2">
						<label>&nbsp;</label>
						<div>
							<button data-repeater-delete type="button" class="btn btn-danger">Remove</button>
						</div>
					</div>
				</div>
			</div>
		</div>