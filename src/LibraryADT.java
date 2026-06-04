package smartlibrary;

//The Console Interface
public interface LibraryADT {
    void addBook (int isbn , String title , String author); // Add a new book to the library catalogue
    void searchBook (int isbn); // Search the book by ISBN using BST
    void borrowBook (int isbn); // Borrow a book and move record to history stack (LIFO)
    void viewLatestHistory (); // Display all borrowed books in LIFO order
    
}
