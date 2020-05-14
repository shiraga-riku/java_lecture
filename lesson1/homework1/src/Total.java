public class Total
{

  public static void main(String[] args) {
    int result = total(args);
    System.out.println(result);
  }

  public static int total(String[] nums) {
    int result = 0;
    for (String num : nums) {
      result += Integer.parseInt(num);
    }
    return result;
  }
}
