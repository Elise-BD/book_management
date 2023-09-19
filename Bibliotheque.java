import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Bibliotheque {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Book> availableBooks = books;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private HashMap<String,String> authentification = new HashMap<String, String>();
    Scanner sc = new Scanner(System.in);
    User currentUser;


    public void login(){

        boolean loginOK = false;
        boolean passwOK = false;

        while(!loginOK){
            System.out.println("- Welcome to the library's book management system. -");
            System.out.println("Enter login : ");
            String login = sc.nextLine();
            for (User u : users) {
                if (Objects.equals(login, u.getLogin())) {
                    currentUser = u;
                    loginOK = true;
                    break;
                } else {
                    System.out.println("Login does not exist !");
                    break;
                }
            }

            if(loginOK) {
                while (!passwOK) {
                    System.out.println("Enter password : ");
                    String password = sc.nextLine();
                    if (Objects.equals(password, currentUser.getPassword())) {
                        passwOK = true;
                        System.out.println("- Authentification successfull -");
                    } else {
                        System.out.println("Incorrect password !");
                    }
                }
            }
        }
    }
    public void addBook(Book b){
        books.add(b);
    }

    public void deleteBook(Book b){
        books.remove(b);
    }

    public void modifyBookInfo(Book b){

        //provide modifications
        String newTitle = null;
        String newAuthor = null;
        int newPublicationYear = 0;
        String newISBN = null;

        System.out.println("Modify title? (Y)es or (N)o");
        String input = sc.nextLine();
        if(Objects.equals(input, "Y")){
            System.out.println("Enter new title :");
            input = sc.nextLine();
            newTitle = input;
        }

        System.out.println("Modify author? (Y)es or (N)o");
        input = sc.nextLine();
        if(Objects.equals(input, "Y")){
            System.out.println("Enter new author :");
            input = sc.nextLine();
            newAuthor = input;
        }

        System.out.println("Modify publication year? (Y)es or (N)o");
        input = sc.nextLine();
        if(Objects.equals(input, "Y")){
            System.out.println("Enter new publication year :");
            input = sc.nextLine();
            newPublicationYear = Integer.parseInt(input);
        }

        System.out.println("Modify ISBN? (Y)es or (N)o");
        input = sc.nextLine();
        if(Objects.equals(input, "Y")){
            System.out.println("Enter new ISBN :");
            input = sc.nextLine();
            newISBN = input;
        }

        // update book info
        if(newTitle != null) {
            b.setTitle(newTitle);
        }
        if(newAuthor != null) {
            b.setAuthor(newAuthor);
        }
        if(newPublicationYear != 0) {
            b.setPublicationYear(newPublicationYear);
        }
        if(newISBN != null) {
            b.setISBN(newISBN);
        }
        System.out.println("- Modifications saved -");
    }

    public void getBookInfo(Book b){
        System.out.printf("| ------------------------------------------------------------------------------------------------------------- |%n");
        System.out.printf("| %-109s |", "INFORMATION ON " + b.toString());
        System.out.println(" ");
        System.out.printf("| ------------------------------------------------------------------------------------------------------------- |%n");
        System.out.printf("| %-25s | %-25s | %-25s | %-25s |", "TITLE", "AUTHOR", "PUBLICATION", "ISBN");
        System.out.println(" ");
        System.out.printf("| ------------------------------------------------------------------------------------------------------------- |%n");
        System.out.printf("| %-25s | %-25s | %-25s | %-25s |", b.getTitle(), b.getAuthor(), String.valueOf(b.getPublicationYear()), b.getISBN());
        System.out.println(" ");
        System.out.printf("| ------------------------------------------------------------------------------------------------------------- |%n");
    }

    public void borrowBook(Book b){
        borrowedBooks.add(b);
        availableBooks.remove(b);

        System.out.println(b.getTitle() + " is now borrowed.");
    }

    public void returnBook(Book b){
        availableBooks.add(b);
        borrowedBooks.remove(b);

        System.out.println(b.getTitle() + " has been returned.");
    }

    public void getAvailableBooks(){
        System.out.println(" ");
        System.out.printf("| ------------------------------------------------------------------------------------------------------------- |%n");
        System.out.printf("| %-109s |", "LIST OF AVAILABLE BOOKS");
        System.out.println(" ");
        System.out.printf("| ------------------------------------------------------------------------------------------------------------- |%n");
        System.out.printf("| %-25s | %-25s | %-25s | %-25s |", "TITLE", "AUTHOR", "PUBLICATION", "ISBN");
        System.out.println(" ");
        System.out.printf("| ------------------------------------------------------------------------------------------------------------- |%n");
        for (Book b : availableBooks) {
            System.out.printf("| %-25s | %-25s | %-25s | %-25s |", b.getTitle(), b.getAuthor(), String.valueOf(b.getPublicationYear()), b.getISBN());
            System.out.println(" ");
        }
        System.out.printf("| ------------------------------------------------------------------------------------------------------------- |%n");
        System.out.println(" ");
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
