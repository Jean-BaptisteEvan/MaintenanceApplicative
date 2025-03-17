package Events;

import Principale.Event;
import ValueObject.*;

import java.time.LocalDateTime;

public class Reunion extends Event {
    public Reunion(TitreEvent title, ProprioEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes, LieuEvent lieu, ListeParticipant participants) {
        super(EventType.REUNION, title, proprietaire, dateDebut, dureeMinutes, lieu, participants, new Frequence(0));
    }


}
