package basics;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int emptyValue = -1;
        int k = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                k--;
                nums[i] = emptyValue;
            }
        }
//        for (int num: nums) {
//            System.out.print(num + ", ");
//        }
//        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == emptyValue) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] >= 0) {
                        nums[i] = nums[j];
                        nums[j] = emptyValue;
                        break;
                    }
                }
            }

        }
//        for (int num: nums) {
//            System.out.print(num + ", ");
//        }
//        System.out.println();
        return k;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(removeElement(new int[]{1,2,3,4}, 3));
    }
}
