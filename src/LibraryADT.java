public interface LibraryADT {
    // Adds a new book to the catalogue system
    void addBook(int isbn, String title, String author);

    // Traverses the BST recursively to find a book details
    void searchBook(int isbn);

    // Processes a checkout, shifting records to the tracker
    void borrowBook(int isbn);

    // Displays actions in LIFO order
    void viewLatestHistory();

    // Extension: Processes return and assesses overdue fines
    void returnBook(int isbn, int daysBorrowed);
}
