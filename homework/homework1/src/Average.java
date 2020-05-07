public class Average
{

  public static void main(String[] args) {
    if (args.length == 0) {
      return;
    }

    int total = Total.total(args);
    int average = total / args.length;
    System.out.println(average);
  }
}
