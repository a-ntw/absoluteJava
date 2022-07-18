
/* 220717 Absolute Java  Chapter7 Programming Projects. Proj0707 */
/**
 * Give the definition of two classes, {@code Patient} and {@code Billing},
 * whose objects are records for a clinic. {@code Patient} will be derived from
 * the class {@code Person} given in Programming Project 7.6. A {@code Patient}
 * record has the patient’s name (inherited from the class {@code Person}) and
 * primary physician of type {@code Doctor} defined in Programming Project 7.5.
 * A {@code Billing} object will contain a {@code Patient} object, a {@code
 * Doctor} object, and an {@code amount} due of type {@code double}. Be sure
 * your classes have a reasonable complement of constructors, accessor and
 * mutator methods, and suitably defined {@code equals} and {@code toString}
 * methods. First write a driver program to test all your methods, then write a
 * test program that creates at least two patients, at least two doctors, and at
 * least two {@code Billing} records, and then prints out the total income from
 * the {@code Billing} records.
 *
 * @see Person.java
 * @see Doctor.java
 * @see Billing.java
 */
public class Patient extends Person {

    private Doctor physician;

    public Patient() {
    }

    public Patient(String firstName, String lastName) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }

    public Patient(String firstName, String lastName, Doctor physician) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.physician = physician;
    }

    public void setPhysician(Doctor physician) {
        this.physician = physician;
    }

    public void setPhysician(String name, Date newDate, double salary,
            String specialty, double visitFee) {
        physician.setName(name);
        physician.setHireDate(newDate);
        physician.setSalary(salary);
        physician.setSpecialty(specialty);
        physician.setVisitFee(visitFee);
    }

    public Doctor getPhysician() {
        return physician;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (getClass() != other.getClass()) {
            return false;
        } else {
            Patient otherObj = (Patient) other;
            return super.equals(otherObj)
                    && physician.equals(otherObj.physician); // ****
        }
    }

    public String toString() {
        return super.toString() + "; Physician: " + physician;
    }

    public static void methodsTesting() {
        System.out.print("Patient methods testing: ");

        Doctor sam, samuel;
        samuel = new Doctor("Samuel", new Date("February", 1, 2015), 5000,
                "Obstetrician", 300);
        sam = new Doctor("Samuel", new Date("February", 1, 2015), 5000,
                "Obstetrician", 300);

        Patient anne = new Patient();
        anne.setFirstName("Anne");
        anne.setLastName("Tan");
        anne.setPhysician(samuel);

        Patient annie = new Patient("Anne", "Tan", sam);

        if (annie.equals(anne)) {
            System.out.printf("ok . ");
        } else {
            System.out.println("Error on method `equals`, 'set'");
        }

        //System.out.println("Physician: " + anne.getPhysician().getName());
        if (anne.getPhysician().getName() == "Samuel") {
            System.out.printf("ok .. ");
        } else {
            System.out.println("Error on method `getPhysician()`");
        }

        //System.out.println(". . . . .\n" + annie);
        String test = "Anne Tan; Physician: Samuel February 1, 2015\n"
                + "$5000.0 per year\n"
                + "Specialty: Obstetrician; Office visit fee: $300.0";
        if (annie.toString().equals(test)) {
            System.out.println("ok ... ");
        } else {
            System.out.println("Error on method `toString`");
        }

    }

    public static void main(String[] args) {

        Patient.methodsTesting();
        Billing.methodsTesting();

        Doctor samuel, nick;
        samuel = new Doctor("Samuel", new Date("February", 1, 2015), 5000,
                "Obstetrician", 300);
        nick = new Doctor("Nick", new Date("July", 10, 2022), 7000,
                "General Practitioner", 500);

        Patient annie = new Patient("Anne", "Tan"),
                mary = new Patient("Mary", "May");

        Billing billM = new Billing(mary, samuel, 250);
        Billing billA = new Billing(annie, nick, 330);

        System.out.printf("Patient %s attended by Dr. %-10s  $%1.2f %n",
                billM.getPatient().getFirstName(),
                billM.getDoctor().getName(), billM.getAmount());
        System.out.printf("Patient %s attended by Dr. %-10s  $%1.2f %n",
                billA.getPatient().getFirstName(),
                billA.getDoctor().getName(), billA.getAmount());
        System.out.printf("Total income from the records %10s $%1.2f %n", "",
                (billM.getAmount() + billA.getAmount()));
    }
}

/* Sample dialogue
run:
Patient methods testing: ok . ok .. ok ... 
Billing methods testing: ok . ok .. ok ...
Patient Mary attended by Dr. Samuel      $250.00 
Patient Anne attended by Dr. Nick        $330.00 
Total income from the records            $580.00 
BUILD SUCCESSFUL (total time: 0 seconds)
 */
