import Events.Periodique;
import Events.RendezVous;
import Events.Reunion;
import Principale.CalendarManager;
import Principale.ListEvent;
import ValueObject.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAffichagePeriode {

    @Test
    public void test(){
        CalendarManager calendar = new CalendarManager();
        calendar.ajouterEvent(
                new Reunion(
                        new TitreEvent("a"),
                        new ProprioEvent("pierre"),
                        new DateEvent(LocalDateTime.of(2025, 3, 20, 14, 16)),
                        new DureeEvent(2),
                        new LieuEvent("107"),
                        new ListeParticipant()
                )
        );
        calendar.ajouterEvent(
                new Periodique(
                        new TitreEvent("b"),
                        new ProprioEvent("paul"),
                        new DateEvent(LocalDateTime.of(2025, 4, 20, 14, 16)),
                        new Frequence(1)
                )
        );
        calendar.ajouterEvent(
                new RendezVous(
                        new TitreEvent("c"),
                        new ProprioEvent("jacques"),
                        new DateEvent(LocalDateTime.of(2025, 5, 20, 14, 16)),
                        new DureeEvent(2)
                )
        );
        ListEvent x = calendar.eventsDansPeriode(
                LocalDateTime.of(2025, 3, 21, 14, 16),
                LocalDateTime.of(2025, 5, 19, 14, 16)
        );
        assertEquals("Événements trouvés : - Événement périodique organisé par paul, prévu le 2025-04-20T14:16.",x.showListe());
    }
}
