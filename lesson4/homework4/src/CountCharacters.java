import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CountCharacters
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

class Characters
{
    private final Map<String, Integer> charCount = new HashMap<>();

    public Characters add(String line) {
        for (String c : line.split("")) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return this;
    }

    public Characters merge(Characters other) {
        for (String key : charCount.keySet()) {
            charCount.put(key, charCount.getOrDefault(key, 0) + other.charCount.get(key));
        }
        return this;
    }

    public List<Entry<String, Integer>> sorted() {
        return this.charCount.entrySet()
                             .stream()
                             .sorted(Entry.comparingByValue())
                             .collect(Collectors.toList());
    }
}
