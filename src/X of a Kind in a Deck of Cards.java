/*
In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.
 

Example 1:

Input: [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
Example 2:

Input: [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.
Example 3:

Input: [1]
Output: false
Explanation: No possible partition.
Example 4:

Input: [1,1]
Output: true
Explanation: Possible partition [1,1]
Example 5:

Input: [1,1,2,2,2,2]
Output: true
Explanation: Possible partition [1,1],[2,2],[2,2]

Note:

1 <= deck.length <= 10000
0 <= deck[i] < 10000
*/

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : deck){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }
            else{
                map.put(i, 1);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(Integer i : map.values()){
            list.add(i);
            if(i < min){
                min = i;
            }
        }
        
        return gcd(list, min);
    }
    
    public boolean gcd(List<Integer> list, int min){
        boolean result = false;
        for(int i = 2; i <= min; ++i){
            int k = 0;
            for(int j = 0; j < list.size(); ++j){
                if(list.get(j) % i != 0) break;
                k++;
            }
           if(k == list.size()){
            	result = true;
            	break;
            }
        }
        return result;
    }
}
