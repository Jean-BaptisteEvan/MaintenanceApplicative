package Events;

import Principale.Event;
import ValueObject.*;

import java.time.LocalDateTime;

public class Reunion extends Event {
    public Reunion(TitreEvent title, ProprioEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes, LieuEvent lieu, ListeParticipant participants) {
        super(EventType.REUNION, title, proprietaire, dateDebut, dureeMinutes, lieu, participants, new Frequence(0));
    }

    //"Réunion organisée par Pierre, prévue le 20 mars 2025 à 14h16, d'une durée de 2 heures, au lieu 107 avec personne"


}
