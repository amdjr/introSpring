package br.admjr.com.model;

public class Person {
	private String name;
	private String lastName;
	private String birthDay;
	private String email;

	public Person(String name, String lastName, String birthDay, String email) {
		this.name = name;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
