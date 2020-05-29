import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class GrepResult
{
    private Map<Path, List<Integer>> entries = new HashMap<>();

    public void add(Path filePath, int number) {
        var numbers = entries.getOrDefault(filePath, new ArrayList<>());
        numbers.add(number);
        entries.put(filePath, numbers);
    }

    public void print() {
        for (var entry : entries.entrySet()) {
            String s = entry.getValue()
                            .stream()
                            .map(String::valueOf)
                            .collect(
                                Collectors.joining(","));
            System.out.println(entry.getKey() + " " + s);
        }
    }
}
