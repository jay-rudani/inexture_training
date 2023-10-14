package dto;

import java.util.Date;
import java.util.List;

import utility.Address;

public class User {

	private int id;
	private String user_uuid;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String userName;
	private String email;
	private String knownLanguages;
	private String gender;
	private byte[] profile_pic;
	private String userRole;
	private List<Address> addresses;

	public User() {
		super();
	}

	public User(int id, String user_uuid, String firstName, String lastName, Date birthDate, String userName,
			String email, String knownLanguages, String gender, byte[] profile_pic, String userRole) {
		this.id = id;
		this.user_uuid = user_uuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.userName = userName;
		this.email = email;
		this.knownLanguages = knownLanguages;
		this.gender = gender;
		this.profile_pic = profile_pic;
		this.userRole = userRole;
	}

	public User(int id, String user_uuid, String firstName, String lastName, Date birthDate, String userName,
			String email, String knownLanguages, String gender, byte[] profile_pic, String userRole,
			List<Address> addresses) {
		super();
		this.id = id;
		this.user_uuid = user_uuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.userName = userName;
		this.email = email;
		this.knownLanguages = knownLanguages;
		this.gender = gender;
		this.profile_pic = profile_pic;
		this.userRole = userRole;
		this.addresses = addresses;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setKnownLanguages(String knownLanguages) {
		this.knownLanguages = knownLanguages;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setProfile_pic(byte[] profile_pic) {
		this.profile_pic = profile_pic;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getUserRole() {
		return userRole;
	}

	public String getUser_uuid() {
		return user_uuid;
	}

	public byte[] getProfile_pic() {
		return profile_pic;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getKnownLanguages() {
		return knownLanguages;
	}

	public String getGender() {
		return gender;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

}
