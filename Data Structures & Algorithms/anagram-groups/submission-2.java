class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp = new HashMap<>();
        for(String s : strs){
            char[] schar = s.toCharArray();
            Arrays.sort(schar);
            String sortedstring = new String(schar);
            mp.putIfAbsent(sortedstring,new ArrayList<>());
            mp.get(sortedstring).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}
