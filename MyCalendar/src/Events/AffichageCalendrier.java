package Events;

import Principale.CalendarManager;
import Principale.Event;
import Principale.ListEvent;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AffichageCalendrier {
    //Cette methode est horriblement mauvaise mais je ne souhaiter pas passer plus de temps sur le refactoring pour pouvoir avancer dans le projet
    public static ListEvent affichageFiltrer(Scanner scanner, int control, CalendarManager calendar) {
        ListEvent events = new ListEvent();
        int mois = -1;
        int semaine = -1;
        int jour = -1;
        //partie selection
        System.out.print("Entrez l'année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        if (control == 0 || control == 2) {
            System.out.print("Entrez le mois (1-12) : ");
            mois = Integer.parseInt(scanner.nextLine());
        }
        if(control == 2){
            System.out.print("Entrez le numéro de semaine (1-52) : ");
            semaine = Integer.parseInt(scanner.nextLine());
        }
        if(control == 1){
            System.out.print("Entrez le jour (1-31) : ");
            jour = Integer.parseInt(scanner.nextLine());
        }

        switch (control){
            case 0 :
                LocalDateTime debutMois = LocalDateTime.of(annee, mois, 1, 0, 0);
                LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);
                events = calendar.eventsDansPeriode(debutMois, finMois);
                break;
            case 1 :
                LocalDateTime debutSemaine = LocalDateTime.now().withYear(annee)
                        .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                        .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                        .withHour(0).withMinute(0);
                LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);
                events = calendar.eventsDansPeriode(debutSemaine, finSemaine);
                break;
            case 2 :
                LocalDateTime debutJour = LocalDateTime.of(annee, mois, jour, 0, 0);
                LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);
                events = calendar.eventsDansPeriode(debutJour, finJour);
                break;
            case 3 :
                //will be used for the future functionnality
                break;
        }
        return events;
    }
}
