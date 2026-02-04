class Solution{

public int index=0;
public HashMap<Integer,Integer> map=new HashMap<>();

public TreeNode buildTree(int[] preorder,int[] inorder){

for(int i=0;i<inorder.length;i++){
map.put(inorder[i],i);
}

return construct(preorder,inorder,0,inorder.length-1);
}

public TreeNode construct(int[] preorder,int[] inorder,int s,int e){

if(s>e){
return null;
}

TreeNode root=new TreeNode(preorder[index]);
index++;

int position=map.get(root.val);

root.left=construct(preorder,inorder,s,position-1);
root.right=construct(preorder,inorder,position+1,e);

return root;
}
}
