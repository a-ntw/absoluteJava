
/* 220716 Absolute Java  Chapter7 Programming Projects. Proj0705 */
/**
 * Give the definition of a class named {@code Doctor} whose objects are records
 * for a clinic’s doctors. This class will be a derived class of the class
 * {@code SalariedEmployee} given in Display 7.5. A Doctor record has the
 * doctor’s specialty (such as "Pediatrician", "Obstetrician","General
 * Practitioner", and so forth; so use the type {@code String}) and office visit
 * fee (use type {@code double}). Be sure your class has a reasonable complement
 * of constructors, accessor, and mutator methods, and suitably defined
 * {@code equals} and {@code toString} methods. Write a program to test all your
 * methods.
 */
public class Doctor extends SalariedEmployee {

    private String specialty; //"Pediatrician", "Obstetrician","General Practitioner"
    private double visitFee;

    public Doctor() {
    }

    public Doctor(String theName, Date theDate, double theSalary,
            String specialty, double visitFee) {
        super(theName, theDate, theSalary);
        this.specialty = specialty;
        this.visitFee = visitFee;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setVisitFee(double visitFee) {
        this.visitFee = visitFee;
    }

    public String getSpecialty() {
        return specialty;
    }

    public double getVisitFee() {
        return visitFee;
    }

    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        } else if (getClass() != otherObj.getClass()) {
            return false;
        } else {
            Doctor d = (Doctor) otherObj;
            return super.equals(d)
                    && this.specialty == d.getSpecialty()
                    && this.visitFee == d.getVisitFee();
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpecialty: " + getSpecialty()
                + "; Office visit fee: $" + getVisitFee();
    }

    public static void main(String[] args) {
        Doctor samuel, sam;
        samuel = new Doctor("Samuel", new Date("February", 1, 2015), 5000,
                "Obstetrician", 300);
        sam = new Doctor();
        sam.setName("Samuel");
        sam.setHireDate(new Date("February", 1, 2015));
        sam.setSalary(5000);
        sam.setSpecialty("Obstetrician");
        sam.setVisitFee(300);

        if (sam.equals(samuel)) {
            System.out.println("sam is equal to samuel");
        }

        sam.setVisitFee(250);
        System.out.println(sam + "\n");

        Doctor.showEmployee(samuel);
    }
}

/* Sample dialogue
run:
sam is equal to samuel
Samuel February 1, 2015
$5000.0 per year
Specialty: Obstetrician; Office visit fee: $250.0

Samuel
February 1, 2015
BUILD SUCCESSFUL (total time: 0 seconds)
 */
