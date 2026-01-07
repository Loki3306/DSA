import java.util.*;

class Solution {
public int maxProduct(TreeNode root) {
List<Long> list = new ArrayList<>();
long total = collect(root, list);
long max = 0;

for(long sub : list){
long prod = sub * (total - sub);
if(prod > max) max = prod;
}

return (int)(max % 1000000007);
}

public long collect(TreeNode root, List<Long> list){
if(root == null) return 0;

long left = collect(root.left, list);
long right = collect(root.right, list);

long sum = root.val + left + right;
list.add(sum);

return sum;
}
}
