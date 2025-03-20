package ValueObject;

import java.time.LocalDateTime;
import java.util.Scanner;

public class DateEvent {
    final private LocalDateTime date;

    public DateEvent(LocalDateTime date) {

        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
