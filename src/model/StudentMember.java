package model;

public class StudentMember extends Member {

	private String studentId;
	private String collegeName;

	public StudentMember(String email, String address, String gender, String name, double startingWeight, double height,
			String chosenPackage, String studentId, String collegeName) {
		super(email, address, gender, name, startingWeight, height, chosenPackage);
		this.studentId = studentId;
		this.collegeName = collegeName;

	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public void chosenPackage(String packageChoice) {
		switch (collegeName) {
		default:
			this.chosenPackage = "Package_3";
			break;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentMember [studentId=").append(studentId).append(", collegeName=").append(collegeName)
				.append(", getStudentId()=").append(getStudentId()).append(", getCollegeName()=")
				.append(getCollegeName()).append("]");
		return builder.toString();
	}

}
