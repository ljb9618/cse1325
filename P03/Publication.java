import java.time.LocalDate;

public class Publication {

    private String title;

    private String author;

    private int copyright;

    private String loanedTo = null;

    private LocalDate dueDate = null;

    Publication (String title, String author, int copyright) {

        LocalDate currentDateTime = LocalDate.now();

        this.title = title;

        this.author = author;

        this.copyright = copyright;

        int currentYear = currentDateTime.getYear();

        if (copyright < 1900 || copyright > currentYear)

            throw new IllegalArgumentException("That year is not permitted for copyright in this circumstance");
    }

    void checkOut() {

        LocalDate currentDateTime = LocalDate.now();

        this.loanedTo = loanedTo;

        this.dueDate = currentDateTime.plusDays(14);
    }

    void checkIn(String patron) { this.loanedTo = patron; }

    public String toString() {

        String returnString = "";

        if (loanedTo != null) {

            returnString = "\"" + this.title + "\"" + " by " + this.author +  ", copyright " + this.copyright + ": " + "loaned to " + this.loanedTo + " until " + this.dueDate;

        }

        else {

            returnString = "\"" + this.title + "\"" + " by " + this.author + ", copyright " + this.copyright;
        }

        return returnString;
    }
}
