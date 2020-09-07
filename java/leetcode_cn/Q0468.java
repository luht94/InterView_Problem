package leetcode_cn;

/**
 * Created by Administrator on 2020/9/4.
 */
public class Q0468 {

    public String validIPAddress(String IP) {
        String res = "Neither";
        if (IP.contains(".") && isIPV4(IP)) {
            res = "IPv4";
        }
        if (IP.contains(":") && isIPV6(IP)) {
            res = "IPv6";
        }
        return res;
    }

    public boolean isIPV4(String IP) {
        if (IP == null || IP.charAt(0) == '.' || IP.endsWith(".")) return false;
        String[] ipp = IP.split("\\.");
        if (ipp.length != 4) return false;
        for (String s : ipp) {
            //
            if (s == null || s.isEmpty() || s.length() > 3) return false;
            if (s.charAt(0) == '0' && s.length() != 1) return false;
            if (!s.matches("\\d{1,3}")) return false;
            if (Integer.parseInt(s) >= 256) return false;
        }
        return true;
    }


    public boolean isIPV6(String IP) {
        if (IP == null || IP.charAt(0) == ':' || IP.endsWith(":")) return false;
        String[] ipp = IP.split(":");
        if (ipp.length != 8) return false;
        for (String s : ipp) {
            if (s == null || s.isEmpty() || s.length() > 4) return false;
            if(!s.matches("[\\dabcdefABCDEF]{1,4}")) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Q0468 o = new Q0468();

        String str1 = "192.168.0.255";
        System.out.println(o.validIPAddress(str1));

        str1 = "1e1.4.5.6";
        System.out.println(o.validIPAddress(str1));


        String str2 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(o.validIPAddress(str2));

        String str4 = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";
        System.out.println(o.validIPAddress(str4));


//        String str3 = "256.256.256.256";
//        System.out.println(o.validIPAddress(str3));
    }
}


/*
* 题目描述比较模糊，要注意的测试用例：
* 1. 末尾有。：等
* 2. IPv4中有字母等
* 3. IPv6中有大于F的字母（G,H,...）
*
* */