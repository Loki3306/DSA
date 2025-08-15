class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        int index=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(index)){
                    if(backtrack(board,word,i,j,n,m,index)) return true;
                } 
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board,String word,int i,int j,int n,int m,int index){
        if(index == word.length()) return true;

        if(i < 0 || j<0 || i==n || j==m || board[i][j] != word.charAt(index) || board[i][j] == '!' ) return false;

        char ch=board[i][j];
        board[i][j]='!';

        boolean top= backtrack(board,word,i-1,j,n,m,index+1);
        boolean bottom= backtrack(board,word,i+1,j,n,m,index+1);
        boolean right= backtrack(board,word,i,j+1,n,m,index+1);
        boolean left= backtrack(board,word,i,j-1,n,m,index+1);

        board[i][j]=ch;

        return top||right||bottom||left;
    }
}