$(document).ready(function() {

	$("#registerForm").repeater({
		show: function() {
			$(this).slideDown();
		},
		hide: function(deleteElement) {
			if (confirm("Are you sure you want to delete this item?")) {
				$(this).slideUp(deleteElement);
			}
		},
	});

	function populateCountryDropdown() {
		let countryDropdown = $('select[id="country"]');
		console.log(countryDropdown);
		countryDropdown.empty();
		countryDropdown.append('<option selected disabled>Select Country</option>');

		$.get("CountryServlet", function(countries) {
			countries.forEach(function(country) {
				countryDropdown.append('<option value="' + country.id + '">' + country.name + '</option>')
			})
		})
	}

	function populateStateDropdown(countryId) {
		let stateDropdown = $('select[id="state"]');
		stateDropdown.empty();
		stateDropdown.append('<option selected disabled>Select State</option>');

		$.get("StateServlet?countryId=" + countryId, function(states) {
			states.forEach(function(state) {
				stateDropdown.append('<option value="' + state.id + '">' + state.name + '</option>')
			})
		})
	}

	function populateCityDropdown(stateId) {
		let cityDropdown = $('select[id="city"]');
		cityDropdown.empty();
		cityDropdown.append('<option selected disabled>Select City</option>');

		$.get("CityServlet?stateId=" + stateId, function(cities) {
			cities.forEach(function(city) {
				cityDropdown.append('<option value="' + city.id + '">' + city.name + '</option>')
			})
		})
	}

	populateCountryDropdown();

	$(".country").change(function() {
		let selectedCountryId = $(this).val();
		if (selectedCountryId != "") {
			populateStateDropdown(selectedCountryId);
		} else {
			$(".state").empty();
			$(".city").empty();
		}
	});

	$(".state").change(function() {
		let selectedStateId = $(this).val();
		if (selectedStateId != "") {
			populateCityDropdown(selectedStateId);
		} else {
			$(".city").empty();
		}
	});
});