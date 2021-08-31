/**
 * 最长公共前缀
 * 您已有成功提交记录，请确认是否跳过？
 * <p>
 * 跳过即视为本节
 * 已完成
 * <p>
 * <p>
 * 跳过
 * <p>
 * 重新做题
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/array-and-string/ceda1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * add by dinggunayi 20210826
 * 方法1、方法2、方法3学习完成于20210825
 * 方法4未学习
 */

public class Lc007 {
    //方法1:纵向比较
    //1.先假设第一个字符串是公共前缀
    //2.在依次比较第一个元素和后面所有元素各个位置上的字符
    //3.(1)若第一个字符串的长度大于后面元素长度,则直接返回之前符合的公共长度
    //3.(2)若某个位置上的字符不等,也会返回之前符合的公共长度
    //4.全部循环之前则说明第一个字符串是最长公共字符,且长度是最短,则直接返回第一个字符串
    public String longestCommonPrefix(String[] strs) {
        //若字符串数组为空则返回null
        if (strs.length == 0) {
            return null;
        }

        //定义循环比较的次数就是第一个字符串的长度
        int length = strs[0].length();

        //从第一个字符开始遍历
        for (int i = 0; i < length; i++) {
            //依次比较后面各个元素上的字符是否相等
            for (int m = 0; m < strs.length; m++) {
                //若第一个元素的长度大于后面元素的长度或者某个字符不等则退出循环,返回之前比较OK的公共前缀
                //注意:i + 1 > strs[m].length()比较在前,否则数组越界
                if (i + 1 > strs[m].length() || strs[m].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        //若循环比较第一个字符串都符合,则返回第一个字符串
        return strs[0];
    }

    //方法2:横向扫描法
    //1.设置第一个字符串是公共最长前缀
    //2.(1)依次遍历后续字符串,两两比较取公共最长字符串
    //2.(2)重新设置公共最长前缀
    //2.(3)循环中若公共前缀长度为0则返回null
    public String longestCommonPrefix2(String[] strs) {
        //若字符串数组为空则返回null
        if (strs.length == 0) {
            return null;
        }

        //设置第一个字符串是公共最长前缀
        String strPubHead = strs[0];

        //遍历字符串数组
        for (int i = 1; i < strs.length; i++) {
            //取两个字符串的最长公共前缀
            strPubHead = getSame(strPubHead, strs[i]);

            //循环中若公共前缀长度为0则返回null
            if (strPubHead.length() == 0) {
                break;
            }
        }
        return strPubHead;
    }

    //方法3:分治法
    //1.重写方法,增加开始和结束索引
    //2.将数组分开求解,分解到最后就是每两个元素求getSame()方法
    public String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) {
            return null;
        } else {
            return longestCommonPrefix3(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix3(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix3(strs, start, mid);
            String lcpRight = longestCommonPrefix3(strs, mid + 1, end);
            return getSame(lcpLeft, lcpRight);
        }
    }


    //依次比较两个字符串各个位置字符,求最长公共前缀
    public String getSame(String str, String str1) {
        int length = Math.min(str.length(), str1.length());
        int index = 0;
        //注意:index<length必须在前,否则数组越界
        while (index < length && str.charAt(index) == str1.charAt(index)) {
            index++;
        }

        return str.substring(0, index);
    }

    public static void main(String[] args) {
        //String[] arrs = {"flower", "flow", "flight"};
        String[] arrs = {"abc999", "abc"};
        //String[] arrs = {"flower"};

        //测试
        Lc007 lc007 = new Lc007();
        System.out.println("纵向比较法求得公共前缀是:" + lc007.longestCommonPrefix(arrs));
        System.out.println("横向比较法求得公共前缀是:" + lc007.longestCommonPrefix2(arrs));
        System.out.println("分治法求得公共前缀是:" + lc007.longestCommonPrefix3(arrs));
    }
}
