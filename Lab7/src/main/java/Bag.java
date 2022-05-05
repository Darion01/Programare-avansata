import java.sql.Array;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Bag {
    private final Queue<Tile> letters;
    private final List<List<Character>> letterPoints;

    public void addMultipleLetter(char c, int numberOfTimes) {
        int point = 0;
        int stop = 0;
        for (List<Character> letterPoint : letterPoints) {
            if (stop == 1)
                break;
            for (Character thisChar : letterPoint) {
                if (thisChar.equals(c)) {
                    stop = 1;
                }
            }
            point++;
        }
        for (int i = 0; i < numberOfTimes; i++) {
            letters.add(new Tile(c, point - 1));
        }
    }

    public Bag() {
        letterPoints = new ArrayList<>();
        letters = new LinkedList<>();
        for (int i = 0; i <= 10; i++) {
            letterPoints.add(new LinkedList<>());
        }
        letterPoints.get(1).addAll(Arrays.asList('A', 'E', 'I', 'O', 'U', 'L', 'N', 'S', 'T', 'R'));
        letterPoints.get(2).addAll(Arrays.asList('D', 'G'));
        letterPoints.get(3).addAll(Arrays.asList('B', 'C', 'M', 'P'));
        letterPoints.get(4).addAll(Arrays.asList('F', 'H', 'V', 'W', 'Y'));
        letterPoints.get(5).addAll(Arrays.asList('K'));
        letterPoints.get(8).addAll(Arrays.asList('J', 'X'));
        letterPoints.get(10).addAll(Arrays.asList('Q', 'Z'));

        addMultipleLetter('A', 9);
        addMultipleLetter('B', 2);
        addMultipleLetter('C', 2);
        addMultipleLetter('D', 4);
        addMultipleLetter('E', 12);
        addMultipleLetter('F', 2);
        addMultipleLetter('G', 3);
        addMultipleLetter('H', 2);
        addMultipleLetter('I', 9);
        addMultipleLetter('J', 1);
        addMultipleLetter('K', 1);
        addMultipleLetter('L', 4);
        addMultipleLetter('M', 2);
        addMultipleLetter('N', 6);
        addMultipleLetter('O', 8);
        addMultipleLetter('P', 2);
        addMultipleLetter('Q', 1);
        addMultipleLetter('R', 6);
        addMultipleLetter('S', 4);
        addMultipleLetter('T', 6);
        addMultipleLetter('U', 4);
        addMultipleLetter('V', 2);
        addMultipleLetter('W', 2);
        addMultipleLetter('X', 1);
        addMultipleLetter('Y', 2);
        addMultipleLetter('Z', 1);


    }

    public synchronized List<Tile> extractTiles(int number) {
        List<Tile> extracted = new ArrayList<>();

        for (int counter = 0; counter < number; counter++) {
            if (letters.isEmpty()) {
                System.out.println("No more tiles");
            }
            extracted.add(letters.remove());
        }
        return extracted;
    }
}
