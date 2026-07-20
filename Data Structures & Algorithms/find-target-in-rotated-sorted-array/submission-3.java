class Solution {
    public int search(int[] nums, int target) {
         int l = 0, r = nums.length - 1;
    while (l <= r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) return mid;

        // 判断左半段 [l, mid] 是否有序
        if (nums[l] <= nums[mid]) {
            // target不在左段 → 搜右段
            if (target > nums[mid] || target < nums[l]) {
                l = mid + 1;
            } else { // target在左段 → 搜左段
                r = mid - 1;
            }
        } 
        // 右半段 [mid, r] 有序
        else {
            // target不在右段 → 搜左段
            if (target < nums[mid] || target > nums[r]) {
                r = mid - 1;
            } else { // target在右段 → 搜右段
                l = mid + 1;
            }
        }
    }
    return -1;
    }
}
