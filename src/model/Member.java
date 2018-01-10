package model;

import java.util.*;

public abstract class Member extends Person {
	private static final String VERY_SEVERELY_UNDERWEIGHT = "VERY SEVERELY UNDERWEIGHT";
	private static final String SEVERELY_UNDERWEIGHT = "SEVERELY UNDERWEIGHT";
	private static final String UNDERWEIGHT = "UNDERWEIGHT";
	private static final String NORMAL = "NORMAL";
	private static final String OVERWEIGHT = "OVERWEIGHT";
	private static final String MODERATELY_OBESE = "MODERATELY OBESE";
	private static final String SEVERELY_OBESE = "SEVERELY OBESE";
	private static final String VERY_SEVERELY_OBESE = "VERY SEVERELY OBESE";

	private double startingWeight;
	private double height;
	private double bmi;
	private Map<Date, Assessment> assessRoutine;
	private String gender;

	protected String chosenPackage;

	/**
	 * 
	 * @param email
	 * @param address
	 * @param gender
	 * @param name
	 * @param startingWeight
	 * @param height
	 * @param chosenPackage
	 */
	public Member(String email, String address, String gender, String name, double startingWeight, double height,
			String chosenPackage) {
		super(email, address, gender, name);
		this.startingWeight = isValidStartingWeight(startingWeight) ? startingWeight : 250; // Perfect
		this.height = isValidHeight(height) ? height : 3; // Perfect
		this.gender = new String(gender);
		this.assessRoutine = new HashMap<Date, Assessment>();
		this.chosenPackage(chosenPackage);
	}

	/**
	 * 
	 * @param date
	 * @param details
	 * @return
	 */

	public Map<Date, Assessment> getAssessRoutine() {
		return assessRoutine;
	}

	public void addAssessRoutine(Date date, Assessment assessment) {
		assessRoutine.put(date, assessment);
	}

	public double getStartingWeight() {
		return startingWeight;
	}

	/**
	 * 
	 * @param startingWeight
	 * @return
	 */
	private boolean isValidStartingWeight(double startingWeight) {
		return startingWeight >= 35 && startingWeight <= 250;
	}

	/**
	 * 
	 * @param startingWeight
	 */
	public void setStartingWeight(double startingWeight) {
		if (isValidStartingWeight(startingWeight)) {
			this.startingWeight = startingWeight;
		}
	}

	public double convertMetersToInch(double val) {
		return val / 0.0254;
	}

	public boolean isIdealBodyWeight(double weight) {
		double fiveFeet = 60.0;
		double idealBodyWeight;
		double inches = convertMetersToInch(height);

		if (inches <= fiveFeet) {
			if (this.gender.equals("M")) {
				idealBodyWeight = 50;
			} else {
				idealBodyWeight = 45.5;
			}
		} else {
			if (this.gender.equals("M")) {
				idealBodyWeight = 50 + ((inches - fiveFeet) * 2.3);
			} else {
				idealBodyWeight = 45.5 + ((inches - fiveFeet) * 2.3);
			}
		}

		return ((idealBodyWeight <= (weight + 2.0)) && (idealBodyWeight >= (weight - 2.0)));
	}

	/**
	 * 
	 * @return
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * 
	 * @param height
	 * @return
	 */
	private boolean isValidHeight(double height) {
		return height >= 1 && height <= 3;
	}

	/**
	 * 
	 * @param height
	 */
	public void setHeight(double height) {
		if (isValidHeight(height)) {
			this.height = height;
		}
	}

	/**
	 * 
	 * @param weight
	 * @return
	 */
	public double calculateBMI(double weight) {
		return bmi = (weight / (height * height));
	}

	/**
	 * 
	 * @param bmiValue
	 * @return
	 */
	public String determineBMICategory(double bmiValue) {
		if (bmi < 15) {
			return VERY_SEVERELY_UNDERWEIGHT;
		} else if (bmi >= 15 && bmi < 16) {
			return SEVERELY_UNDERWEIGHT;
		} else if (bmi >= 16 && bmi < 18.5) {
			return UNDERWEIGHT;
		} else if (bmi >= 18.5 && bmi < 25) {
			return NORMAL;
		} else if (bmi >= 25 && bmi < 30) {
			return OVERWEIGHT;
		} else if (bmi >= 30 && bmi < 35) {
			return MODERATELY_OBESE;
		} else if (bmi >= 35 && bmi < 40) {
			return SEVERELY_OBESE;
		} else {
			return VERY_SEVERELY_OBESE;
		}

	}

	public Assessment latestAssessment() { // Returns the latest assessment
											// based
											// on last entry (by calendar date).
		return getAssessRoutine().get(sortedAssesmentDates().last());
	}

	public SortedSet<Date> sortedAssesmentDates() { // Returns the assessment
													// dates sorted in date
													// order.
		return new TreeSet<Date>(getAssessRoutine().keySet());
	}

	public String getChosenPackage() {
		return chosenPackage;
	}

	public void chosenPackage(String chosenPackage) {
		this.chosenPackage = chosenPackage;
	}

	@Override
	public String toString() {
		return "Member startingWeight=" + startingWeight + ", \nheight=" + height + ", \nbmi=" + bmi
				+ ", \nassessRoutine=" + assessRoutine + ", \nchosenPackage=" + chosenPackage
				+ ", \ngetAssessRoutine()=" + getAssessRoutine() + ", \ngetStartingWeight()=" + getStartingWeight()
				+ ", \ngetHeight()=" + getHeight() + ", \nlatestAssesment()=" + latestAssessment()
				+ ", \nsortedAssesmentDates()=" + sortedAssesmentDates() + ", \ngetChosenPackage()="
				+ getChosenPackage() + "]";
	}

}
