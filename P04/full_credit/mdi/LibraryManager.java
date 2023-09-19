package mdi;

import java.awt.print.Book;
import java.io.*;
import java.util.*;
import library.Video;
import library.Library;
import library.Publication;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {

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
            }
        }


    }

