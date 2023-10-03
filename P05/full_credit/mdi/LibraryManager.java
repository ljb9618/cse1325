package mdi;

import library.Library;
import library.Publication;
import library.Video;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {

    static String selection;
    private static Object InvalidRuntimeException;
    private static Object IllegalAccessException;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Publication P1 = new Publication("Animal Farm", "George Orwell", 1945);
        Publication P2 = new Publication("Invisible Man", "Ralph Ellison", 1952);
        Publication P3 = new Publication("The Book Thief", "Markus Zusak", 2006);

        Library L = new Library("Betty Warmack Library");

        L.addPublication(P1);
        L.addPublication(P2);
        L.addPublication(P3);
        L.toStringLibrary();

        Scanner sc = new Scanner(System.in);

        System.out.print("Would you like to check out one of our books? ");
        int BookIndex = sc.nextInt();
        int CurrentIndex = BookIndex;
        int numberOfBook = L.getListOfPublication().size();

        if (CurrentIndex > numberOfBook -1)
            CurrentIndex = CurrentIndex - numberOfBook;

        Scanner sc2 = new Scanner(System.in);

        System.out.print("What's your name? ");
        String personName = sc2.nextLine();

        if (BookIndex > numberOfBook -1)
            L.checkOutVideo(CurrentIndex);
        else
            L.checkOutBook(CurrentIndex);

        L.checkOutBook(BookIndex, personName);

        L.toStringLibrary();

        String buffer;

        boolean isPublication = false;
        boolean isVideo = false;
        boolean isPatron = false;

        String[] temp1;
        String[] temp2;

        BufferedReader br = null;
        while ((buffer = br.readLine()) != null) {

            if (buffer.contains("Publications")) {

                isPublication = true;
                isVideo = false;
            } else if (buffer.contains("Videos")) {

                isVideo = true;
                isPublication = false;
            } else {

                if (isPublication) {

                    temp1 = buffer.split(",");
                    Publication p = new Publication(temp1[0], temp1[1], Integer.parseInt(temp1[2]));
                    L.addPublication(p);
                } else if (isVideo) {

                    temp2 = buffer.split(",");
                    Video v = new Video(temp2[0], temp2[1], Integer.parseInt(temp2[2]), Integer.parseInt(temp2[3]));
                    L.addVideo(v);
                }
            }

            SelectionLoop(L);

        }


        }

    

    public static void SelectionLoop(Library L) {

        boolean wantToExit = false;
        initialMenu(L);
        while (wantToExit == false) {

            if (selection.contains("1")) {
                publicationsList(L);
                initialMenu(L);
            } else if (selection.contains("2")) {
                newPublication(L);
                initialMenu(L);
            } else if (selection.contains("3")) {
                newVideo(L);
                initialMenu(L);
            } else if (selection.contains("4")) {
                newPatron(L);
                initialMenu(L);
            } else if (selection.contains("5")) {
                newpatronList(L);
                initialMenu(L);
            } else if (selection.contains("6")) {
                checkOutPublications(L);
                initialMenu(L);
            } else if (selection.contains("7")) {
                checkInPublications(L);
                initialMenu(L);
            } else if (selection.contains("x")) {
                wantToExit = true;
            }
            else {
                System.out.println("The selection does not match any of the options listed. Try again!\n");
                initialMenu(L);
            }
        }
    }

    public static void initialMenu(Library L) {

        System.out.println("                                  Main Menu");
        System.out.println("                            " + L.getName() + "\n");
        System.out.println("1) List publications");
        System.out.println("2) Add new publication");
        System.out.println("3) Add new video");
        System.out.println("4) Add new patrons");
        System.out.println("5) List patrons");
        System.out.println("6) Check Out");
        System.out.println("7) Check In");
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nSelection(Select one of the options 1-7 above or x to exit): ");
        selection = sc.next();
        System.out.println("\n");
    }

    public static void publicationsList(Library L) { L.toStringLibrary(); }

    public static void newPublication(Library L) {

        String title;
        String author;
        int copyright;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new Publication's title: ");
        title = sc.next();
        System.out.print("Enter new Publication's author: ");
        author = sc.next();
        System.out.print("Enter new Publication's copyright: ");
        copyright = sc.nextInt();
        Publication p = new Publication(title, author, copyright);
        L.addPublication(p);
        System.out.println("Add Book \"" + title + "\" by " + author +", copyright " + copyright + "\n");
        }


    public static void newVideo(Library L) {

        String title;
        String author;
        int copyright;
        int runtime;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new Video's title: ");
        title = sc.next();
        System.out.print("Enter new Video's author: ");
        author = sc.next();
        System.out.print("Enter new Video's copyright: ");
        copyright = sc.nextInt();
        System.out.print("Enter new Video's runtime in minutes: ");
        runtime = sc.nextInt();
        Video v = new Video(title, author, copyright, runtime);
        L.addPublication(v);
        System.out.println("Add Video \"" + title + "\" by " + author +", copyright " + copyright + ", runtime " + runtime + " minutes" + "\n");
    }

    public static <Patron> void newPatron(Library L) {

        String title;
        String email;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new Patron's name: ");
        title = sc.next();
        System.out.print("Enter new Publication's email: ");
        email = sc.next();
        String name;
        name = null;

        L.addPatron();
        System.out.println("Add Patron " + name + ", " + email);
    }

    public static void newpatronList(Library L) { L.patronMenu(); }

    public static <Patron> void checkOutPublications(Library L) {
        L.toStringLibrary();
        Scanner sc = new Scanner(System.in);
        System.out.print("Which publication would you like to check out? ");
        int PublicationIndex = sc.nextInt();

        System.out.print("\n");
        L.patronMenu();
        sc = new Scanner(System.in);
        System.out.print("What's your name? ");
        int PatronIndex = sc.nextInt();
        ArrayList l1 = L.getListOfPatron();
        Patron pa = (Patron) l1.get(PatronIndex);

        L.checkOut(PublicationIndex, pa);

        ArrayList l2 = L.getListOfPublication();
        Publication p = (Publication) l2.get(PublicationIndex);

        System.out.println(p.toString());
    }

    public static <Patron> void checkInPublications(Library L) {

        L.patronMenu();
        Scanner sc = new Scanner(System.in);
        System.out.print("What's your name? ");
        int PatronIndex = sc.nextInt();
        ArrayList l1 = L.getListOfPatron();
        Patron pa = (Patron) l1.get(PatronIndex);
        String PatronName = String.valueOf(pa.getClass());

        L.toStringLibrary();
        sc = new Scanner(System.in);
        System.out.print("Which Publication are you returning? ");
        int PublicationIndex = sc.nextInt();
        ArrayList l2 = L.getListOfPublication();
        Publication p = (Publication) l2.get(PublicationIndex);
        String LoanedTo = "";
        if (p.getLoanedTo() != null) {
            LoanedTo = String.valueOf(p.getLoanedTo().getClass());
            if (PatronName.equals(LoanedTo)) {
                p.setLoanedTo(null);
                p.setDueDate(null);
                System.out.println("\nYou checked in your publication sucessfully!");
                System.out.println("This publication is available for check out: " + p.toString()+ "\n");
            }
            else {
                System.out.println("\nAnother person has checked out this publication!");
            }
        }
        else {
            System.out.println("\nNo one has checked out this publication.\n");
        }
    }
}
