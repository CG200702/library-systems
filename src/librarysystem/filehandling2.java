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
public class filehandling2 {

    public static String folderDirectory = System.getProperty("user.dir") + "\\borrowerList.txt";

    public static void writeFile(ArrayList<borrower> borrowerList) {
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < borrowerList.size(); i++) {
                printToFile.println(borrowerList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<borrower> readFile() {
        ArrayList<borrower> borrowerList = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] borrowerDetails = lineFromFile.split(", ");

                borrower myBorrowers = new borrower(borrowerDetails[0], borrowerDetails[1]);//create new borrower object with name and email


                if (borrowerDetails.length == 3) {//if its got a book assigned
                    String book = borrowerDetails[2].substring(1, borrowerDetails[2].length() - 1);
                    if (!book.equals("")) {//if it has been assigned a book
                        myBorrowers.addBook(book);//it adds the book to the borrowers
                    }
                }
                if (borrowerDetails.length >= 4) {//means theyve got name, email, square bracket with isbn,number or more isbn numbers with square bracket on it 
                    //the first book will have a square bracket and the last book will have a square bracket

                    for (int i = 2; i < borrowerDetails.length; i++) {//go through borrower details list which >= 4 and it startes at the end of the email
                        String book = borrowerDetails[i];//setting up temporary isbn book 
                        if (i == 2) {//the first square bracket
                            book = borrowerDetails[i].substring(1, borrowerDetails[i].length());//removes square bracket
                        }
                        if (i == borrowerDetails.length - 1) {//the last square bracket
                            book = borrowerDetails[i].substring(0, borrowerDetails[i].length()-1);

                        }
                        myBorrowers.addBook(book);//adding book to borrower 
                    }
                }

                borrowerList.add(myBorrowers);

            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return borrowerList;
    }
}
