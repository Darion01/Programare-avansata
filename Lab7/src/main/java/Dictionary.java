import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    public boolean isWord(String str) {

        Scanner scan = null;
        try {
            scan = new Scanner(new File("Words.txt"));
            scan.useDelimiter(";|\r?\n|\r");
        }
        catch (FileNotFoundException e)
        {

            System.out.println("Files not found");
        }
        assert scan != null;
        while (scan.hasNext()) {
            if (scan.next().equals(str))
                return true;
        }
        return false;
    }
}
