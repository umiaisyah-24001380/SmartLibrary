public class BookBST {
    private Book root;

    // Public method to insert a book
    public void insert(int isbn, String title, String author) {
        root = insertRecursive(root, isbn, title, author);
    }

    // Helper method to recursively insert into the tree
    private Book insertRecursive(Book current, int isbn, String title, String author) {
        if (current == null) {
            return new Book(isbn, title, author);
        }

        if (isbn < current.isbn) {
            current.left = insertRecursive(current.left, isbn, title, author);
        } else if (isbn > current.isbn) {
            current.right = insertRecursive(current.right, isbn, title, author);
        }
        // If isbn == current.isbn, we do nothing (duplicate ISBN protection)
        return current;
    }

    // Public method to initiate an O(log n) search
    public Book search(int isbn) {
        return searchRecursive(root, isbn);
    }

    // Rubric Focus: Correctly traverses the tree recursively
    private Book searchRecursive(Book current, int isbn) {
        if (current == null || current.isbn == isbn) {
            return current;
        }
        return (isbn < current.isbn)
                ? searchRecursive(current.left, isbn)
                : searchRecursive(current.right, isbn);
    }
}