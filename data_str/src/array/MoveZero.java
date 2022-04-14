package array;

public class MoveZero {

    /**
     *
     * For example,
     * given nums = [0, 1, 0, 3, 12], after calling your function,nums should be [1, 3, 12, 0, 0].
     * @param args
     */

    public static void main(String[] args) {

        int[] ints = {0, 1, 0, 3, 12};
        int[][] arrs = {{1,2,3},{4,5,6},{7,8,9}};


        for (int[] arr : arrs) {
            for (int i : arr) {
                System.out.println(i);
            }
        }

        moveZero(ints);

    }


    public static void moveZero(int[] nums){

        int count = 0;
        for (int num : nums) {
            if(num != 0){
                nums[count]=num;
                count++;
            }
        }
        while (count < nums.length){
            nums[count] = 0;
            count++;
        }
        for (int num : nums) {
            System.out.println(num);
        }

    }
}
