
/** 220504
 * Absolute Java
 * Chapter2 Programming Projects
 * 10. Write a program that inputs the name, quantity, and price of three items.
 * The name may contain spaces. Output a bill with a tax rate of 6.25%. All
 * prices should be output to two decimal places. The bill should be formatted
 * in columns with 30 characters for the name, 10 characters for the quantity,
 * 10 characters for the price, and 10 characters for the total.
 */
import java.util.Scanner;

public class Proj0210_formattedBill {

    public static void main(String args[]) {

        String item1Name, item2Name, item3Name;
        int item1Qty, item2Qty, item3Qty;
        double item1Price, item2Price, item3Price;
        double item1Total, item2Total, item3Total, subTotal, afterTax;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Input name of item 1:");
        item1Name = keyboard.nextLine();
        System.out.println("Input quantity of item 1:");
        item1Qty = keyboard.nextInt();
        System.out.println("Input price of item 1:");
        item1Price = keyboard.nextDouble();
        keyboard.nextLine(); //To get rid of '\n'

        System.out.println("Input name of item 2:");
        item2Name = keyboard.nextLine();
        System.out.println("Input quantity of item 2:");
        item2Qty = keyboard.nextInt();
        System.out.println("Input price of item 2:");
        item2Price = keyboard.nextDouble();
        keyboard.nextLine(); //To get rid of '\n'

        System.out.println("Input name of item 3:");
        item3Name = keyboard.nextLine();
        System.out.println("Input quantity of item 3:");
        item3Qty = keyboard.nextInt();
        System.out.println("Input price of item 3:");
        item3Price = keyboard.nextDouble();

        item1Total = item1Qty * item1Price;
        item2Total = item2Qty * item2Price;
        item3Total = item3Qty * item3Price;

        System.out.println("Your bill\n");
        System.out.println("Item\t\t\t      Quantity       Price     Total");
        System.out.printf("%-30s%-10d%10.2f%10.2f %n", item1Name, item1Qty,
                item1Price, item1Total);
        System.out.printf("%-30s%-10d%10.2f%10.2f %n", item2Name, item2Qty,
                item2Price, item2Total);
        System.out.printf("%-30s%-10d%10.2f%10.2f %n", item3Name, item3Qty,
                item3Price, item3Total);

        subTotal = item1Total + item2Total + item3Total;
        System.out.printf("Subtotal  %50.2f %n", subTotal);
        afterTax = subTotal * 6.25 / 100;
        System.out.printf("6.25%% sales tax     %40.2f %n", afterTax);
        System.out.printf("Total     %50.2f %n", subTotal + afterTax);
    }
}

/* Sample Dialogue
antw@Mac-mini chapter2 % java Proj0210_formattedBill.java
Input name of item 1:
lollipops
Input quantity of item 1:
10
Input price of item 1:
0.50
Input name of item 2:
diet soda
Input quantity of item 2:
3
Input price of item 2:
1.25
Input name of item 3:
chocolate bar
Input quantity of item 3:
20
Input price of item 3:
0.75
Your bill

Item			      Quantity       Price     Total
lollipops                     10              0.50      5.00 
diet soda                     3               1.25      3.75 
chocolate bar                 20              0.75     15.00 
Subtotal                                               23.75 
6.25% sales tax                                         1.48 
Total                                                  25.23 
*/
