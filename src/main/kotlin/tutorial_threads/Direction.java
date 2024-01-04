package tutorial_threads;

public enum Direction {
    NS,
    EO;

    public String spasnishName() {
        switch (this) {
            case NS:
                return "Norte-Sur";
            case EO:
                return "Este-Oeste";
            default:
                throw new RuntimeException();
        }
    }
}
