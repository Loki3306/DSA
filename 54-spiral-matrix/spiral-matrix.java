class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        ArrayList<Integer> List = new ArrayList<>();

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                List.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                List.add(matrix[i][right]);
            }
            right--;

            if(top<=bottom){
            for (int i = right; i >= left; i--) {
                List.add(matrix[bottom][i]);
            }
            bottom--;
        }

            if(left<=right){
            for (int i = bottom; i >= top; i--) {
                List.add(matrix[i][left]);
            }
            left++;
            }

        }

        return List;
    }
}