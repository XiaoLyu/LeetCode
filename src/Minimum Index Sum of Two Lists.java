/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.
*/

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
       List<String> name = new ArrayList<String>();
        
        Map<String, int[]> map = new HashMap<String, int[]>();
        
        for(int i = 0; i < list1.length; i++){
        	int[] temp = {1, i};
        	map.put(list1[i], temp);
        }
        
        int indexSum = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++){
        	if(map.containsKey(list2[i])){
        		int[] temp = {2, map.get(list2[i])[1] + i};
        		name.add(list2[i]);
        		map.put(list2[i], temp);
        		indexSum = Math.min(indexSum, temp[1]);
        	}
        }
        
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < name.size(); i++){
        	String t = name.get(i);
        	if(map.get(t)[1] == indexSum){
        		result.add(t);
        	}
        }
        return result.toArray(new String[0]);
    }
}
