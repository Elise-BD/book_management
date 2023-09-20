import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Bibliotheque {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Book> availableBooks = books;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    User currentUser;


    public String menu(){
        System.out.println("-------------- MENU ---------------");
        System.out.println("(1) Get list of available books");
        System.out.println("(2) Borrow a book");
        System.out.println("(3) Return a book");
        System.out.println("(4) Get book information");
        System.out.println("(5) Admin/ Add a book");
        System.out.println("(6) Admin/ Modify a book's information");
        System.out.println("(7) Admin/ Delete a book");
        System.out.println("(8) Quit");

        return sc.nextLine();
    }
    public boolean login(){

        boolean loginOK = false;
        boolean passwOK = false;

        while(!loginOK){

            System.out.println("Enter login : ");
            String login = sc.nextLine();
            for (User u : users) {
                if (Objects.equals(login, u.getLogin())) {
                    currentUser = u;
                    loginOK = true;
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
                        return true;
                    } else {
                        System.out.println("Incorrect password !");
                    }
                }
            } else {System.out.println("Login does not exist !");}
        }
        return false;
    }

    public boolean isAdmin(){
        return Objects.equals(String.valueOf(currentUser.getRole()), "ADMIN");
    }
    public Book defineBookToBorrow(){
        System.out.println("Which book would you like to borrow ? Enter book ID :");
        String input = sc.nextLine();
        for (Book b : availableBooks) {
            if(Objects.equals(input, b.toString())){
                return b;
            }
        }
        System.out.println("Wrong input for book ID (or book is not available) !");
        return null;
    }

    public Book defineBookToReturn(){
        System.out.println("Which book are you returning ? Enter book ID :");
        String input = sc.nextLine();
        for (Book b : borrowedBooks) {
            if(Objects.equals(input, b.toString())){
                return b;
            }
        }
        System.out.println("Wrong input for book ID (or book has already been returned) !");
        return null;
    }

    public Book defineBook(){
        System.out.println("Which book is concerned ? Enter book ID :");
        String input = sc.nextLine();
        for (Book b : books) {
            if(Objects.equals(input, b.toString())){
                return b;
            }
        }
        System.out.println("Wrong input for book ID (or book has already been returned) !");
        return null;
    }

    public void addBook(){

        String title = null;
        String author = null;
        int publicationYear = 0;
        String ISBN = null;

        System.out.println("Set title? (Y)es or (N)o");
        String input = sc.nextLine().toUpperCase();
        if(Objects.equals(input, "Y")){
            System.out.println("Enter title :");
            input = sc.nextLine();
            title = input;
        }

        System.out.println("Set author? (Y)es or (N)o");
        input = sc.nextLine().toUpperCase();
        if(Objects.equals(input, "Y")){
            System.out.println("Enter author :");
            input = sc.nextLine();
            author = input;
        }

        System.out.println("Set publication year? (Y)es or (N)o");
        input = sc.nextLine().toUpperCase();
        if(Objects.equals(input, "Y")){
            System.out.println("Enter publication year :");
            input = sc.nextLine();
            publicationYear = Integer.parseInt(input);
        }

        System.out.println("Set ISBN? (Y)es or (N)o");
        input = sc.nextLine().toUpperCase();
        if(Objects.equals(input, "Y")){
            System.out.println("Enter ISBN :");
            input = sc.nextLine();
            ISBN = input;
        }

        Book b = new Book(title, author, publicationYear,ISBN);
        books.add(b);
        System.out.println("- Add complete -");
    }

    public void deleteBook(Book b){
        books.remove(b);
        System.out.println("- Delete complete -");
    }

    public void modifyBookInfo(Book b){

        //provide modifications
        String newTitle = null;
        String newAuthor = null;
        int newPublicationYear = 0;
        String newISBN = null;

        System.out.println("Modify title? (Y)es or (N)o");
        String input = sc.nextLine().toUpperCase();
        if(Objects.equals(input, "Y")){
            System.out.println("Enter new title :");
            input = sc.nextLine();
            newTitle = input;
        }

        System.out.println("Modify author? (Y)es or (N)o");
        input = sc.nextLine().toUpperCase();
        if(Objects.equals(input, "Y")){
            System.out.println("Enter new author :");
            input = sc.nextLine();
            newAuthor = input;
        }

        System.out.println("Modify publication year? (Y)es or (N)o");
        input = sc.nextLine().toUpperCase();
        if(Objects.equals(input, "Y")){
            System.out.println("Enter new publication year :");
            input = sc.nextLine();
            newPublicationYear = Integer.parseInt(input);
        }

        System.out.println("Modify ISBN? (Y)es or (N)o");
        input = sc.nextLine().toUpperCase();
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
        System.out.printf("| ----------------------------------------------------------------------------------------------------------------------------------------- |%n");
        System.out.printf("| %-137s |", "INFORMATION ON BOOK WITH ID " + b.toString());
        System.out.println(" ");
        System.out.printf("| ----------------------------------------------------------------------------------------------------------------------------------------- |%n");
        System.out.printf("| %-25s | %-25s | %-25s | %-25s |", "TITLE", "AUTHOR", "PUBLICATION", "ISBN");
        System.out.println(" ");
        System.out.printf("| ----------------------------------------------------------------------------------------------------------------------------------------- |%n");
        System.out.printf("| %-25s | %-25s | %-25s | %-25s |", b.getTitle(), b.getAuthor(), String.valueOf(b.getPublicationYear()), b.getISBN());
        System.out.println(" ");
        System.out.printf("| ----------------------------------------------------------------------------------------------------------------------------------------- |%n");
    }

    public void borrowBook(Book b){
        borrowedBooks.add(b);
        availableBooks.remove(b);

        System.out.println("\"" + b.getTitle() + "\" is now borrowed.");
    }

    public void returnBook(Book b){
        availableBooks.add(b);
        borrowedBooks.remove(b);

        System.out.println("\"" + b.getTitle() + "\" has been returned.");
    }

    public void getAvailableBooks(){
        System.out.println(" ");
        System.out.printf("| ----------------------------------------------------------------------------------------------------------------------------------------- |%n");
        System.out.printf("| %-137s |", "LIST OF AVAILABLE BOOKS");
        System.out.println(" ");
        System.out.printf("| ----------------------------------------------------------------------------------------------------------------------------------------- |%n");
        System.out.printf("| %-25s | %-25s | %-25s | %-25s | %-25s |", "BOOK ID", "TITLE", "AUTHOR", "PUBLICATION", "ISBN");
        System.out.println(" ");
        System.out.printf("| ----------------------------------------------------------------------------------------------------------------------------------------- |%n");
        for (Book b : availableBooks) {
            System.out.printf("| %-25s | %-25s | %-25s | %-25s | %-25s |", b.toString(), b.getTitle(), b.getAuthor(), String.valueOf(b.getPublicationYear()), b.getISBN());
            System.out.println(" ");
        }
        System.out.printf("| ----------------------------------------------------------------------------------------------------------------------------------------- |%n");
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
