import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Song> songs = new ArrayList<>();
        Collections.sort(songs);
        System.out.println("Top 3 songs are: ");
        for (int i = songs.size() - 1; i >= songs.size() - 4; i--) {
            System.out.println(i + ". " + songs.get(i));
        }
    }
}
