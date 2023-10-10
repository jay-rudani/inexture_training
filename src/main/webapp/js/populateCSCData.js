$(document).ready(function() {

	$("#registerForm").repeater({
		show: function() {
			$(this).slideDown();
			let countryIndex = $(this).find(".country").attr("id");
			populateCountryDropdown(countryIndex.split("_")[1]);
		},
		hide: function(deleteElement) {
			if (confirm("Are you sure you want to delete this item?")) {
				$(this).slideUp(deleteElement);
			}
		},
	});

	function populateCountryDropdown(newCountryIndex) {
		/*let countryDropdown = $('select[id="country"]');*/
		let countryDropdown = $("#country_" + newCountryIndex);
		/*console.log(countryDropdown);*/
		countryDropdown.empty();
		countryDropdown.append('<option selected disabled>Select Country</option>');

		$.get("CountryServlet", function(countries) {
			countries.forEach(function(country) {
				countryDropdown.append('<option value="' + country.id + '">' + country.name + '</option>')
			})
		})
	}



	populateCountryDropdown(0);

	/*$(".country").change(function() {
		let selectedCountryId = $(this).val();
		if (selectedCountryId != "") {
			populateStateDropdown(selectedCountryId);
		} else {
			$(".state").empty();
			$(".city").empty();
		}
	});*/

	$(".state").change(function() {
		let selectedStateId = $(this).val();
		if (selectedStateId != "") {
			populateCityDropdown(selectedStateId);
		} else {
			$(".city").empty();
		}
	});
});
function myId(id) {
	let index = id.split("_")[1];
	let selectedCountryId = $("#" + id).val();
	let stateId = "state_" + index;
	if (selectedCountryId != "") {
		populateStateDropdown(stateId, selectedCountryId);
	} else {
		$("#" + stateId).empty();
		$(".city").empty();
	}
}
function populateStateDropdown(stateId, countryId) {
	let stateDropdown = $('select[id="' + stateId + '"]');
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