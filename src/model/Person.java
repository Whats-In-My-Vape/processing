package model;

public abstract class Person {

	public static final String MALE = "M";
	public static final String FEMALE = "F";
	public static final String UNSPECIFIED = "Unspecified";

	private String email;
	private String address;
	private String gender;
	private String name; // limit 30 char *done

	/**
	 * 
	 * @param email
	 * @param address
	 * @param gender
	 * @param name
	 */
	public Person(String email, String address, String gender, String name) {
		this.email = email;
		this.address = address;
		this.gender = sanitizeGender(gender);
		this.name = sanitizeName(name);
	}

	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 
	 * @param gender
	 * @return
	 */
	private String sanitizeGender(String gender) {

		if (gender == MALE) {
			return MALE;
		} else if (gender == FEMALE) {
			return FEMALE;
		} else {
			return UNSPECIFIED;
		}
	}

	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = sanitizeGender(gender);
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	private String sanitizeName(String name) {

		if (name.length() > 30) {
			return name.substring(0, 30);
		} else {
			return name;
		}
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = sanitizeName(name);
	}

	public String toString() {
		return "email =" + email + 
			   ",\naddress =" + address + 
			   ", \ngender =" + gender + 
			   ", \nname =" + name;		 
		}
	
}
