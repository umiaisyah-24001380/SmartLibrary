/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smart_library_project;

import java.util.Stack;

/**
 *
 * @author Lenovo
 */

//   BORROWING HISTORY
public class BorrowStack {
    
    private Stack<Book> stack=new Stack<>();
    
    //1. push a checked-out book onto the top of history stack
    public void push(Book b){
        if(b != null){
            stack.push(b);
        }
    }
    
    //removes and returns the top book from the stack
    public Book pop(){
        if(!stack.isEmpty()){
            return stack.pop();
        }
        return null;
    }
    
    //check if history is currently empty
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    
    //display all borrowed items in LIFO sequence
    //the most recently borrowed books will always appear at the top
    public void show(){
        
        //step A: check if the history is empty
        if(stack.isEmpty()){
            System.out.println("History is empty.");
            return;
        }
        
        System.out.println("\n-- BORROWING HISTORY (LIFO ORDER)--");
        
        //step B : loop backwards from the top element (size-1) to 0
        //this ensures the newest activity shows first (LIFO order)
        for(int i=stack.size()-1; i>=0; i--){
            Book b=stack.get(i); // fetch the book at position i
            System.out.println("[ISBN: "+b.isbn+"] "+b.title+" by "+b.author);
        }
    }
    
}
