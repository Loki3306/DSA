class Solution {
    public boolean judgePoint24(int[] cards) {
        double[] nums=new double[cards.length];
        for(int i=0;i<cards.length;i++){
            nums[i]=cards[i];
        }
        return backtrack(nums);
    }

    public boolean backtrack(double[] nums){
        if(nums.length == 1){
            return (Math.abs(nums[0] - 24) < 1e-6);
        }

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    double[] newArr=new double[nums.length-1];
                    int idx=0;
                    for(int k=0;k<nums.length;k++){
                        if(k!=i && k!=j) newArr[idx++]=nums[k];
                    }

                    for(double val: compute(nums[i],nums[j])){
                        newArr[idx]=val;
                        if(backtrack(newArr)) return true;
                    }
                }
            }
        }

        return false;
    }




    public double[] compute(double a,double b){
        return new double[]{
            a+b,
            a-b,
            b-a,
            a*b,
            a!=0 ? b/a: Double.NaN,
            b!=0 ? a/b: Double.NaN
        };
    }
}