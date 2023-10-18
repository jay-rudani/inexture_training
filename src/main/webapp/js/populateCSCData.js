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
let countriesList = "";
function populateCountryDropdown(newCountryIndex) {
	let countryDropdown = $("#country_" + newCountryIndex);
	//let selectedVal = $("select#country_" + newCountryIndex).val();
	countryDropdown.empty();
	countryDropdown.append('<option selected disabled>Select Country</option>');

	$.get("CountryServlet", function(countries) {
		countriesList = countries;
		//console.log("CountryList set")
		countries.forEach(function(country) {
			countryDropdown.append('<option value="' + country.id + '">' + country.name + '</option>');
		});
		//$("select#country_" + newCountryIndex).val(selectedVal);
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
function setCountryValues(newCountryIndex) {
	/*console.log("newCountryIndex ",newCountryIndex)*/
	let countryDropdown = $("#country_" + newCountryIndex);
	/*console.log(countryDropdown)*/
	let selectedVal = $("select#country_" + newCountryIndex).val();
	/*console.log(" newIndex "+newCountryIndex+" selectedVal "+selectedVal);*/
	//countryDropdown.empty();
	countryDropdown.append('<option selected disabled>Select Country</option>');
	/*console.log("countriesList ",countriesList);*/
	for (i in countriesList) {
		//console.log(countriesList[i].name);
		countryDropdown.append('<option value="' + countriesList[i].id + '">' + countriesList[i].name + '</option>');
	}
	$("select#country_" + newCountryIndex).val(selectedVal);
}
function setStateValues(newCountryIndex, newStateIndex) {
	let stateDropdown = $('select[id="state_' + newStateIndex + '"]');
	let selectedVal = $("select#state_" + newStateIndex).val();
	/*stateDropdown.empty();*/
	stateDropdown.append('<option selected disabled>Select State</option>');

	$.get("StateServlet?countryId=" + newCountryIndex, function(states) {
		states.forEach(function(state) {
			stateDropdown.append('<option value="' + state.id + '">' + state.name + '</option>')
		});

		$("select#state_" + newStateIndex).val(selectedVal);
	});
}
function setCityValues(newStateIndex, newCityIndex) {
	let cityDropdown = $('select[id="city_' + newCityIndex + '"]');
	let selectedVal = $("select#city_" + newCityIndex).val();
	cityDropdown.append('<option selected disabled>Select City</option>');

	$.get("CityServlet?stateId=" + newStateIndex, function(cities) {
		cities.forEach(function(city) {
			cityDropdown.append('<option value="' + city.id + '">' + city.name + '</option>')
		});

		$("select#city_" + newCityIndex).val(selectedVal);
	});
}