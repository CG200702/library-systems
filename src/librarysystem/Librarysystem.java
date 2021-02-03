package librarysystem;

import java.util.*;
//next job: writing borrowers into a text file

public class Librarysystem {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<book> bookList = new ArrayList<>();
    private static ArrayList<borrower> myborrowers = new ArrayList<>();
    private static ArrayList<borrower> borrowerList = new ArrayList<>();

    public static void main(String[] args) {
        bookList = fileHandling.readFile();
        borrowerList = filehandling2.readFile();
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("Welcome to my library system");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1 - Add a book");
            System.out.println("2 - View all books");
            System.out.println("3 - Edit book");
            System.out.println("4 - Delete book");
            System.out.println("5 - Make a new borrower");
            System.out.println("6 - Assign a book to a borrower");
            System.out.println("7 - View borrower books");
            System.out.println("8 - View all borrowers");
            System.out.println("0 - Exit");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    editBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    newborrower();
                    break;

                case 6:
                    assignbook();
                    break;

                case 7:
                    viewborrowerbooks();
                    break;
                case 8:
                    viewBorrowers();
                    break;

                case 0:
                    fileHandling.writeFile(bookList);
                    filehandling2.writeFile(borrowerList);
                    System.exit(0);

            }

        }
    }

    public static void addBook() {
        System.out.println("Please type in a name");
        input.nextLine();//to prevent skipping lines
        String name = input.nextLine();
        System.out.println("Please type in a ISBN");
        String ISBN = input.next();
        System.out.println("Please type in a author");
        input.nextLine();//to prevent skipping lines
        String author = input.nextLine();
        System.out.println("Please type in a price");
        double price = input.nextDouble();
        System.out.println("Please type in a release date");
        String releaseDate = input.next();
        System.out.println("Please type in a genre");
        input.nextLine();//to prevent skipping lines

        String genre = input.nextLine();

        book myBook = new book(name, ISBN, author, price, releaseDate, genre);
        bookList.add(myBook);

        System.out.println(myBook.toString());
    }

    public static void viewBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Sorry, there are no books at the moment");
        } else {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(bookList.get(i).toString());
            }
        }
    }

    public static void viewBorrowers() {
        if (borrowerList.isEmpty()) {
            System.out.println("Sorry, there are no borrowers at the moment");
        } else {
            for (int i = 0; i < borrowerList.size(); i++) {
                System.out.println(borrowerList.get(i).toString());
            }
        }
    }

    public static void editBook() {
        //choose which book you want to edit

        //search for thr names in the obj in the array
        int index = getIndex();
        if (index != -1) {
            System.out.println("What would you like to edit?");
            System.out.println("1 - name");
            System.out.println("2 - ISBN");
            System.out.println("3 - author");
            System.out.println("4 - price");
            System.out.println("5 - release date");
            System.out.println("6 - genre");
            int userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("Please type in a name");
                    input.nextLine();//TO PRVENT SKIPPING LINES*********
                    String newname = input.nextLine();
                    bookList.get(index).setName(newname);
                    break;
                case 2:
                    System.out.println("Please type in the ISBN");
                    input.nextLine();//TO PRVENT SKIPPING LINES*********
                    String newISBN = input.nextLine();
                    bookList.get(index).setISBN(newISBN);
                    break;
                case 3:
                    System.out.println("Please type in the author");
                    input.nextLine();//TO PRVENT SKIPPING LINES*********
                    String newauthor = input.nextLine();
                    bookList.get(index).setAuthor(newauthor);
                    break;
                case 4:
                    System.out.println("Please type in the price");
                    double newprice = input.nextDouble();
                    bookList.get(index).setPrice(newprice);
                    break;
                case 5:
                    System.out.println("Please type in the release date");
                    input.nextLine();//TO PRVENT SKIPPING LINES*********
                    String newreleaseDate = input.nextLine();
                    bookList.get(index).setReleaseDate(newreleaseDate);
                    break;
                case 6:
                    System.out.println("Please type in the genre");
                    input.nextLine();//TO PRVENT SKIPPING LINES*********
                    String newgenre = input.nextLine();
                    bookList.get(index).setGenre(newgenre);
                    break;
            }
            System.out.println("Done, the book has been changed to " + bookList.get(index).toString());

        } else {
            System.out.println("book not found");
        }
    }

    public static void deleteBook() {
        int index = getIndex();
        if (index != -1) {
            bookList.remove(index);
        } else {
            System.out.println("book not found");
        }
    }

    public static int getIndex() {
        //search for thr names in the obj in the array
        System.out.println("Please type in the ISBN");
        String ISBN = input.next();

        int index = -1;//to set as the book they have typed in
        if (!bookList.isEmpty()) {
            for (int i = 0; i < bookList.size(); i++) {
                if (ISBN.equals(bookList.get(i).getISBN())) {
                    return i;

                }
            }
        }
        return -1;
    }
    
     public static int getborrowerIndex() {
        //search for the names in the obj in the array
        System.out.println("Please type in the name of the borrower");
        String NAME = input.next();

        int index = -1;//to set as the book they have typed in
        if (!bookList.isEmpty()) {
            for (int i = 0; i < borrowerList.size(); i++) {
                if (NAME.equals(borrowerList.get(i).getName())) {
                    return i;

                }
            }
        }
        return -1;
    }

    public static void newborrower() {
        System.out.println("What's your name?");
        String name = input.next();

        System.out.println("What's your email?");
        String email = input.next();

        borrower newborrower = new borrower(name, email);
        myborrowers.add(newborrower);
        borrowerList.add(newborrower);

    }
    int bookindex = getIndex();

    public static int getborrower() {
        System.out.println("What's their name?");
        String name = input.next();
        int index = -1;
        if (!myborrowers.isEmpty()) {
            for (int i = 0; i < myborrowers.size(); i++) {
                if (name.equals(myborrowers.get(i).getName())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void assignbook() {
        int bookindex = getIndex();
        if (bookindex == -1) {
            System.out.println("That's not a valid book");
        } else {
            int borrowerindex = getborrowerIndex();
            if (borrowerindex == -1) {
                System.out.println("Not a valid borrower");

            } else {
                myborrowers.get(borrowerindex).addBook(bookList.get(bookindex).getISBN());
                System.out.println(borrowerList.get(borrowerindex).getName() + " has been assigned " + bookList.get(bookindex).getName());
            }

        }
    }

    public static void viewborrowerbooks() {
        int index = getborrower();
        if (index == -1) {
            System.out.println("That's not a valid borrower");
        } else {
            System.out.println(myborrowers.get(index).toString());
        }
    }
}
