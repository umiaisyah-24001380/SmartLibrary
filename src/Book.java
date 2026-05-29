public class Book {
        int isbn;
        String title, author;
        Book left, right; // BST pointers — left child, right child

        public Book(int isbn, String title, String author) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            // left and right are null by default (no children yet)
        }
    }
}
