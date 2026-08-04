class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,0,path,res);
        return res;
    }
    public void dfs(int[] candidates, int target, int starindex, int sum, List<Integer> path, List<List<Integer>> res){
        if(sum == target)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        if(sum > target){
            return ;
        }
        for(int i = starindex; i < candidates.length; i++){
            if(i > starindex && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates,target,i+1,sum + candidates[i],path,res);
            path.remove(path.size() - 1);
        }
    }

}
