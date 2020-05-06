import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class Fruits
{

  public static void main(String[] args) throws IOException {
    String name = args[1];
    try (BufferedReader br = Files.newBufferedReader(Path.of(args[0]))) {
      Optional<Fruit> fruit = br.lines()
                                .map(Fruit::new)
                                .filter(f -> f.getName()
                                              .equals(name))
                                .findFirst();

      fruit.ifPresent(f -> System.out.println(f.getPrice()));
    }
  }
}
