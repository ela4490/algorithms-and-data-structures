/* Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order. An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

Constraints:
1 <= k <= arr.length
1 <= arr.length <= 10^4
arr is sorted in ascending order.
-10^4 <= arr[i], x <= 10^4

Link: https://leetcode.com/problems/find-k-closest-elements/ */

// Time Complexity : O(N)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;
        
        while(high - low >= k) {
            if(Math.abs(arr[low] - x) > Math.abs(arr[high] - x)) {
                low++;
            } else {
                high--;
            }
        }
        
        for(int i = low; i <= high; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}

class Solution {
    public static class Pair implements Comparable<Pair>{
        int gap;
        int val;
        Pair(int val, int gap){
            this.gap = gap;
            this.val = val;
        }
        public int compareTo(Pair o){
            if(this.gap==o.gap){
                return this.val - o.val;
            }else{
                return this.gap - o.gap;
            }
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<arr.length; i++){
            if(k > pq.size()){
                pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
            }else{
                if(pq.peek().gap > Math.abs(arr[i] - x)){
                    pq.remove();
                    pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
                }
            }
        }
        while(pq.size()>0){
            Pair rem = pq.remove();
            list.add(rem.val);
        }
        Collections.sort(list);
        return list;
    }
}