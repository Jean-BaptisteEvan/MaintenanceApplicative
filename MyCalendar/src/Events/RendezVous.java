package Events;

import Principale.Event;
import ValueObject.*;

public class RendezVous extends Event {
    public RendezVous(TitreEvent title, ProprioEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes) {
        super(EventType.RDV_PERSONNEL, title, proprietaire, dateDebut, dureeMinutes, new LieuEvent(""), new ListeParticipant(), new Frequence(0));
    }

    //"Rendez-vous avec Jacques, prévu le 20 mars 2025 à 14h16, d'une durée de 2."

}
