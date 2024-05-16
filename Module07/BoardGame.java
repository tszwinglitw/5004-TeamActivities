public record BoardGame(String name, int id, int minPlayers, int maxPlayers, int minPlayTime,
        int maxPlayTime, double difficulty, int rank, double averageRating, int yearPublished) {

    /// Yes, you can add additional functions
    public String toStringWithInfo(GameData col) {
        switch (col) {
            case NAME:
                return name;
            case RATING:
                return String.format("%s (%.2f)", name, averageRating);
            case DIFFICULTY:
                return String.format("%s (%.2f)", name, difficulty);
            case RANK:
                return String.format("%s (%d)", name, rank);
            case MIN_PLAYERS:
                return String.format("%s (%d)", name, minPlayers);
            case MAX_PLAYERS:
                return String.format("%s (%d)", name, maxPlayers);
            case MIN_TIME:
                return String.format("%s (%d)", name, minPlayTime);
            case MAX_TIME:
                return String.format("%s (%d)", name, maxPlayTime);
            case YEAR:
                return String.format("%s (%d)", name, yearPublished);
            default:
                return name;
        }
    }

    public static void main(String[] args) { // used for local quick tests
        var bg = new BoardGame("Catan", 1, 3, 4, 60, 30, 2.5, 1, 4.5, 1995);
        var bg2 = new BoardGame("Catan", 1, 3, 4, 60, 30, 2.5, 1, 4.5, 1995);
        var bg3 = new BoardGame("Catan", 2, 3, 4, 60, 30, 2.5, 1, 4.5, 1995);
        System.out.println(bg);

        System.out.println(bg.equals(bg) + " " + String.valueOf(bg.hashCode() == bg2.hashCode()));
        System.out.println(bg.equals(bg2) + " " + String.valueOf(bg.hashCode() == bg2.hashCode()));
        System.out.println(bg.equals(bg3) + " " + String.valueOf(bg.hashCode() == bg3.hashCode()));

    }

}
