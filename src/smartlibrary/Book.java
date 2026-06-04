package smartlibrary;
public class Book {
    
    int isbn;
    String title;
    String author;
    Book left,right; //pointer to left/right child (smaller/larger ISBN numbers)
    
    //constructor to intialize a new book record
    public Book(int isbn,String title,String author){
        
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        this.left=null;
        this.right=null;
    }
}



