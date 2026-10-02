class Solution {
    public List<String> generateParenthesis(int n) {
        int lCnt = n;
        int rCnt = n;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        solve(list,lCnt,rCnt,2*n,sb);
        return list;
    }

    public void solve(List<String> list,int lCnt,int rCnt,int len, StringBuilder sb){
        if(sb.length() == len){
            list.add(sb.toString());
            return;
        }

        if(lCnt == rCnt ){
            solve(list,lCnt-1,rCnt,len,sb.append("("));
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            if(lCnt > 0){
                solve(list,lCnt-1,rCnt,len,sb.append("("));
                sb.deleteCharAt(sb.length()-1);
            }
            if(rCnt > lCnt){
                solve(list,lCnt,rCnt-1,len,sb.append(")"));
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}