/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author tim
 */
public class fileHandling {

    public static String folderDirectory = System.getProperty("user.dir") + "\\bookList.txt";

    public static void writeFile(ArrayList<book>bookList) {
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < bookList.size(); i++) {
                printToFile.println(bookList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<book>readFile() {
        ArrayList<book>bookList=new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] bookDetails = lineFromFile.split(", ");
                //String name, String ISBN, String author, double price, String releaseDate, String genre
                book myBook = new book(bookDetails[0],bookDetails[1],bookDetails[2],Double.parseDouble(bookDetails[3]),bookDetails[4],bookDetails[5]);
                
                bookList.add(myBook);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return bookList;
    }
}

