package ValueObject;

import java.util.ArrayList;

public class ListeParticipant {
    ArrayList<Participant> participants;

    public ListeParticipant() {
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Participant participant) {
        this.participants.add(participant);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Liste des participants : ");
        for (Participant participant : participants) {
            sb.append('\n').append(participant);
        }
        return sb.toString();
    }
}
