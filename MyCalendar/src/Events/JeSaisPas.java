package Events;

import Principale.Event;
import ValueObject.*;

import java.time.LocalDateTime;

public class JeSaisPas extends Event {

    public JeSaisPas() {
        super(
                EventType.JESAISPAS,
                new TitreEvent("jesaispas"),
                new ProprioEvent("lui_aussi_ne_sais_pas"),
                new DateEvent(LocalDateTime.now()),
                new DureeEvent(777),
                new LieuEvent("l oeil de l'univers"),
                new ListeParticipant(),
                new Frequence(0)
        );
    }

    @Override
    public String description() {
        return "Si je la connaisait !";
    }
}
