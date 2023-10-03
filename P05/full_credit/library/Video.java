package library;

import javax.management.RuntimeErrorException;
import library.InvalidRuntimeException;
import java.time.*;
/** Library video that's available to patrons for check out. */

public class Video extends library.Publication {

    Duration runtime = null;

    public Video(String title, String author, int copyright, long runtime) {

        super(title, author, copyright);
        this.runtime = Duration.ofMinutes(runtime);
    }

    public String toString() {

        String returnString = "";
        if (this.getDueDate() != null) {

            if (this.runtime.toMinutes() < 0)
                throw new InvalidRuntimeException(this.getTitle(), this.runtime.toMinutes());
            else
                returnString = "Video " + "\"" + this.getTitle() + "\"" + " by " + this.getAuthor() + ", copyright " + this.getCopyright() + ": " + "loaned to " + this.getDueDate().toString() + " until " + this.getDueDate() + ", runtime " + this.runtime.toMinutes() + " minutes";
        }
        else {

            if (this.runtime.toMinutes() < 0)
                throw new InvalidRuntimeException(this.getTitle(), this.runtime.toMinutes());
            else
                returnString = "Video " + "\"" + this.getTitle() + "\"" + " by " + this.getAuthor() + ", copyright " + this.getCopyright() + ", runtime " + this.runtime.toMinutes() + " minutes";
        }
        return returnString;
    }

    public void checkIn(String patron) {
    }

    public void checkOut() {
    }
}
