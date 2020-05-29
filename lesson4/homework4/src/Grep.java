import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Grep
{
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java Grep path word");
            return;
        }

        var path = Path.of(args[0]);
        var word = args[1];

        GrepResult result = search(path, word, new GrepResult());

        result.print();
    }

    private static GrepResult search(Path path, String word, GrepResult grepResult)
        throws IOException {

        if (!Files.exists(path) || !Files.isReadable(path)) {
            return grepResult;
        }

        if (Files.isRegularFile(path)) {
            try (var br = new LineNumberReader(Files.newBufferedReader(path))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    if (line.contains(word)) {
                        grepResult.add(path, br.getLineNumber());
                    }
                }
            }
            catch (Exception e) {
                //バイナリファイルをReaderで読み込むとエラーになる
            }
        }
        else if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                for (Path p : stream) {
                    grepResult = search(p, word, grepResult);
                }
            }
        }

        return grepResult;
    }
}

