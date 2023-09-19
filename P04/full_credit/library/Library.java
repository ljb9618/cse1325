package library;

import java.util.*;
/** Models a library that has multiple publications */

public class Library {

    private String name;

    private ArrayList<Publication> list = new ArrayList();

    private ArrayList<library.Video> ListOfVideos = new ArrayList();

    public ArrayList getListOfVideo () { return ListOfVideos; }

    public ArrayList getListOfPublication () { return list; }

    public Library(String name) { this.name = name; }

    public void addPublication(Publication p) { list.add(p); }

    public void addVideo(library.Video v) { ListOfVideos.add(v); }

    public void checkOutBook (int publicationIndex, String patron) {

        int numOfBooks = list.size();

        if (publicationIndex < 0)
            throw new IndexOutOfBoundsException("A negative amount of publications is not permitted");
        else if (publicationIndex >= numOfBooks)
            throw new IndexOutOfBoundsException("Number of books exceeding the amount of books available is not permitted in the library.Library");
        list.get(publicationIndex).checkIn(patron);
        list.get(publicationIndex).checkOut();
    }

    public void checkOutVideo (int videoIndex) {

        int numOfVideos = ListOfVideos.size();

        if (videoIndex < 0)
            throw new IndexOutOfBoundsException("A negative amount of videos is not permitted");
        else if (videoIndex >= numOfVideos)
            throw new IndexOutOfBoundsException("Number of videos exceeding the amount of videos available is not permitted in the library.Library");
        String patron = null;
        ListOfVideos.get(videoIndex).checkIn(patron);
        ListOfVideos.get(videoIndex).checkOut();
    }

    public void toStringLibrary() {

        System.out.println(this.name);
        int publicationIndex = 0;
                while (this.list.size() > publicationIndex) {
                    System.out.println(publicationIndex + ") " +this.list.get(publicationIndex).toString());
                    publicationIndex++;
                }

        int videoIndex = 0;
                while (this.ListOfVideos.size() > videoIndex) {
                    System.out.println(publicationIndex + videoIndex + ") " +this.ListOfVideos.get(videoIndex));
                    videoIndex++;
                }
    }

    public void checkOutBook(int currentIndex) {

    }
}

