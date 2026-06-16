import java.io.*;
import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author, boolean issued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = issued;
    }
}

class Member {
    int id;
    String name;

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class LibraryManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();

    static final String BOOK_FILE = "books.txt";
    static final String MEMBER_FILE = "members.txt";
    public static void addBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author Name: ");
            String author = sc.nextLine();

            FileWriter fw = new FileWriter(BOOK_FILE, true);
            fw.write(id + "," + title + "," + author + ",false\n");
            fw.close();

            System.out.println("Book Added Successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void viewBooks() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE));

            String line;

            System.out.println("\n===== BOOKS LIST =====");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void addMember() {
    try {
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        FileWriter fw = new FileWriter(MEMBER_FILE, true);
        fw.write(id + "," + name + "\n");
        fw.close();

        System.out.println("Member Added Successfully!");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
public static void viewMembers() {
    try {
        BufferedReader br = new BufferedReader(new FileReader(MEMBER_FILE));

        String line;

        System.out.println("\n===== MEMBERS LIST =====");

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
public static void searchBook() {
    try {
        System.out.print("Enter Book ID: ");
        int searchId = sc.nextInt();

        BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE));

        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (Integer.parseInt(data[0]) == searchId) {
                System.out.println("Book Found:");
                System.out.println(line);
                found = true;
                break;
            }
        }

        br.close();

        if (!found) {
            System.out.println("Book Not Found!");
        }

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
public static void deleteBook() {
    try {
        System.out.print("Enter Book ID to Delete: ");
        int deleteId = sc.nextInt();

        File inputFile = new File(BOOK_FILE);
        File tempFile = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (Integer.parseInt(data[0]) != deleteId) {
                bw.write(line);
                bw.newLine();
            }
        }

        br.close();
        bw.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        System.out.println("Book Deleted Successfully!");

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
public static void issueBook() {
    try {
        System.out.print("Enter Book ID: ");
        int issueId = sc.nextInt();

        File inputFile = new File(BOOK_FILE);
        File tempFile = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (Integer.parseInt(data[0]) == issueId) {
                line = data[0] + "," + data[1] + "," + data[2] + ",true";
            }

            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        System.out.println("Book Issued Successfully!");

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
public static void returnBook() {
    try {
        System.out.print("Enter Book ID: ");
        int returnId = sc.nextInt();

        File inputFile = new File(BOOK_FILE);
        File tempFile = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (Integer.parseInt(data[0]) == returnId) {
                line = data[0] + "," + data[1] + "," + data[2] + ",false";
            }

            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        System.out.println("Book Returned Successfully!");

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
public static void calculateFine() {
    System.out.print("Enter Late Days: ");
    int days = sc.nextInt();

    int fine = days * 2;

    System.out.println("Fine Amount = ₹" + fine);
}public static void main(String[] args) {

    while (true) {

        System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Search Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Add Member");
        System.out.println("6. View Members");
        System.out.println("7. Issue Book");
        System.out.println("8. Return Book");
        System.out.println("9. Calculate Fine");
        System.out.println("10. Exit");

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
                deleteBook();
                break;
            case 5:
                addMember();
                break;
            case 6:
                viewMembers();
                break;
            case 7:
                issueBook();
                break;
            case 8:
                returnBook();
                break;
            case 9:
                calculateFine();
                break;
            case 10:
                System.out.println("Thank You!");
                System.exit(0);
            default:
                System.out.println("Invalid Choice!");
        }
    }
}
}
