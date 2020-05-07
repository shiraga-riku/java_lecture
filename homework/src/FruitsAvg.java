import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.OptionalDouble;

public class FruitsAvg
{
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of(args[0]);
        String[] names = Arrays.copyOfRange(args, 1, args.length);

        double average1 = average1(filePath, names);
        System.out.println(average1);

        double average2 = average2(filePath, names);
        System.out.println(average2);
    }

    public static double average1(Path filePath, String[] names) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            Arrays.sort(names);
            String line;
            int total = 0;
            int hitCount = 0;
            while ((line = br.readLine()) != null) {
                Fruit f = new Fruit(line);
                if (Arrays.binarySearch(names, f.getName()) >= 0) {
                    hitCount++;
                    total += f.getPrice();
                }
            }

            if (hitCount > 0) {
                return (double) total / hitCount;
            }

            return 0;
        }
    }

    public static double average2(Path filePath, String[] names) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            Arrays.sort(names);
            OptionalDouble average = br.lines()
                                       .map(Fruit::new)
                                       .filter(f -> Arrays.binarySearch(names, f.getName()) >= 0)
                                       .mapToInt(Fruit::getPrice)
                                       .average();

            if (average.isPresent()) {
                return average.getAsDouble();
            }
            return 0;
        }
    }
}
