$(document).ready(function() {

	$("#registerForm").repeater({
		show: function() {
			$(this).slideDown();
			let countryIndex = $(this).find(".country").attr("id");
			let stateIndex = $(this).find(".state").attr("id");
			populateCountryDropdown(countryIndex.split("_")[1]);
			populateStateDropdown(stateIndex.split("_")[1]);
		},
		hide: function(deleteElement) {
			if (confirm("Are you sure you want to delete this item?")) {
				$(this).slideUp(deleteElement);
			}
		},
	});

	populateCountryDropdown(0);
	//populateCountryDropdown(1);
});

function populateCountryDropdown(newCountryIndex) {
	let countryDropdown = $("#country_" + newCountryIndex);
	let selectedVal = $("select#country_" + newCountryIndex).val();
	countryDropdown.empty();
	countryDropdown.append('<option selected disabled>Select Country</option>');

	$.get("CountryServlet", function(countries) {
		countries.forEach(function(country) {
			countryDropdown.append('<option value="' + country.id + '">' + country.name + '</option>')
		});

		$("select#country_" + newCountryIndex).val(selectedVal == null ? "" : selectedVal);
	});


}

function countryFn(id) {
	let index = id.split("_")[1];
	let selectedCountryId = $("#" + id).val();
	let stateId = "state_" + index;
	let cityId = "city_" + index;
	if (selectedCountryId != "") {
		populateStateDropdown(index, selectedCountryId);
	} else {
		$("#" + stateId).empty();
		$("#" + cityId).empty();
	}
}
function stateFn(id) {
	let index = id.split("_")[1];
	let selectedStateId = $("#" + id).val();
	let cityId = "city_" + index;
	if (selectedStateId != "") {
		populateCityDropdown(index, selectedStateId);
	} else {
		$("#" + cityId).empty();
	}
}
function populateStateDropdown(stateId, countryId) {
	console.log(stateId + "_" + countryId);
	let stateDropdown = $('select[id="state_' + stateId + '"]');
	let selectedVal = $("select#state_" + stateId).val();
	console.log("state selected val "+selectedVal)
	stateDropdown.empty();
	stateDropdown.append('<option selected disabled>Select State</option>');

	$.get("StateServlet?countryId=" + countryId, function(states) {
		states.forEach(function(state) {
			stateDropdown.append('<option value="' + state.id + '">' + state.name + '</option>')
		});
	console.log("state selected val...2 "+selectedVal)

		$("select#state_" + stateId).val(selectedVal == null ? "" : selectedVal);
		
			console.log("state selected val...2 "+selectedVal);
			//populateCityDropdown(stateId,selectedVal);

	})
}
function populateCityDropdown(cityId, stateId) {
	console.log(cityId + "_" + stateId);
	let cityDropdown = $('select[id="city_' + cityId + '"]');
	let selectedVal = $("select#city_" + cityId).val();
	console.log("city id "+selectedVal)
	cityDropdown.empty();
	cityDropdown.append('<option selected disabled>Select City</option>');

	$.get("CityServlet?stateId=" + stateId, function(cities) {
		cities.forEach(function(city) {
			cityDropdown.append('<option value="' + city.id + '">' + city.name + '</option>')
		});

		$("select#city_" + cityId).val(selectedVal == null ? "" : selectedVal);
	})
}