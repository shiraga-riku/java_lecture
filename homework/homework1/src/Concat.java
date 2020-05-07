import java.awt.desktop.PreferencesEvent;

public class Concat
{

  public static void main(String[] args) {
    System.out.println(concat(args));
  }

  public static String concat(String[] args) {
    String result = "";
    for (String e : args) {
      result += e;
    }
    return result;
  }
}
