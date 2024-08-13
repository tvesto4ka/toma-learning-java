package basics;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int prevNum = -101;
        int position = 0;
        for (int num : nums) {
            if (num > prevNum) {
                nums[position] = num;
                prevNum = num;
                position++;
            }
        }
        return position;
    }
    public static void main(String[] args) {
        //int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {-100,-99,-98,-98,-97,-97};
        /*int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 1;
        }*/
        int result = removeDuplicates(nums);
        System.out.println(result);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
