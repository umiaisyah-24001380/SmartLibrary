package smartlibrary;
public class BookBST {

    private Book root;


    /**
     * TASK 1: CATALOGUE ARCHITECT
     * Public wrapper method to add a new book into the tree structure
     * @param isbn
     * @param title
     */

    public void insert(int isbn, String title, String author){
        root = ins(root, isbn, title, author);
    }

    /**
     * Helper method to execute recursive binary tree placement
     */
    private Book ins(Book r, int i, String t, String a){
        // BASE CASE: If find a null spot, insert the new book node here
        if (r == null){
            return new Book(i, t, a);
        }
        // RECURSIVE CASE 1: Incoming ISBN is smaller, navigate left
        if (i < r.isbn){
            r.left = ins(r.left, i, t, a);
        }
        // RECURSIVE CASE 2: Incoming ISBN is larger, navigate right
        else if (i > r.isbn){
            r.right = ins(r.right, i, t, a);
        }

        // return the unchanged node pointer to preserve the tree links
        return r;
    }

    /**
     * TASK 3: RECORD FINDER
     * Public wrapper method to initiate the recursive search from the root.
     * Time Complexity: O(log n)
     */
    public Book search(int i) {

        return see(root, i);
    }

    /**
     * Helper method that executes the recursive Binary Search Tree algorithm.
     * It divides the search space in half at each step to maintain logarithmic efficiency.
     */
    private Book see(Book r, int i) {
        // BASE CASE 1: Book is not found in the tree (reaches a dead end)
        // BASE CASE 2: The target ISBN matches the current node's ISBN (Found!)
        if (r == null || r.isbn == i) {
            return r; 
        }
        
        // RECURSIVE CASE 1: Target ISBN is smaller, traverse down the left subtree
        if (i < r.isbn) {
            return see(r.left, i);
        }
        
        // RECURSIVE CASE 2: Target ISBN is larger, traverse down the right subtree
        else {
            return see(r.right, i);
        }
    }
}
    

