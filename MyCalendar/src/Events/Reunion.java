package Events;

import Principale.Event;
import ValueObject.*;

public class Reunion extends Event {
    public Reunion(TitreEvent title, ProprioEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes, LieuEvent lieu, ListeParticipant participants) {
        super(EventType.REUNION, title, proprietaire, dateDebut, dureeMinutes, lieu, participants, new Frequence(0));
    }

    //"Réunion organisée par Pierre, prévue le 20 mars 2025 à 14h16, d'une durée de 2 heures, au lieu 107 avec personne."
    @Override
    public String description() {
        String str = "Réunion organisée par " + proprietaire + ", prévue le " + dateDebut + ", d'une durée de " + dureeMinutes + " minutes, au lieu " + lieu + " avec " ;
        StringBuilder participant = new StringBuilder();
        if (participants.getParticipants().isEmpty()){
            return str + " personne.";
        }
        for (Participant p : participants.getParticipants()){
            participant.append(p.getNom()).append(" ");
        }
        return str + participant;
    }


}
