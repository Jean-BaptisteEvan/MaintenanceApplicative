package Events;

import Principale.Event;

import java.time.LocalDateTime;

public class Reunion extends Event {
    public Reunion(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants) {
        super("REUNION", title, proprietaire, dateDebut, dureeMinutes, lieu, participants, 0);
    }


}
