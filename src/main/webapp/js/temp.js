$(function() {

	console.log(userForm.find("#user_id"));
	userForm.find("#user_id").val(user.id);
	userForm.find("#user_uuid").val(user.user_uuid);
	userForm.find("#profile_pic").val(user.profile_pic_string);
	userForm.find("#firstname").val(user.firstName);
	userForm.find("#lastname").val(user.lastName);
	userForm.find("#email").val(user.email);
	userForm.find("#username").val(user.userName);
	// Parse the date string into a Date object
	var inputDate = new Date(user.birthDate);
	// Format the Date object into "yyyy-MM-dd" format
	var formattedDate = inputDate.getFullYear() + '-' +
		('0' + (inputDate.getMonth() + 1)).slice(-2) + '-' +
		('0' + inputDate.getDate()).slice(-2);
	userForm.find("#birthdate").val(formattedDate);
	if (user.gender == userForm.find("#male").val()) {
		userForm.find("#male").prop("checked", true);
	} else {
		userForm.find("#female").prop("checked", true);
	}
	if (user.knownLanguages.includes(userForm.find("#english").val())) {
		userForm.find("#english").prop("checked", true);
	} else {
		userForm.find("#english").prop("checked", false)
	}
	if (user.knownLanguages.includes(userForm.find("#hindi").val())) {
		userForm.find("#hindi").prop("checked", true);
	} else {
		userForm.find("#hindi").prop("checked", false);
	}
	if (user.knownLanguages.includes(userForm.find("#gujarati").val())) {
		userForm.find("#gujarati").prop("checked", true);
	} else {
		userForm.find("#gujarati").prop("checked", false);
	}
})