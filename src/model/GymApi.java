package model;

import java.util.*;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class GymApi {
	private ArrayList<Member> members = new ArrayList<>();

	private ArrayList<Trainer> trainers = new ArrayList<>();

	public void addMember(Member member) {
		members.add(member);
	}

	public void addTrainer(Trainer trainer) {
		trainers.add(trainer);
	}

	public int numberOfMembers() {
		return members.size();
	}

	public int numberOfTrainers() {
		return trainers.size();
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	public ArrayList<Trainer> getTrainers() {
		return trainers;
	}

	public boolean isValidMemberIndex(int index) {

		return index >= 0 && index < members.size();

		// Returns a boolean indicating if the index passed as a parameter is a
		// valid index for the
		// member�s array list.
	}

	public boolean isValidTrainerIndex(int index) {

		return index >= 0 && index < trainers.size();

		// Returns a boolean indicating if the index passed as a parameter is a
		// valid index for the
		// trainer�s array list.
	}

	public Member searchMembersByEmail(String emailEntered) {

		return members.stream().filter(Member -> Member.getEmail().equalsIgnoreCase(emailEntered)).findFirst()
				.orElse(null);
	}

	// Returns the member object that matches the email entered.

	public Person searchTrainersByEmail(String emailEntered) {

		return trainers.stream().filter(Trainer -> Trainer.getEmail().equalsIgnoreCase(emailEntered)).findFirst()
				.orElse(null);
	}

	// Returns the trainer object that matches the email entered.

	public String listMembers() {
		if (members.size() == 0) {
			return "No Members.";
		} else {
			String listMembers = "";
			for (int i = 0; i < members.size(); i++) {
				listMembers = listMembers + (i + ":" + members.get(i)) + "\n";
			}
			return listMembers;
		}

		// Returns a string containing all the members details in the gym
	}

	private boolean isIdealWeight(double weight, double height, String gender) { // perfect

		if (gender.equals(Person.FEMALE)) { // Now what? | wow Now you have to
											// compare against the 'weight'
											// parameter to determine if the
											// weight is ideal.
			return 45.5 + 2.3 * (height - 1.524) <= weight;// ? no
		} else
			return 50 + 2.3 * (height - 1.524) <= weight;
	}

	public BaseStream<Member, Stream<Member>> listMembersWithIdealWeight(String isIdealWeight) {

		return members.stream().filter((Member member) -> {
			return isIdealWeight(member.latestAssessment().getWeight(), member.getHeight(), member.getGender());
		});

		// Returns a string containing all the members details in the gym whose
		// latest assessment
		// weight is an ideal weight (based on the devine method).
	}

	public String listMembersBySpecificBMICategory(double bmiValue) {
		members.stream().filter(member -> member.determineBMICategory(member.calculateBMI(member.latestAssessment().getWeight())).equals(bmiValue));
	     Stream<Member> stream = stream.get().anyMatch(member -> true); 
	      return compile;
//		int ctr = 0;
//				if (members.size() == 0)
//			return "no members in the gym!";
//		for (Member member : members) {
//			bmiValue = member.latestAssessment().getWeight() / (member.getHeight() * member.getHeight());
//			String cat = member.determineBMICategory(bmiValue); // none static
//																// approach
//			if ( == cat) {
//				member.toString();
//				ctr++;
//			}
//
//		}		if (ctr != 0)
//			return ctr + " members displayed in this category!"; // no code has																	// no return/																	// value
//																	// warning
//		else
//			return "no member in the matching category found!";
	
	// Returns a string containing all the members details in the gym whose
	// BMI category(based
	// on the latest assessment weight) partially or entirely matches the
	// entered category
	// If there are no members in the gym, return a message indicating this.
}

	private /* static */ List<String> listMemberDetailsImperialAndMetric() {
		List<String> outputList = new ArrayList<String>();
		for (Member member : members) {
			outputList.add(String.format("%s: %2d kg (%3d lbs) %.1f metres (%2d inches).\n", member.getName(),
					(int) member.latestAssessment().getWeight(),
					(int) member.latestAssessment().getWeight()
							* 2.20462/* weight in lbs */,
					(float) member.getHeight(),
					(int) member.getHeight() / 0.0254/* height in inches */ ));
		}
		return outputList;

		// return null; // implementation above
		// height both imperially and
		// metrically. The format of the output is like so:
		// Joe Soap: xx kg (xxx lbs) x.x metres (xx inches).
	}

	public /* static */ void printListMemberDetailsImperialAndMetric() {
		List<String> strings = listMemberDetailsImperialAndMetric();
		for (String str : strings)
			System.out.println(str);
	}

	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		XStream xstream = new XStream(new DomDriver());
		ObjectInputStream is = ((com.thoughtworks.xstream.XStream) xstream)
				.createObjectInputStream(new FileReader("members-trainers.xml"));
		members = (ArrayList<Member>) is.readObject();
		trainers = (ArrayList<Trainer>) is.readObject();
		is.close();
	}
	// Read the associated XML file and pop the members and trainers into
	// their associated array
	// lists.

	public void save() throws Exception {

		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("members-trainers.xml"));
		out.writeObject(members);
		out.writeObject(trainers);
		out.close();
	}
	// Push the members and trainers array lists out to the associated XML
	// file.

}
