/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.util.ArrayList;

/**
 *
 * @author tim
 */
public class borrower {

    private String name;
    private String email;
    private ArrayList<String> booksBorrowed = new ArrayList<>();

    public borrower(String name, String email) {
        this.name = name;
        this.email = email;
        

    }

    borrower(String borrowerDetail, String borrowerDetail0, String borrowerDetail1, String borrowerDetail2, String borrowerDetail3, String borrowerDetail4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;}
    
    public void addBook(String mybook){
        booksBorrowed.add(mybook);
    }
    
    public String toString(){
        return name+", "+email+", "+booksBorrowed.toString();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getBooksBorrowed() {
        return booksBorrowed;
    }

}

