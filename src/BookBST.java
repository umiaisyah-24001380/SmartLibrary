/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author nadhirahrahim
 */
public class BookBST {

    /**
     * @param args the command line arguments
     */
    
    private Book root;

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
    

