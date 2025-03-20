package Events;

import Principale.Event;
import ValueObject.*;

public class JeSaisPas extends Event {

    public JeSaisPas(EventType type, TitreEvent title, ProprioEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes, LieuEvent lieu, ListeParticipant participants, Frequence frequenceJours) {
        super(type, title, proprietaire, dateDebut, dureeMinutes, lieu, participants, frequenceJours);
    }

}
