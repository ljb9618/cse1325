import java.util.*;

public class Library {

    private ArrayList<Publication> list = new ArrayList<>();

    private String name;

    Library (String name) { this.name = name; }

    public void addPublication(Publication p) { list.add(p); }

    void checkOut (int publicationIndex, String patron) {

        int numOfBooks = list.size();

        if (publicationIndex < 0)

            throw new IndexOutOfBoundsException("A negative amount of books is not permitted");

        else if (publicationIndex >= numOfBooks)

            throw new IndexOutOfBoundsException("Number of books exceeding the amount of books available in the Library is not permitted");

        list.get(publicationIndex).checkIn(patron);

        list.get(publicationIndex).checkOut();
    }

    public void toStringLibrary() {

        System.out.println(this.name);

        int publicationIndex = 0;

                while (this.list.size() > publicationIndex) {

                    System.out.print(publicationIndex + ") " +this.list.get(publicationIndex).toString());

                    publicationIndex++;
                }
    }
}