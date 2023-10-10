$(document).ready(function() {
	$("input").prop("disabled", true);
	$("select").prop("disabled", true);
	$(".btn-danger").addClass("d-none");
	
	$(".btn-primary").click(function() {
		$("input").prop("disabled", false);
		$("select").prop("disabled", false);
		$(".btn-danger").removeClass("d-none");
	});
	$(".btn-success").click(function() {
		$("input").prop("disabled", true);
		$("select").prop("disabled", true);
		$(".btn-danger").addClass("d-none");
	});
});