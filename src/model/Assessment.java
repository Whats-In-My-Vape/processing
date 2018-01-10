package model;

public class
Assessment {

    private double weight;
    private double chest;
    private double thigh;
    private double upperArm;
    private double waist;
    private double hips;
    private String comment;

    /**
     * @param weight
     * @param chest
     * @param thigh
     * @param upperArm
     * @param waist
     * @param hips
     * @param comment
     */
    public Assessment(double weight, double chest, double thigh, double upperArm, double waist, double hips,
                      String comment) {
        this.weight = isValidWeight(weight) ? weight : 250;
        this.chest = chest;
        this.thigh = thigh;
        this.upperArm = upperArm;
        this.waist = isValidHipsAndWaist(waist, hips) ? waist : 1;
        this.hips = isValidHipsAndWaist(waist, hips) ? hips : 1;
        this.comment(comment);
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getThigh() {
        return thigh;
    }

    public void setThigh(double thigh) {
        this.thigh = thigh;
    }

    public double getUpperArm() {
        return upperArm;
    }

    public void setUpperArm(double upperArm) {
        this.upperArm = upperArm;
    }

    public double getWeight() {
        return weight;
    }

    private boolean isValidWeight(double weight) {
        return weight >= 35 && weight <= 250;
    }

    public void setWeight(double weight) {
        if (isValidWeight(weight))
            this.weight = weight;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        if (isValidHipsAndWaist(waist, hips)) { // Perfect
            this.waist = waist;
        }
    }

    public double getHips() {
        return hips;
    }

    private boolean isValidHipsAndWaist(double waist, double hips) {
        return hips >= waist;
    }

    public void setHips(double hips) {
        if (isValidHipsAndWaist(waist, hips)) { // Perfect!
            this.hips = hips;
        }
    }

    public String getComment() {
        return comment;
    }

    public void comment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Assessment weight=" + weight +
                ", chest=" + chest +
                ", \nthigh=" + thigh +
                ", \nupperArm=" + upperArm +
                ", \nwaist=" + waist +
                ", \nhips=" + hips +
                ", \ncomment=" + comment +
                ", \ngetChest()=" + getChest() +
                ", \ngetThigh()=" + getThigh() +
                ", \ngetUpperArm()=" + getUpperArm() +
                ", \ngetWeight()=" + getWeight() +
                ", \ngetWaist()=" + getWaist() +
                ", \ngetHips()=" + getHips() +
                ", \ngetComment()=" + getComment();
    }


}
