import java.util.*;

public class LibraryManager {

    public static void main(String[] args) {

        Library L = new Library("Betty Warmack Library");

        Publication P1 = new Publication("Animal Farm", "George Orwell", 1945);

        Publication P2 = new Publication("Invisible Man", "Ralph Ellison", 1952);

        Publication P3 = new Publication("The Book Thief", "Markus Zusak", 2006);
        
        L.addPublication(P1);

        L.addPublication(P2);

        L.addPublication(P3);

        L.toStringLibrary();

        Scanner sc = new Scanner(System.in);

        System.out.print("Which one of the books would you like to check out? ");

        int BookIndex = sc.nextInt();

        Scanner sc2 = new Scanner(System.in);

        System.out.print("What is your name? ");

        String personName = sc2.nextLine();

        L.checkOut(BookIndex, personName);

        L.toStringLibrary();
    }
}
