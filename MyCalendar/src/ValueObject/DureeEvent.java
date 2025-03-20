package ValueObject;

public class DureeEvent {
    final int duree;

    public DureeEvent(int duree) {
        this.duree = duree;
    }

    public int getDuree() {
        return duree;
    }

    @Override
    public String toString() {
        return Integer.toString(duree);
    }
}
