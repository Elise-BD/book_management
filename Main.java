public class Main {
    public static void main(String[] args) {

        Bibliotheque library = new Bibliotheque();

        // Create some book objects
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-0-06-112008-4");
        Book book2 = new Book("1984", "George Orwell", 1949, "978-0-452-28423-4");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "978-0-7432-7356-5");
        Book book4 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "978-0-316-76948-7");
        Book book5 = new Book("Pride and Prejudice", "Jane Austen", 1813, "978-1-85326-000-1");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        // Create some user objects
        User user1 = new User("Smith", "John", "jsmith", "password123", Role.USER);
        User user2 = new User("Doe", "Jane", "jdoe", "secure@.Password!_97", Role.ADMIN);
        User user3 = new User("Brown", "Michael", "mbrown", "myPassword", Role.USER);
        library.getUsers().add(user1);
        library.getUsers().add(user2);
        library.getUsers().add(user3);

        library.getBookInfo(book1);
        library.getAvailableBooks();
        library.borrowBook(book1);
        library.getAvailableBooks();
    }
}
