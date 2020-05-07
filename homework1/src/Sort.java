import java.util.Arrays;

public class Sort
{

  public static void main(String[] args) {
    int[] nums = toNums(args);
    int[] sorted = bubbleSort(nums);

    System.out.println(Arrays.toString(nums));
  }

  public static int[] toNums(String[] args) {
    int[] nums = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      nums[i] = Integer.parseInt(args[i]);
    }
    return nums;
  }

  public static int[] bubbleSort(int[] nums) {
    for (int i = nums.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[j + 1]) {
          int t = nums[j + 1];
          nums[j + 1] = nums[j];
          nums[j] = t;
        }
      }
    }
    return nums;
  }
}
