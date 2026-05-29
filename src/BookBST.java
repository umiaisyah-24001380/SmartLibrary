public class BookBST {
    private Book root; // the very first book added becomes the root

    // PUBLIC method — what others call
    public void insert(int isbn, String title, String author) {
        root = ins(root, isbn, title, author);
        }

        // PRIVATE helper — does the actual recursive work
        private Book ins(Book r, int i, String t, String a) {
            // Base case: empty spot found — place book here
            if (r == null) return new Book(i, t, a);

            // ISBN is smaller → go LEFT
            if (i < r.isbn) {
                r.left = ins(r.left, i, t, a);
            }
            // ISBN is larger → go RIGHT
            else if (i > r.isbn) {
                r.right = ins(r.right, i, t, a);
            }
            // ISBN already exists → do nothing (no duplicates)

            return r; // return current node unchanged
        }
    }

// PUBLIC method — what others call
public Book search(int isbn) {
    return sea(root, isbn);
}

// PRIVATE recursive helper
private Book sea(Book r, int i) {
    // Base case 1: reached empty node → not found
    if (r == null) return null;

    // Base case 2: found it!
    if (r.isbn == i) return r;

    // Recursive case: search left or right
    if (i < r.isbn) {
        return sea(r.left, i);  // go left
    } else {
        return sea(r.right, i); // go right
    }
}
}
