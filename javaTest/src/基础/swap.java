package 基础;

public class swap {
    static int findDuplicate(int[] nums) {
        int[] map=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(map[nums[i]]==1){
                return nums[i];
            }
            map[nums[i]]++;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 2, 2, 3,3}));

    }
}
