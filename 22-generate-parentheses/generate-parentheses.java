class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        generate(result,n,0,0,"");
        return result;
    }

    public void generate(List<String> list,int max, int op,int cl, String result){
        if(result.length() == 2*max){
            list.add(result);
            return;
        }

        if(op < max){
            generate(list,max,op+1,cl,result+'(');
        }   

        if(cl < op){
            generate(list,max,op,cl+1,result+')');
        }
    }
}