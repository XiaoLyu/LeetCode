/*
There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
*/

class Solution {
    
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for(int[] edge: times){
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        Map<Integer, Integer> dist = new HashMap();
        boolean[] seen = new boolean[N+1];
        
        for(int i = 1; i <= N; i++){
            dist.put(i, Integer.MAX_VALUE);
        }
        
        dist.put(K, 0);
        
        while(true){
            int curNode = -1;
            int curDist = Integer.MAX_VALUE;
            
            for(int i = 1; i <= N; i++){
                if(!seen[i] && dist.get(i) < curDist){
                    curDist = dist.get(i);
                    curNode = i;
                }
            }
            
            if(curNode == -1) break;
            seen[curNode] = true;
            if(graph.containsKey(curNode))
            {
                for(int[] info: graph.get(curNode)){
                    dist.put(info[0], Math.min(info[1] + dist.get(curNode), dist.get(info[0])));
                }
            }        
        }
        
        int result = 0;
        for(int cand: dist.values()){
            if (cand == Integer.MAX_VALUE){
                return -1;
            }
            else{
                result = Math.max(result, cand);
            }
        }
        return result;
    }
}
