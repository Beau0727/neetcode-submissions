class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int l = 0; l < numbers.length; l++) 
            for (int r = l + 1; r < numbers.length; r++){
                if(numbers[l] + numbers[r] == target){
                    return new int[]{l+1,r+1};
                }
            }
            return new int[0];
    }
}
