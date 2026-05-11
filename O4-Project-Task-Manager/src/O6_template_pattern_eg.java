void main() {

    Game cricket = new Cricket();
    System.out.println("--- Starting Cricket ---");
    cricket.play();

    Game football = new Football();
    System.out.println("\n--- Starting Football ---");
    football.play();
}

abstract class Game {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Checking pitch conditions and tossing coin.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Batsmen are taking their positions.");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished. Final score calculated based on runs.");
    }
}

class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Checking inflation of the ball and starting lineups.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Kick-off from the center circle.");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished. Full-time whistle blown.");
    }
}