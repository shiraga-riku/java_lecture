import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class Fruits
{

  public static void main(String[] args) throws IOException {
    Path filePath = Path.of(args[0]);
    String name = args[1];

    Fruit fruit1 = search1(filePath, name);
    if (fruit1 != null) {
      System.out.println(fruit1.getPrice());
    }

    Optional<Fruit> fruit2 = search2(filePath, name);
    fruit2.ifPresent(f -> System.out.println(f.getPrice()));
  }

  public static Fruit search1(Path filePath, String name) throws IOException {
    try (BufferedReader br = Files.newBufferedReader(filePath)) {
      String line;
      while ((line = br.readLine()) != null) {
        Fruit f = new Fruit(line);
        if (f.getName()
             .equals(name)) {
          return f;
        }
      }
      return null;
    }
  }

  public static Optional<Fruit> search2(Path filePath, String name) throws IOException {
    try (BufferedReader br = Files.newBufferedReader(filePath)) {
      return br.lines()
               .map(Fruit::new)
               .filter(f -> f.getName()
                             .equals(name)
               )
               .findFirst();
    }
  }
}
