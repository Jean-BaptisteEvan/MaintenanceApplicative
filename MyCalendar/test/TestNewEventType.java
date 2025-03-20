import Events.JeSaisPas;
import Principale.CalendarManager;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNewEventType {
    @Test
    void testNewEventType() {
        CalendarManager calendarManager = new CalendarManager();
        JeSaisPas jsp = new JeSaisPas();
        assertEquals(true,calendarManager.ajouterEvent(jsp));
    }
}
