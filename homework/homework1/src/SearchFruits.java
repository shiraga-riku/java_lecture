import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class SearchFruits
{

    public static void main(String[] args) throws IOException {
        Path filePath = Path.of(args[0]);
        int price = Integer.parseInt(args[1]);

        List<Fruit> fruits1 = search1(filePath, price);
        System.out.println(fruits1.stream()
                                  .map(Fruit::getName)
                                  .collect(Collectors.joining(" ")));

        List<Fruit> fruits2 = search2(filePath, price);
        System.out.println(fruits2.stream()
                                  .map(Fruit::getName)
                                  .collect(Collectors.joining(" ")));
    }

    public static List<Fruit> search1(Path filePath, int price) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            List<Fruit> fruits = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                Fruit fruit = new Fruit(line);
                if (fruit.getPrice() > price) {
                    fruits.add(fruit);
                }
            }
            return fruits;
        }
    }

    public static List<Fruit> search2(Path filePath, int price) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            return br.lines()
                     .map(Fruit::new)
                     .filter(f -> f.getPrice() > price)
                     .collect(Collectors.toList());
        }
    }
}
