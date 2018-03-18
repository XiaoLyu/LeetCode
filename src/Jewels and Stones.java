/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
*/

/*
 * Set代表集合元素无序，集合元素不可重复的集合
 * Map代表一种由多个key-value组成的集合,key不能重复，没有顺序
 * HashMap和Hashtable都实现了Map接口，不同在于HashMap是非synchronized的，可以接受null，而Hashtable则不行
 * HashSet实现了Set接口，它不允许集合中有重复的值，HashMap实现了Map接口，Map接口对键值对进行映射
 * HashSet拓展了HashMap，所以底层还是用到map存储，存储实现同map一致，HashMap存储键值，HashSet存储对象
 */

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set set = new HashSet();
		int result = 0;
		for(char j: J.toCharArray()){
			set.add(j);
		}
		for(char s: S.toCharArray()){
			if(set.contains(s)){
				result++;
			}
		}
		return result;
	}
}
