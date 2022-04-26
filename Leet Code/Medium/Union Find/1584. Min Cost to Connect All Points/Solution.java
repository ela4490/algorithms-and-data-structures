/* You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi]. The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val. Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

Example 1:
Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 
We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.

Example 2:
Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18

Constraints:
1 <= points.length <= 1000
-10^6 <= xi, yi <= 10^6
All pairs (xi, yi) are distinct.

Link: https://leetcode.com/problems/min-cost-to-connect-all-points/ */

class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[2] - b[2]));
        Set<Integer> visited = new HashSet<>();
        int totalCost = 0;
        int num = points.length;
        
        pq.offer(new int[]{0, 0, 0});
        
        while(!pq.isEmpty() && visited.size() < num) {
            int[] current = pq.poll();
            int endId = current[1];
            int cost = current[2];
            
            if(visited.contains(current[1])) continue;
            
            totalCost += cost;
            visited.add(endId);
            
            for(int i = 0; i < num; i++) {
                if(!visited.contains(i)) {
                    pq.offer(new int[]{endId, i, distance(points, endId, i)});
                }
            }
        }
        
        return totalCost;
    }
    
    private int distance(int points[][], int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}