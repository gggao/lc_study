/**
 * 【start, end】区间向前移动，
 * 空字符串和非空时的res的默认值需要处理
 */
class Solution {
    int checkDup(String s, int b, int e, char t) {
        int i = b;
        while (i <= e) {
            if(s.charAt(i) == t) {
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 1;
        int tmp = 0;
        int res = s == null || s.length() == 0 ? 0 : 1;
        for (; end < s.length(); end++) {
            int check = checkDup(s, start, end-1, s.charAt(end));
            if (check == -1) {
                if (end - start +1 > res) {
                    res = end - start +1;
                }
                continue;
            } else {
                start = check +1;
            }
                
        }
        return res;
    }
}