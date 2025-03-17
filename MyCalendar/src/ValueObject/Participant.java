package ValueObject;

public class Participant {
    final String nom;

    public Participant(String n){
        this.nom = n;
    }

    public String getNom() {
        return nom;
    }
}
