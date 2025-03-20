package ValueObject;

public class LieuEvent {
    final private String lieu;

    public LieuEvent(String lieu) {
        this.lieu = lieu;
    }

    public String getLieu() {
        return lieu;
    }

    @Override
    public String toString() {
        return lieu;
    }
}
