package Principale;

import ValueObject.EventType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListEvent {
    private ArrayList<Event> listEvents = null;

    public ListEvent() {
        listEvents = new ArrayList<>();
    }

    public void ajoutEvent(Event event) {
        listEvents.add(event);
    }

    public ArrayList<Event> getEvents() {
        return listEvents;
    }

    public String showListe() {
        StringBuilder str = new StringBuilder();
        if (listEvents.isEmpty()) {
            return "Aucun événement trouvé pour cette période.";
        } else {
            str = new StringBuilder("Événements trouvés : ");
            for (Event e : this.listEvents) {
                str.append("- ").append(e.description());
            }
        }
        return str.toString();
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.getDate().plusMinutes(e1.dureeMinutes.getDuree());
        LocalDateTime fin2 = e2.dateDebut.getDate().plusMinutes(e2.dureeMinutes.getDuree());

        if (e1.type == EventType.PERIODIQUE || e2.type == EventType.PERIODIQUE) {
            return false; // Simplification abusive
        }

        return e1.dateDebut.getDate().isBefore(fin2) && fin1.isAfter(e2.dateDebut.getDate());
    }

    public boolean conflits(Event e1){
        for (Event e2 : this.listEvents) {
            if(conflit(e1,e2)){
                return true;
            }
        }
        return false;
    }
}
