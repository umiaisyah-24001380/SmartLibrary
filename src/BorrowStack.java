
import java.util.Stack;

public class BorrowStack {
    // Encapsulated backing structure
    private final Stack<Book> stack = new Stack<>();

    public void push(Book b) {
        stack.push(b);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public Book pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return null;
    }

    // Correctly reads the collection backward to show the most recent activity first
    public void show() {
        if (stack.isEmpty()) {
            System.out.println("-> History is empty.");
            return;
        }
        System.out.println("\n--- Borrowing History (Most Recent First) ---");
        for (int i = stack.size() - 1; i >= 0; i--) {
            Book b = stack.get(i);
            System.out.println("• [ISBN: " + b.isbn + "] " + b.title + " by " + b.author);
        }
    }
}