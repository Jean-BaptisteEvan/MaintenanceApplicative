package Events;

import Principale.Event;
import ValueObject.*;

public class RendezVous extends Event {
    public RendezVous(TitreEvent title, ProprioEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes) {
        super(EventType.RDV_PERSONNEL, title, proprietaire, dateDebut, dureeMinutes, new LieuEvent(""), new ListeParticipant(), new Frequence(0));
    }

    //calendar.ajouterEvent("RDV_PERSONNEL", titre, utilisateur, localDate, duree, "", "", 0);

}
