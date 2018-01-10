package model;

public class PremiumMember extends Member {

	public PremiumMember(String email, String address, String gender, String name, double startingWeight, double height,
			String chosenPackage, String hashMap) {
		super(email, address, gender, name, startingWeight, height, chosenPackage);

	}

	public void chosenPackage(String packageChoice) {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PremiumMember [chosenPackage=").append(chosenPackage).append("]");
		return builder.toString();
	}

}
