
/** 220429
 * Absolute Java
 * Chapter5 Programming Projects
 * 1. Define a class called BookStore to maintain the record of books sold. The
 * store contains three categories of books i.e. “Kids”, “Engineering”, and
 * “Story”. The following details should be maintained for each book.
 * a. Book category
 * b. Author
 * c. Title
 * d. Publisher
 * e. Selling price of the book
 * f. Quantity
 * Create a constructor that initializes the Store ID and the rest of the details
 * of the book mentioned above. Include a method named trackSalesStatus that
 * will display the total number of books sold by the store (add a static variable
 * that tracks the total number of books sold). Also, include a method to display
 * the quantity available corresponding to each Book ID. Write a main method to
 * test your class.
 */
public class BookStore {

    private int id;
    private String category;
    private String author;
    private String title;
    private String publisher;
    private double sellPrice;
    private int quantity;
    private int numberSold;
    private static int noOfBooksSold = 0;

    public BookStore(int id, String category, String author, String title,
            String publisher, double sellPrice, int quantity) {
        if (categoryOK(category)) {
            this.id = id;
            this.category = category;
            this.author = author;
            this.title = title;
            this.publisher = publisher;
            this.sellPrice = sellPrice;
            this.quantity = quantity;
        } else {
            System.out.println("Wrong category, either Kids, Engineering or Story");
            System.exit(0);
        }
    }

    public void trackSalesStatus() {
        System.out.println("Total number of books sold by the store: " + noOfBooksSold);
    }

    public void qtyAvailableOfBook() {
        System.out.println("Corresponding to Book ID: " + id
                + ", quantity available: " + (quantity - numberSold));
    }

    public int getId() {
        return id;
    }

    public void setNoSold(int numberSold) {
        this.numberSold = numberSold;
    }

    public int getNumberSold() {
        return numberSold;
    }

    public static void setNoOfBooksSold(int currentBooksSold) {
        BookStore.noOfBooksSold += currentBooksSold;
    }

    private boolean categoryOK(String cat) {
        return (cat.equals("Kids")
                || (cat.equals("Engineering")
                || (cat.equals("Story"))));
    }

    
    public static void main(String args[]) {
        //(id, category, author, title, publisher, sellPrice, quantity)
        BookStore book = new BookStore(1, "Kids", "Alice Oseman",
                "Solitaire", "HarperColins Publishers", 16.04, 10);
        book.setNoSold(2);
        BookStore.setNoOfBooksSold(book.getNumberSold());
        book.qtyAvailableOfBook();
        book.trackSalesStatus();

        BookStore book2 = new BookStore(2, "Engineering", "James Clear",
                "Atomic Habits", "Cornerstone", 26.39, 5);
        book2.setNoSold(1);
        BookStore.setNoOfBooksSold(book2.getNumberSold());
        book2.qtyAvailableOfBook();
        book2.trackSalesStatus();

        BookStore book3 = new BookStore(3, "Story", "Colleen Hoover",
                "Verity", "Little Brown Book Group", 14.58, 30);
        book3.setNoSold(3);
        BookStore.setNoOfBooksSold(book3.getNumberSold());
        book3.qtyAvailableOfBook();
        book3.trackSalesStatus();
    }
}

/* Sample Dialogue
run:
Corresponding to Book ID: 1, quantity available: 8
Total number of books sold by the store: 2
Corresponding to Book ID: 2, quantity available: 4
Total number of books sold by the store: 3
Corresponding to Book ID: 3, quantity available: 27
Total number of books sold by the store: 6
BUILD SUCCESSFUL (total time: 0 seconds)
*/
