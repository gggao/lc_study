import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    
    class Num {
        int val;
        int index;
        public Num(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    class NumCom implements Comparator<Num> {
        public int compare(Num a, Num b) {
            if (a.val > b.val) {
                return 1;
            } else if (a.val == b.val) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    
    public int[] twoSum(int[] nums, int target) {
        List<Num> nl = new ArrayList<>();
        for (int ind = 0; ind < nums.length; ind++) {
            nl.add(new Num(nums[ind], ind));
        }
        Collections.sort(nl, new NumCom());
        int i = 0;
        int j = 0;
        for (; i< nums.length-1; i++) {
            int want = target - nl.get(i).val;
            j = i+1;
            for (; j< nums.length; j++) {
                if (nl.get(j).val >= want) {
                    break;
                }
            }
            if (j < nums.length && nl.get(j).val == want) {
                break;
            }
        }
        return new int[] {nl.get(i).index,nl.get(j).index};
    }
}