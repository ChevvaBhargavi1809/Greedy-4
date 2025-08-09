// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : if there is a possible value, then it should be in both array's same columns. Let's check first column,
/// check if tops[0] or bottoms[0] is in either (or both ) of the columns in both arrays, if yes return it else return -1
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops, bottoms, tops[0]);
        if(result != -1){
            return result;
        }
        return check(tops, bottoms, bottoms[0]);
    }
    private int check(int tops[], int bottoms[], int target){
        int t = 0, b = 0;
        int n = tops.length;
        for(int i=0;i<n;i++){
            if(tops[i] != target && bottoms[i] != target){
                return -1;
            }
            if(tops[i] == target){
                t++;
            }
            if(bottoms[i] == target){
                b++;
            }
        }
        return Math.min(n-t, n-b);
    }
}