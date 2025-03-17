package ValueObject;

public class ProprioEvent {
    final private String nom;

    public ProprioEvent(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
