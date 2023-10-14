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
			$(this).slideUp(deleteElement);
		},
	});

	populateCountryDropdown(0);
	//populateCountryDropdown(1);
});

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
function savedCountryFn(id) {
	let index = id.split("_")[1];
	let selectedCountryId = $("#" + id).val();
	let stateId = "savedState_" + index;
	let cityId = "savedCity_" + index;
	if (selectedCountryId != "") {
		populateSavedStateDropdown(index, selectedCountryId);
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
function savedStateFn(id) {
	let index = id.split("_")[1];
	let selectedStateId = $("#" + id).val();
	let cityId = "savedCity_" + index;
	if (selectedStateId != "") {
		populateSavedCityDropdown(index, selectedStateId);
	} else {
		$("#" + cityId).empty();
	}
}
function populateCountryDropdown(newCountryIndex) {
	let countryDropdown = $("#country_" + newCountryIndex);
	countryDropdown.empty();
	countryDropdown.append('<option selected disabled>Select Country</option>');

	$.get("CountryServlet", function(countries) {
		countries.forEach(function(country) {
			countryDropdown.append('<option value="' + country.id + '">' + country.name + '</option>');
		});
	});
}
function populateSavedCountryDropdown(newCountryIndex) {
	let countryDropdown = $("#savedCountry_" + newCountryIndex);
	let selectedVal = $("select#savedCountry_" + newCountryIndex).val();
	countryDropdown.empty();
	countryDropdown.append('<option selected disabled>Select Country</option>');

	$.get("CountryServlet", function(countries) {
		countries.forEach(function(country) {
			countryDropdown.append('<option value="' + country.id + '">' + country.name + '</option>')
		});

		$("select#savedCountry_" + newCountryIndex).val(selectedVal);
	});
}

function populateStateDropdown(stateId, countryId) {
	let stateDropdown = $('select[id="state_' + stateId + '"]');
	stateDropdown.empty();
	stateDropdown.append('<option selected disabled>Select State</option>');

	$.get("StateServlet?countryId=" + countryId, function(states) {
		states.forEach(function(state) {
			stateDropdown.append('<option value="' + state.id + '">' + state.name + '</option>')
		});
	});
}
function populateSavedStateDropdown(stateId, countryId) {
	let stateDropdown = $('select[id="savedState_' + stateId + '"]');
	let selectedVal = $("select#savedState_" + stateId).val();
	stateDropdown.empty();
	stateDropdown.append('<option selected disabled>Select State</option>');

	$.get("StateServlet?countryId=" + countryId, function(states) {
		states.forEach(function(state) {
			stateDropdown.append('<option value="' + state.id + '">' + state.name + '</option>')
		});

		$("select#savedState_" + stateId).val(selectedVal);
	});
}
function populateCityDropdown(cityId, stateId) {
	let cityDropdown = $('select[id="city_' + cityId + '"]');
	cityDropdown.empty();
	cityDropdown.append('<option selected disabled>Select City</option>');

	$.get("CityServlet?stateId=" + stateId, function(cities) {
		cities.forEach(function(city) {
			cityDropdown.append('<option value="' + city.id + '">' + city.name + '</option>')
		});
	});
}
function populateSavedCityDropdown(cityId, stateId) {
	let cityDropdown = $('select[id="savedCity_' + cityId + '"]');
	let selectedVal = $("select#savedCity_" + cityId).val();
	cityDropdown.empty();
	cityDropdown.append('<option selected disabled>Select City</option>');

	$.get("CityServlet?stateId=" + stateId, function(cities) {
		cities.forEach(function(city) {
			cityDropdown.append('<option value="' + city.id + '">' + city.name + '</option>')
		});

		$("select#savedCity_" + cityId).val(selectedVal);
	});
}