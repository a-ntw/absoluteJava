
/* 220717 Absolute Java  Chapter7 Programming Projects. Proj0707 */
/**
 * @see Person.java
 * @see Patient.java
 * @see Doctor.java
 */
public class Billing {

    private Patient patient;
    private Doctor doctor;
    private double amount;

    public Billing() {
    }

    public Billing(Patient patient, Doctor doctor, double amount) {
        this.patient = patient;
        this.doctor = doctor;
        this.amount = amount;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor d) {
        this.doctor = d;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (getClass() != other.getClass()) {
            return false;
        } else {
            Billing billObj = (Billing) other;
            return patient.equals(billObj.patient)
                    && doctor.equals(billObj.doctor)
                    && amount == billObj.amount;
        }
    }

    public String toString() {
        return "Patient: " + patient.getFirstName() + " " + patient.getLastName()
                + "\nDoctor: " + doctor.getName() + "\nAmount: " + amount;
    }

    public static void methodsTesting() {
        System.out.print("Billing methods testing: ");

        Doctor samuel, nick;
        samuel = new Doctor("Samuel", new Date("February", 1, 2015), 5000,
                "Obstetrician", 300);
        nick = new Doctor("Nick", new Date("July", 10, 2022), 7000,
                "General Practitioner", 500);

        Patient annie = new Patient("Anne", "Tan", nick),
                mary = new Patient("Mary", "May", samuel);

        Billing billM = new Billing(mary, samuel, 250);
        Billing billA = new Billing();// annie, 200);
        billA.setPatient(mary);
        billA.setDoctor(samuel);
        billA.setAmount(250);

        if (billA.equals(billM)) {
            System.out.printf("ok . ");
        } else {
            System.out.println("Error on method `equals`, 'set'");
        }

        //System.out.println("Patient: " + billM.getPatient().getFirstName()
        //        + "; Physician: " + billM.getDoctor().getName());   
        if ((billM.getPatient().getFirstName() != "Mary")
                || (billM.getDoctor().getName() != "Samuel")
                || (billM.getAmount() != 250)) {
            System.out.println("Error on method `get`.");
        } else {
            System.out.printf("ok .. ");
        }

        //System.out.println(". . . . .\n" + billA);
        String test = "Patient: Mary May\n"
                + "Doctor: Samuel\n"
                + "Amount: 250.0";
        if (billA.toString().equals(test)) {
            System.out.println("ok ...");
        } else {
            System.out.println("Error on method `toString`");
        }
    }
}
