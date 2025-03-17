package Events;

import Principale.Event;
import ValueObject.*;

public class Periodique extends Event {
    public Periodique( TitreEvent title, ProprioEvent proprietaire, DateEvent dateDebut, Frequence frequenceJours) {
        super(EventType.PERIODIQUE, title, proprietaire, dateDebut,  new DureeEvent(0), new LieuEvent(""), new ListeParticipant(), frequenceJours);
    }
}
