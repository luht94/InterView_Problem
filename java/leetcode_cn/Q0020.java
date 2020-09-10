package leetcode_cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Lu ht
 * @Date: 2020/9/10 15:39
 * @version: 1.0
 */
// #Stack
// #栈

public class Q0020 {


    // from leetcode-cn
    // 使用index = 1 非常有用,因为index == 0 时一定是会返回错误的
    // 虽然空间占用的大了点,但是排除了较多错误用例
    public boolean isValid(String s) {
        char[] ch = new char[s.length() + 1];
        int index = 1;
        for (char temp : s.toCharArray()) {
            if (temp == '(' || temp == '[' || temp == '{')
                ch[index++] = temp;
            else {
                index--;
                if (temp == ')' && ch[index] != '(') return false;
                if (temp == ']' && ch[index] != '[') return false;
                if (temp == '}' && ch[index] != '{') return false;
            }
        }
        return index == 1;
    }





    public static void main(String[] args) {
        Q0020 o = new Q0020();
        boolean res = false;
        String str = "";

        str = "()";
        res = o.isValid(str);
        System.out.println(str + " : " + res);

        str = "({[]})";
        res = o.isValid(str);
        System.out.println(str + " : " + res);

        str = "()[]{}";
        res = o.isValid(str);
        System.out.println(str + " : " + res);

        str = "(]";
        res = o.isValid(str);
        System.out.println(str + " : " + res);

        str = "([)]";
        res = o.isValid(str);
        System.out.println(str + " : " + res);

        // 空字符
        str = "";
        res = o.isValid(str);
        System.out.println(str + " : " + res);

        // 只有结束符号
        str = "]";
        res = o.isValid(str);
        System.out.println(str + " : " + res);

        // 只有结束符号
        str = "]]]]]";
        res = o.isValid(str);
        System.out.println(str + " : " + res);

        // 只有起始符号
        str = "(";
        res = o.isValid(str);
        System.out.println(str + " : " + res);

        // 只有起始符号
        str = "((";
        res = o.isValid(str);
        System.out.println(str + " : " + res);

        // 只有起始符号
        str = "(()}";
        res = o.isValid(str);
        System.out.println(str + " : " + res);
    }

    /*
    // version 1.2
    // 执行用时：1 ms, 在所有 Java 提交中击败了98.58% 的用户
    // 内存消耗：37.4 MB, 在所有 Java 提交中击败了95.47% 的用户
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;
        int n = s.length();
        if (n % 2 != 0) return false;
        char[] cs = new char[n / 2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                if (k >= n / 2) return false; // 左符号较多
                cs[k++] = c;
            } else {
                if (k <= 0) return false; // 右括号较多
                char pre = cs[--k];
                if (!isMatch(pre, c)) return false;
            }
        }
        return k == 0;

    }

    public boolean isMatch(char c1, char c2) {
        if (c1 == '(' && c2 == ')')
            return true;
        if (c1 == '[' && c2 == ']')
            return true;
        if (c1 == '{' && c2 == '}')
            return true;
        return false;
    }

*/

/*
    //
    // version 1.0
    // 执行用时：2 ms, 在所有 Java 提交中击败了78.10% 的用户
    // 内存消耗：37.8 MB, 在所有 Java 提交中击败了42.98% 的用户
    //
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 直接遇到 右侧符号
                if (stack.isEmpty()) return false;
                char pre = stack.pop();
                if (!isMatch(pre, c)) {
                    return false;
                }
            }
        }
        // 只有左侧符号时是错误
        return stack.isEmpty();
    }

    public boolean isMatch(char c1, char c2) {
        if (c1 == '(' && c2 == ')')
            return true;
        if (c1 == '[' && c2 == ']')
            return true;
        if (c1 == '{' && c2 == '}')
            return true;
        return false;
    }

    */
}
