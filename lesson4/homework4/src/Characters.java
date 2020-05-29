import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
