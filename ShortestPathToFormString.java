// Time Complexity : O(m+nlog k) ehre k = average number of occurences of a character in source string
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : maintain a hashmap for each character and list of it's indexes. Maintain 2 pointers at the beginning of 
/// both strings. For each character in target string, get the index of the that character after p1 from map, if there's no char ch after p1,
/// get it's first occurence and increment count.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        String src = "abc";
        String target = "abcac";
        int m = src.length(), n = target.length();
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<m;i++){
            char ch = src.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }
        int p1 = 0, p2 = 0, count = 1;
        while(p2<n){
            char ch = target.charAt(p2);
            if(!map.containsKey(ch)){
                System.out.println(-1);
                return;
            }
            int k = Collections.binarySearch(map.get(ch), p1);
            System.out.println("searching for "+ch+" = "+k);
            if(k<0){
                k=-k-1;
            }
            if(k==map.get(ch).size()){
                p1 = map.get(ch).get(0);
                count++;
            }
            else{
                p1 = map.get(ch).get(k);
            }
            p1++;
            p2++;
        }
        System.out.println(count);
    }
}