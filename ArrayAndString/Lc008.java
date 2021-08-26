/**
 *
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/conm7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */

public class Lc008 {
    public String longestPalindrome(String s) {
        //子串长度
        for(int len = s.length();len>0;len--){
            for(int idx = 0;idx<=s.length()-len;idx++){
                //判断回文串
                if(isPalindrome(s,idx,idx+len-1)){
                    //截取字符串并返回
                    return s.substring(idx,idx+len);
                }
            }
        }
        return "";
    }

    public boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "babad";

        //测试
        Lc008 lc008 = new Lc008();
        String result = lc008.longestPalindrome(s);
        System.out.println("字符串中的最长回文字符串是:"+result);
    }
}
