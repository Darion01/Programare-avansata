import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag;
    private final Board board;
    private final List<Player> players;
    private final Dictionary dictionary;


    public Game() {
        bag = new Bag();
        board = new Board();
        players = new ArrayList<>();
        dictionary = new Dictionary();
    }

    public Bag getBag() {
        return this.bag;
    }

    public Board getBoard() {
        return this.board;
    }

    public Dictionary getDictionary(){ return this.dictionary;}

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        if(game.getDictionary().isWord("a"))
            System.out.println("true");
        else
            System.out.println("false");
        game.addPlayer(new Player("Player1", 1));
        game.addPlayer(new Player("Player2", 2));
        game.addPlayer(new Player("Player3", 3));
        game.addPlayer(new Player("Player4", 4));

        game.play();
    }
}