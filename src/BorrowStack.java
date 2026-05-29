
    class BorrowStack {
        // Using Java's built-in Stack (as shown in PDF)
        private Stack<Book> stack = new Stack<>();

        // PUSH — add a book to history when borrowed
        public void push(Book b) {
            stack.push(b); // adds to top
        }

        // SHOW — display history, most recent first
        public void show() {
            if (stack.isEmpty()) {
                System.out.println("Borrowing history is empty.");
                return;
            }

            System.out.println("\n===== Borrowing History (Most Recent First) =====");
            // Loop backwards through stack (top = end of stack)
            for (int i = stack.size() - 1; i >= 0; i--) {
                Book b = stack.get(i);
                System.out.println("[" + (stack.size() - i) + "] "
                        + "ISBN: " + b.isbn
                        + " | Title: " + b.title
                        + " | Author: " + b.author);
            }
            System.out.println("=================================================");
        }

        // CHECK if empty
        public boolean isEmpty() {
            return stack.isEmpty();
        }

        // GET size
        public int size() {
            return stack.size();
        }
    }
}
