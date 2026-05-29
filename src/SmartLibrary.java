public class SmartLibrary implements LibrayADT {
    public void searchBook(int isbn) {
        Book b = catalogue.search(isbn);
        if (b != null) {
            System.out.println("\n===== Book Found =====");
            System.out.println("ISBN   : " + b.isbn);
            System.out.println("Title  : " + b.title);
            System.out.println("Author : " + b.author);
            System.out.println("======================");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found in catalogue.");
        }
    }
        // Internal structures — PRIVATE (information hiding!)
        private BookBST catalogue = new BookBST();
        private BorrowStack history = new BorrowStack();

        // Now MUST implement all 4 interface methods:

        @Override
        public void addBook(int isbn, String title, String author) {
            catalogue.insert(isbn, title, author);
            System.out.println("Book added: " + title);
        }

        @Override
        public void searchBook(int isbn) {
            Book b = catalogue.search(isbn);
            if (b != null) {
                System.out.println("Found: ISBN=" + b.isbn + " | " + b.title + " by " + b.author);
            } else {
                System.out.println("Book not found.");
            }
        }

        @Override
        public void borrowBook(int isbn) {
            Book b = catalogue.search(isbn);
            if (b != null) {
                history.push(b);
                System.out.println("Borrowed: " + b.title);
            } else {
                System.out.println("Book not in catalogue.");
            }
        }

        @Override
        public void viewLatestHistory() {
            history.show();
        }
    }
}
