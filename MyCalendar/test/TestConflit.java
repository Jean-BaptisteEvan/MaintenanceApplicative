import Events.Periodique;
import Events.RendezVous;
import Principale.CalendarManager;
import Principale.Event;
import ValueObject.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConflit {
    @Test
    public void test() {
        CalendarManager calendarManager = new CalendarManager();
        calendarManager.ajouterEvent(
                new Periodique(
                        new TitreEvent("b"),
                        new ProprioEvent("paul"),
                        new DateEvent(LocalDateTime.of(2025, 4, 20, 14, 16)),
                        new Frequence(1)
                )
        );
        calendarManager.ajouterEvent(
                new RendezVous(
                        new TitreEvent("c"),
                        new ProprioEvent("jacques"),
                        new DateEvent(LocalDateTime.of(2025, 5, 20, 14, 16)),
                        new DureeEvent(2)
                )
        );
        Event e =
                new RendezVous(
                        new TitreEvent("c"),
                        new ProprioEvent("jacques"),
                        new DateEvent(LocalDateTime.of(2025, 5, 20, 14, 16)),
                        new DureeEvent(2));
        assertEquals(false, calendarManager.ajouterEvent(e));
    }
}
