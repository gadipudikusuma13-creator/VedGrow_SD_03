import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book Added Successfully!");
    }

    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No Books Available.");
            return;
        }

        for (Book b : books) {
            System.out.println(
                b.id + " | " + b.title + " | " + b.author +
                " | " + (b.issued ? "Issued" : "Available")
            );
        }
    }

    public static void searchBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                System.out.println("Book Found: " + b.title);
                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    public static void issueBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && !b.issued) {
                b.issued = true;
                System.out.println("Book Issued Successfully!");
                return;
            }
        }

        System.out.println("Book Not Available.");
    }

    public static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && b.issued) {
                b.issued = false;
                System.out.println("Book Returned Successfully!");
                return;
            }
        }

        System.out.println("Invalid Book ID.");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    issueBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
