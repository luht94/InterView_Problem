package leetcode_cn;

/**
 * Created by Administrator on 2020/9/7.
 */
public class Q0009 {

/*
    // version 1 : convert to String
    //
    //* leetcode-cn
    //* 执行用时：10 ms, 在所有 Java 提交中击败了66.78% 的用户
    //* 内存消耗：38.9 MB, 在所有 Java 提交中击败了92.03% 的用户
    //*
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
*/

    /*
        // version 2 : using array(max int is 2147483647 ,仅10位)
        // leetcode-cn.com
        // 执行用时：9 ms, 在所有 Java 提交中击败了98.87% 的用户
        // 内存消耗：39.1 MB, 在所有 Java 提交中击败了60.06% 的用户
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            int[] numb = new int[10]; // int 最大为10位
            int k = 0;
            while (x > 0) {
                numb[k++] = x % 10;
                x /= 10;
            }
            int i = 0;
            int j = k - 1;
            while (i < k) {
                if (numb[i++] != numb[j--]) return false;
            }
            return true;
        }
    */
    /*
    // (再优化,已知提交的最优版本为6ms)
    // version 3 : 暂时未想到优化方案
    // commit : leetcode-cn.com
    // 执行用时：11 ms, 在所有 Java 提交中击败了40.86% 的用户(使用byte反而降低了性能,why?)
    // 内存消耗：39.3 MB, 在所有 Java 提交中击败了32.24% 的用户
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        byte[] numb = new byte[10]; // int 最大为10位,使用byte只是权宜的方案
        int k = 0;
        for (; x > 0; x /= 10, k++) {
            numb[k] = (byte) (x % 10);
        }
        k--;
        for (int i = 0; i < k; i++, k--) {
            if (numb[i] != numb[k]) return false;
        }
        return true;
    }
    */

    // from leetcode-cn
    // 这种方案可行,尽管会有溢出,但是并不影响结果
    // 进过测试所有整数值,这种方案可行
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int rev = 0;
        int y= x;
        while (y != 0) {
            rev = rev*10 + y%10;
            y /= 10;
        }
        return rev == x;

    }


    public static void main(String[] args) {
        Q0009 o = new Q0009();

        boolean res = false;
        int x = 0;

        x = 101;
        res = o.isPalindrome(x);
        System.out.println(x + " : " + res);

        x = -101;
        res = o.isPalindrome(x);
        System.out.println(x + " : " + res);

        x = 0;
        res = o.isPalindrome(x);
        System.out.println(x + " : " + res);

        x = Integer.MAX_VALUE;
        res = o.isPalindrome(x);
        System.out.println(x + " : " + res);
    }
}
