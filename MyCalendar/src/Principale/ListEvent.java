package Principale;

import java.util.ArrayList;

public class ListEvent {
    private final ArrayList<Event> listEvents;

    public ListEvent() {
        listEvents = new ArrayList<>();
    }

    public void ajoutEvent(Event event) {
        listEvents.add(event);
    }

    public ArrayList<Event> getEvents() {
        return listEvents;
    }
}
