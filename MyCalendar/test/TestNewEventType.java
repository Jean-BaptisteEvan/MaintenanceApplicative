import Events.Periodique;
import Events.RendezVous;
import Events.Reunion;

import Principale.Event;
import Principale.ListEvent;
import ValueObject.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNewEventType {

    @Test
    public void test() {
        ListEvent events = new ListEvent();
        events.ajoutEvent(
                new Reunion(
                    new TitreEvent("a"),
                    new ProprioEvent("pierre"),
                    new DateEvent(LocalDateTime.of(2025, 3, 20, 14, 16)),
                    new DureeEvent(2),
                    new LieuEvent("107"),
                    new ListeParticipant()
                )
        );
        events.ajoutEvent(
                new Periodique(
                    new TitreEvent("b"),
                        new ProprioEvent("paul"),
                        new DateEvent(LocalDateTime.of(2025, 3, 20, 14, 16)),
                        new Frequence(1)
                )
        );
        events.ajoutEvent(
                new RendezVous(
                        new TitreEvent("c"),
                        new ProprioEvent("jacques"),
                        new DateEvent(LocalDateTime.of(2025, 3, 20, 14, 16)),
                        new DureeEvent(2)
                )
        );
        ArrayList<Event> e = events.getEvents();
        assertEquals("Réunion organisée par pierre, prévue le 2025-03-20T14:16, d'une durée de 2 minutes, au lieu 107 avec personne.", e.get(0).description());
        assertEquals("Événement périodique organisé par paul, prévu le 2025-03-20T14:16.", e.get(1).description());
        assertEquals("Rendez-vous avec jacques, prévu le 2025-03-20T14:16, d'une durée de 2 minutes.", e.get(2).description());
    }
}
