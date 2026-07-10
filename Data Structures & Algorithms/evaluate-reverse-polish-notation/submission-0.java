class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String c : tokens) {
            if(c.equals("+")){
                st.push(st.pop()+st.pop());
            }else if(c.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            }else if(c.equals("*")){
                st.push(st.pop() * st.pop());
            }else if(c.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            }
            else{
                st.push(Integer.parseInt(c));
            }
        }
        return st.pop();
    }
}
