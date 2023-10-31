function validateEmail() {
  let email = document.getElementById("email").value;
  let emailMessage = document.getElementById("emailMessage");

  const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

  if (!email.match(emailRegex)) {
    emailMessage.innerHTML = "Invalid Email ID!";
    emailMessage.style.color = "red";
    return false;
  }

  return true;
}

function validateUsername() {
  let userName = document.getElementById("username").value;
  let usernameMessage = document.getElementById("userNameMessage");

  const userNameRegex = /^[a-z0-9_]{3,20}$/;

  if (!userName.match(userNameRegex)) {
    usernameMessage.innerHTML =
      "Username should only contain lowercase(a-z), numbers(0-9) and underscore(_)!";
    usernameMessage.style.color = "red";
    return false;
  }

  return true;
}

function validateFirstName() {
  let firstName = document.getElementById("firstname").value;
  let firstNameMessage = document.getElementById("firstNameMessage");

  let firstNameRegex = /^[A-Z][a-z]*$/;

  if (!firstName.match(firstNameRegex)) {
    firstNameMessage.innerHTML =
      "First name should start with an Uppercase letter!";
    firstNameMessage.style.color = "red";
    return false;
  } else {
    firstNameMessage.innerHTML = "";
    return true;
  }
}

function validateLastName() {
  let lastName = document.getElementById("lastname").value;
  let lastNameMessage = document.getElementById("lastNameMessage");

  let lastNameRegex = /^[A-Z][a-z]*$/;

  if (!lastName.match(lastNameRegex)) {
    lastNameMessage.innerHTML =
      "Last name should start with an Uppercase letter!";
    lastNameMessage.style.color = "red";
    return false;
  }

  return true;
}

function validateBirthDate() {
  let birthDateData = document.getElementById("birthdate").value;
  let birthDateMessage = document.getElementById("birthDateMessage");

  const birthDate = new Date(birthDateData);
  const currentDate = new Date();

  if (birthDate > currentDate) {
    birthDateMessage.innerHTML = "Birthdate can't be in future!";
    birthDateMessage.style.color = "red";
    return false;
  }

  return true;
}

function validatePassword() {
  let password = document.getElementById("password").value;
  let passwordMessage = document.getElementById("passwordMessage");

  const upperCaseRegex = /[A-Z]/;
  const lowerCaseRegex = /[a-z]/;
  const specialSymbolRegex = /[!@#$%]/;
  const numberRegex = /\d/;

  if (!(password.length >= 8)) {
    passwordMessage.innerHTML = "Password at least 8 characters long!";
    passwordMessage.style.color = "red";
    return false;
  } else if (!upperCaseRegex.test(password)) {
    passwordMessage.innerHTML =
      "Password should contain at least 1 uppercase letter!";
    passwordMessage.style.color = "red";
    return false;
  } else if (!lowerCaseRegex.test(password)) {
    passwordMessage.innerHTML =
      "Password should contain at least 1 lowercase letter!";
    passwordMessage.style.color = "red";
    return false;
  } else if (!specialSymbolRegex.test(password)) {
    passwordMessage.innerHTML =
      "Password should contain at least 1 of (!@#$%) symbol!";
    passwordMessage.style.color = "red";
    return false;
  } else if (!numberRegex.test(password)) {
    passwordMessage.innerHTML =
      "Password should contain at least 1 number (0-9)";
    passwordMessage.style.color = "red";
    return false;
  }

  return true;
}

function validateFields() {
  // if (!validateFirstName()) {
  //   return false;
  // }
  // if (!validateLastName()) {
  //   return false;
  // }
  // if (!validateEmail()) {
  //   return false;
  // }
  if (!validateUsername()) {
    return false;
  }
  // if (!validatePassword()) {
  //   return false;
  // }
  // if (!validateBirthDate()) {
  //   return false;
  // }

  return true;
}
