class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        // 第一阶段：快慢指针在环内相遇
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 第二阶段：新指针从头出发，同步前进，相遇点即为环入口（重复数）
        int slow2 = 0;
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}