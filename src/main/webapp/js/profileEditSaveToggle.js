$(document).ready(function() {
	$("input").prop("disabled", true);
	$(".btn-primary").click(function() {
		$("input").prop("disabled", false);
	});
	$(".btn-success").click(function() {
		$("input").prop("disabled", true);
	});
});