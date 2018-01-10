package model;

public class Trainer extends Person {

	public Trainer(String email, String address, String gender, String name) {
		super(email, address, gender, name);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trainer []");
		return builder.toString();
	}

}
