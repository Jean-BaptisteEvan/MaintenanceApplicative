package ValueObject;

import java.time.LocalDateTime;
import java.util.Scanner;

public class DateEvent {
    final private LocalDateTime date;

    public DateEvent() {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        date = LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute);
    }

    public LocalDateTime getDate() {
        return date;
    }

}
