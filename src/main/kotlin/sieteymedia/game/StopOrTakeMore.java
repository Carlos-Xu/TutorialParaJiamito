package sieteymedia.game;

public enum StopOrTakeMore {
    STOP("Plantarse"),
    TAKE_MORE("Coger más");

    public final String spanishName;

    StopOrTakeMore(String spanishName) {
        this.spanishName = spanishName;
    }
}
