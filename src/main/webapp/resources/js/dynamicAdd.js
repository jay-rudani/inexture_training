$(document).ready(function () {
  // Function to populate states based on the selected country
  function populateStates($countryDropdown, $stateDropdown) {
    const selectedCountry = $countryDropdown.val();
    const statesByCountry = {
      USA: ["New York", "California", "Texas"],
      Canada: ["Ontario", "Quebec", "British Columbia"],
      // Add more states for other countries as needed
    };

    // Clear existing options
    $stateDropdown.empty();

    // Populate states based on the selected country
    statesByCountry[selectedCountry].forEach((state) => {
      $stateDropdown.append(`<option>${state}</option>`);
    });
  }

  // Function to populate cities based on the selected state
  function populateCities($stateDropdown, $cityDropdown) {
    const selectedState = $stateDropdown.val();
    const citiesByState = {
      "New York": ["New York City", "Buffalo", "Albany"],
      California: ["Los Angeles", "San Francisco", "San Diego"],
      Texas: ["Houston", "Dallas", "Austin"],
      Ontario: ["Toronto", "Ottawa", "Mississauga"],
      Quebec: ["Montreal", "Quebec City", "Laval"],
      "British Columbia": ["Vancouver", "Victoria", "Burnaby"],
      // Add more cities for other states as needed
    };

    // Clear existing options
    $cityDropdown.empty();

    // Populate cities based on the selected state
    citiesByState[selectedState].forEach((city) => {
      $cityDropdown.append(`<option>${city}</option>`);
    });
  }

  // Add initial address div
  const $addressContainer = $("#address-container");
  const $initialAddressDiv = $addressContainer.find(".address");
  const $countryDropdown = $initialAddressDiv.find(".country-dropdown");
  const $stateDropdown = $initialAddressDiv.find(".state-dropdown");
  const $cityDropdown = $initialAddressDiv.find(".city-dropdown");
  populateStates($countryDropdown, $stateDropdown);
  populateCities($stateDropdown, $cityDropdown);

  // Handle adding new address divs
  $("#add-address").click(function () {
    const $newAddressDiv = $initialAddressDiv.clone(); // Clone the address container div
    $newAddressDiv.find("select").val(""); // Clear selected values if needed
    const $newCountryDropdown = $newAddressDiv.find(".country-dropdown");
    const $newStateDropdown = $newAddressDiv.find(".state-dropdown");
    const $newCityDropdown = $newAddressDiv.find(".city-dropdown");
    $newCountryDropdown.on("change", function () {
      populateStates($newCountryDropdown, $newStateDropdown);
      populateCities($newStateDropdown, $newCityDropdown);
    });
    $newStateDropdown.on("change", function () {
      populateCities($newStateDropdown, $newCityDropdown);
    });
    $addressContainer.append($newAddressDiv); // Add the new div to the end of the container
  });
});
