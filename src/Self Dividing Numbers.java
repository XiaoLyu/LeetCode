/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.
*/

/*
 * % 出来的数有正有负，符号取决于左操作数
 * mod 只能是正
 * a mod b = (a % b + b) % b
 */

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        
        for(int current = left; current < (right + 1); current++){
            //如果current能被每个数整除，加入result
        	int c = current;
        	while(c != 0){
        		int div = c % 10;
        		if(div == 0 || current % div != 0){
        			break;
        		}
        		c = c/10;
        	}
        	if(c == 0){
        		result.add(current);
        	}
        }
        return result;
	}
}
