class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, path, ans);
        return ans;
    }

    // 枚举选哪个：在下标 i 到 n-1 中选一个数，加到 path 末尾
    private void dfs(int i, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path)); // 不选，把当前子集加入答案
        for (int j = i; j < nums.length; j++) { // 选，枚举选择的数字
            path.add(nums[j]);
            dfs(j + 1, nums, path, ans); // 选 nums[j] 意味着 i 到 j-1 都跳过不选，下一个数从 j+1 开始选
            path.removeLast(); // path.remove(path.size() - 1);
        }
    }
}

