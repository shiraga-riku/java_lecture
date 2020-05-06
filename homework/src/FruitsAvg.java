import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class FruitsAvg
{

  public static void main(String[] args) throws IOException {
    String[] names = names(args);
    try (BufferedReader br = Files.newBufferedReader(Path.of(args[0]))) {
      OptionalDouble average = br.lines()
                                 .map(Fruit::new)
                                 .filter(f -> contains(names, f.getName()))
                                 .mapToInt(Fruit::getPrice)
                                 .average();

      average.ifPresent(System.out::println);
    }
  }

  private static String[] names(String[] args) {
    String[] names = new String[args.length - 1];
    for (int i = 0; i < args.length - 1; i++) {
      names[i] = args[i + 1];
    }
    return names;
  }

  private static boolean contains(String[] names, String name) {
    for (String n : names) {
      if (n.equals(name)) {
        return true;
      }
    }
    return false;
  }
}
