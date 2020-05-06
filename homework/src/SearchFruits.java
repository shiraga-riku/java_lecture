import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class SearchFruits
{

  public static void main(String[] args) throws IOException {
    int price = Integer.parseInt(args[1]);
    try (BufferedReader br = Files.newBufferedReader(Path.of(args[0]))) {
      List<String> fruits = br.lines()
                             .map(Fruit::new)
                             .filter(f -> f.getPrice() >= price)
                             .map(Fruit::getName)
                             .collect(Collectors.toList());

      System.out.println(String.join(" ", fruits));
    }
  }

}
