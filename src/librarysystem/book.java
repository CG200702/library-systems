/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

/**
 *
 * @author tim
 */
public class book {
    private String name;
    private String ISBN;
    private String author;
    private double price;
    private String ReleaseDate;
    private String genre;

    public book(String name, String ISBN, String author, double price, String releaseDate, String genre) {
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.ReleaseDate = releaseDate;
        this.genre = genre;
    }
    public String toString(){
        return name+", "+ISBN+", "+author+", "+price+", "+ReleaseDate+", "+genre;
    }

    public String getName() {
        return name;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReleaseDate(String releaseDate) {
        this.ReleaseDate = releaseDate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}
