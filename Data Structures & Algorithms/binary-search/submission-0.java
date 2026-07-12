class Solution {
    public int search(int[] nums, int target) {
        return binarysearch(0,nums.length - 1,nums,target);
    }
    public int binarysearch(int l, int r, int[] nums,int target){
        if(l > r) return -1;
        int m = l + (r - l)/2;

        if(nums[m] == target){
            return m;
        }
        return (nums[m] < target)?binarysearch(m + 1, r, nums,target):binarysearch(l, r - 1, nums,target);
    }
}
