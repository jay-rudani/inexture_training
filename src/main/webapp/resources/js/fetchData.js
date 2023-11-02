$(function(){

    var fromDropdown = $("#convertFrom");
    var toDropdown = $("#convertTo");
    var apiKey = "1d18149ae8a2140ef318dbc2";

    $.get('https://v6.exchangerate-api.com/v6/'+apiKey+'/codes', function(fullNames) {

        for(var i = 0; i < fullNames["supported_codes"].length; i++){
             fromDropdown.append($("<option></option>").attr("value", fullNames["supported_codes"][i][0]).text(fullNames["supported_codes"][i][1] + " (" + fullNames["supported_codes"][i][0] + ")"));
             toDropdown.append($("<option></option>").attr("value", fullNames["supported_codes"][i][0]).text(fullNames["supported_codes"][i][1] + " (" + fullNames["supported_codes"][i][0] + ")"));
        }
    });
});
