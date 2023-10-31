$(function(){

    var fromDropdown = $("#convertedFrom");
    var toDropdown = $("#convertedTo");
    var app_id = "4727824e7fbe4acc89d481bd661c08d1";

    $.get("https://openexchangerates.org/api/latest.json?app_id="+app_id+"",
    function(data){

        $.get('https://openexchangerates.org/api/currencies.json', function(fullNames) {

            var exchangeRates = data.rates;
            for(var exchangeRate in exchangeRates){
                var rate = exchangeRates[exchangeRate];
                var name = fullNames[exchangeRate];
                fromDropdown.append($("<option></option>").attr("value", rate).text(name));
                toDropdown.append($("<option></option>").attr("value", rate).text(name));
            }

        });

    });

});
