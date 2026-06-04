package smartlibrary;

import java.util.Scanner;

public class SmartLibrary implements LibraryADT {
    // Information Hiding: underlying structures are strictly private
    private final BookBST catalogue = new BookBST();
    private final BorrowStack history = new BorrowStack();

    // Constant configuration for the system extension
    private static final int MAX_BORROW_DAYS = 7;
    private static final double FINE_PER_DAY = 0.50; // RM 0.50 per day overdue

    @Override
    public void addBook(int isbn, String title, String author) {
        catalogue.insert(isbn, title, author);
        System.out.println("Success: \"" + title + "\" has been recorded in the catalog.");
    }

    @Override
    public void searchBook(int isbn) {
        Book b = catalogue.search(isbn);
        if (b != null) {
            System.out.println("\n[Match Found]");
            System.out.println("ISBN   : " + b.isbn);
            System.out.println("Title  : " + b.title);
            System.out.println("Author : " + b.author);
        } else {
            System.out.println("Result: No book matching ISBN " + isbn + " exists in the system.");
        }
    }

    @Override
    public void borrowBook(int isbn) {
        Book b = catalogue.search(isbn);
        if (b != null) {
            history.push(b);
            System.out.println("Success: You checked out \"" + b.title + "\". Logs pushed to history.");
        } else {
            System.out.println("Error: Transaction rejected. Book is missing or checkout invalid.");
        }
    }

    @Override
    public void viewLatestHistory() {
        history.show();
    }

    @Override
    public void returnBook(int isbn, int daysBorrowed) {
        if (history.isEmpty()) {
            System.out.println("Error: No books are listed as borrowed right now.");
            return;
        }

        // Pop the topmost item to evaluate it
        Book b = history.pop();

        // LIFO Verification: Ensure the book is actually what the user is trying to return
        if (b.isbn != isbn) {
            System.out.println("Error: Transaction rejected.");
            System.out.println("According to strict LIFO rules, you must return your most recent checkout first (\"" + b.title + "\").");
            history.push(b); // Put it safely back on top of the stack
            return;
        }

        System.out.println("Processing return for: \"" + b.title + "\"");

        if (daysBorrowed > MAX_BORROW_DAYS) {
            int overdueDays = daysBorrowed - MAX_BORROW_DAYS;
            double fine = overdueDays * FINE_PER_DAY;
            System.out.printf("ALERT: Book is overdue by %d days! Total Fine: RM %.2f\n", overdueDays, fine);
        } else {
            System.out.println("Returned on time. No outstanding penalty fees.");
        }
    }

    // Entry runtime wrapper loop with input loop validation
    public void runMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.print("Select choice (1-6): ");

            int choice = readSafeInteger(sc);
            if (choice == 6) {
                System.out.println("Closing core services. Goodbye!");
                break;
            }
            handleChoice(choice, sc);
        }
        sc.close();
    }

    private void printMenu() {
        System.out.println("\n=================================");
        System.out.println("   SMART LIBRARY SYSTEM MENU     ");
        System.out.println("=================================");
        System.out.println("1. Add Book to Catalog");
        System.out.println("2. Search Book Details (O(log n))");
        System.out.println("3. Borrow Book (Push to Stack)");
        System.out.println("4. View Activity Log (LIFO)");
        System.out.println("5. Return Book (Fine Management)");
        System.out.println("6. Exit Terminal");
        System.out.println("=================================");
    }

    private void handleChoice(int choice, Scanner sc) {
        switch (choice) {
            case 1:
                System.out.print("Enter ISBN (Numbers only): ");
                int isbn = readSafeInteger(sc);
                sc.nextLine(); // Clear scanner buffer

                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();

                System.out.print("Enter Author Name: ");
                String author = sc.nextLine();

                addBook(isbn, title, author);
                break;

            case 2:
                System.out.print("Enter Search target ISBN: ");
                int searchIsbn = readSafeInteger(sc);
                searchBook(searchIsbn);
                break;

            case 3:
                System.out.print("Enter Target ISBN to borrow: ");
                int borrowIsbn = readSafeInteger(sc);
                borrowBook(borrowIsbn);
                break;

            case 4:
                viewLatestHistory();
                break;

            case 5:
                System.out.print("Enter returning Book ISBN: ");
                int returnIsbn = readSafeInteger(sc);
                System.out.print("Enter numbers of days kept: ");
                int days = readSafeInteger(sc);
                returnBook(returnIsbn, days);
                break;

            default:
                System.out.println("Warning: Command unassigned. Choose options between 1 and 6.");
        }
    }

    // catches strings/characters when integers are required
    private int readSafeInteger(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Type mismatch format! Input an integer code numeric only.");
            System.out.print("Try again: ");
            sc.next(); // Discard the invalid token string input
        }
        return sc.nextInt();
    }
}