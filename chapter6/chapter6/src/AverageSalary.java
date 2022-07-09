
/* 220624 Absolute Java  Chapter6 Programming Projects. Proj0603 */
import java.util.Scanner;

/**
 * Write a program to calculate the average salary of an employee in a company.
 * The program should read the monthly salary and overtime hours of an employee
 * for each of the previous 12 months. The program should then print out a
 * nicely formatted table showing the salary for each of the previous 12 months
 * including salary for overtime hours. It should also show how much above or
 * below average the total salary was for each month. The output should
 * correctly label the months. There are a variety of ways to deal with the
 * month names. One straightforward method is to code the months as integers and
 * then do a conversion to a string for the month name before doing the output.
 * The month input can be handled in any manner you wish so long as it is
 * relatively easy and pleasant for the user. The salary for the overtime hours
 * is calculated as per the following rates:
 *
 * a. If salary is above $10,000, then the rate per overtime hour is $25.
 *
 * b. If salary is greater than $5,000 and below $10,000, then the rate per
 * overtime hour is $20.
 *
 * c. If salary is greater than $2,000 and below $5,000, then the rate per
 * overtime hour is $15.
 *
 * If salary is below $2,000, then the rate per overtime hour is $10.
 */
public class AverageSalary {

    private final static int ANNUAL = 12;
    private int[] salary; // $
    private int[] otHours; // hrs
    private int[] otPay; // $
    private int[] grossSalary; // $
    private int averageSalary; // $

    public AverageSalary(int[] salary, int[] otHours) {
        this.salary = salary;
        this.otHours = otHours;
        tabulateOvertimePay();
        totalMonthlySalary();
        calculateAverageSalary();
    }

    /**
     * To fill in the 12 salaries, thereafter will print out the average.
     */
    public AverageSalary() {
        fillSalAndOT();
        tabulateOvertimePay();
        totalMonthlySalary();
        calculateAverageSalary();
    }

    public void setSalary(int[] salary) {
        this.salary = salary;
    }

    public void setOtHours(int[] otHours) {
        this.otHours = otHours;
    }

    private void fillSalAndOT() {
        salary = new int[ANNUAL];
        otHours = new int[ANNUAL];
        Scanner keyboard = new Scanner(System.in);
        System.out.println("To tabulate the average for the previous 12 months.");
        System.out.println("Fill Salary <space> OverTime hours for the month.");
        String m;
        for (int i = 0; i < ANNUAL; i++) {
            m = monthString(i + 1);
            System.out.printf("%-9s : ", m);
            salary[i] = keyboard.nextInt();
            otHours[i] = keyboard.nextInt();
        }
        System.out.println("");
    }

    private void tabulateOvertimePay() {
        otPay = new int[ANNUAL];
        for (int i = 0; i < ANNUAL; i++) {
            if (salary[i] > 10000) {
                otPay[i] = otHours[i] * 25;
            } else if (salary[i] > 5000) {
                otPay[i] = otHours[i] * 20;
            } else if (salary[i] > 2000) {
                otPay[i] = otHours[i] * 15;
            } else {
                otPay[i] = otHours[i] * 10;
            }
        }
    }

    private void totalMonthlySalary() {
        grossSalary = new int[ANNUAL];
        for (int i = 0; i < ANNUAL; i++) {
            grossSalary[i] = this.salary[i] + this.otPay[i];
        }
    }

    private void calculateAverageSalary() {
        int sum = 0;
        for (int ea : grossSalary) {
            sum += ea;
        }
        averageSalary = sum / ANNUAL;
    }

    private String monthString(int monthNumber) {
        switch (monthNumber) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                System.out.println("Fatal Error");
                System.exit(0);
                return "Error"; // Needed to keep the compiler happy
        }
    }

    public void display() {
        String m;
        System.out.println("Average salary");
        System.out.printf("%-9s %9s %3s %5s %9s %12s%n",
                "Month", "salary", "OT", "OTPay", "grossPay", "from Average");
        for (int i = 0; i < ANNUAL; i++) {
            m = monthString(i + 1);
            System.out.printf("%-9s %9d %3d %5d %9d %12d%n",
                    m, salary[i], otHours[i], otPay[i], grossSalary[i],
                    grossSalary[i] - averageSalary);
        }

        System.out.println("Average Salary: $ " + averageSalary);
    }

    public static void main(String[] args) {
        int[] s = {1000, 2000, 3000, 4000, 5000, 6000,
            7000, 8000, 9000, 10000, 11000, 12000};
        int[] ot = {5, 5, 5, 5, 5, 2, 2, 2, 2, 2, 1, 0};
        AverageSalary a = new AverageSalary(s, ot);
//        AverageSalary a = new AverageSalary();
        a.display();
    }
}

/* Sample dialogue
run:
Average salary
Month        salary  OT OTPay  grossPay from Average
January        1000   5    50      1050        -5495
February       2000   5    50      2050        -4495
March          3000   5    75      3075        -3470
April          4000   5    75      4075        -2470
May            5000   5    75      5075        -1470
June           6000   2    40      6040         -505
July           7000   2    40      7040          495
August         8000   2    40      8040         1495
September      9000   2    40      9040         2495
October       10000   2    40     10040         3495
November      11000   1    25     11025         4480
December      12000   0     0     12000         5455
Average Salary: $ 6545
BUILD SUCCESSFUL (total time: 0 seconds)
 */
