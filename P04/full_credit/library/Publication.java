package library;

import java.time.LocalDate;
/** Library resource that's available to patrons for check out. */

public class Publication {

    private String title;

    private String author;

    private int copyright;

    private String loanedTo = null;

    private LocalDate dueDate = null;

    public Publication (String title, String author, int copyright) {

        this.title = title;

        this.author = author;

        this.copyright = copyright;

        LocalDate currentDateTime = LocalDate.now();

        int currentYear = currentDateTime.getYear();

        if (copyright < 1900 || copyright > currentYear)
            throw new IllegalArgumentException("The year chosen for copyright is not permitted");
    }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    public int getCopyright() { return copyright; }

    public LocalDate getDueDate() { return dueDate; }

    void checkOut() {

        this.loanedTo = loanedTo;
        LocalDate currentDateTime = LocalDate.now();
        this.dueDate = currentDateTime.plusDays(14);
    }

    void checkIn(String patron) { this.loanedTo = patron; }

    public String toString() {

        String returnString = "";
        if (loanedTo != null) {

            returnString = "Book" + "\"" + this.title + "\"" + " by " + this.author + ", copyright " + this.copyright + ": " + "loaned to " + this.loanedTo.toString() + " until " + this.dueDate;
        }

        else {

            returnString = "Book" + "\"" + this.title + "\"" + " by " + this.author + ", copyright " + this.copyright;
        }

        return returnString;
    }
}
