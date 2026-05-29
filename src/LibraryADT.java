public interface LibraryADT {
    interface LibraryADT {
        // Any class implementing this MUST have all 4 of these methods

        void addBook(int isbn, String title, String author);
        // Adds a new book to the catalogue

        void searchBook(int isbn);
        // Finds and displays a book by ISBN

        void borrowBook(int isbn);
        // Moves a book from catalogue to borrowing history

        void viewLatestHistory();
        // Displays borrowing history in LIFO order
    }
}
