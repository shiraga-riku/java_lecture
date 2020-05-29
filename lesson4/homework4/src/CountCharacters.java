import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class CountCharacters2
{
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage : java CountCharacters filePath");
            return;
        }

        Path filePath = Path.of(args[0]);
        if (!Files.exists(filePath) || !Files.isReadable(filePath)) {
            System.out.println("Invalid file path");
            return;
        }

        try (var br = Files.newBufferedReader(filePath)) {
            Characters chars = br.lines()
                                 .reduce(new Characters(), Characters::add, Characters::merge);

            for (Map.Entry<String, Integer> entry : chars.sorted()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
