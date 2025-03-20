package Principale;

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

    private void afficherListe() {
        if (listEvents.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : this.listEvents) {
                System.out.println("- " + e.description());
            }
        }
    }
}
