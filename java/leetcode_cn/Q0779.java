package leetcode_cn;

/**
 * Created by Administrator on 2020/9/3.
 */
public class Q0779 {
    /*
    * recursion version
    * */
    public int kthGrammar(int N, int K) {
        if (N <= 1) return 0;
        int d = (K + 1) % 2; // direction : left(0)/right(1)
        int p = kthGrammar(N - 1, (K + 1) / 2); // parent value 0/1
        return d ^ p;
    }

    public static void main(String[] args) {
        Q0779 o = new Q0779();
        int N = 1;
        int K = 1;
        int res = 0;
        String sf = "[%d\t,%d\t]=>\t%d";

        N = 1;
        K = 1;
        res = o.kthGrammar(N, K);
        System.out.println("N:" + N + " , K:" + K + "> " + res);


        N = 2;
        K = 1;
        res = o.kthGrammar(N, K);
        System.out.println("N:" + N + " , K:" + K + "> " + res);

        N = 2;
        K = 2;
        res = o.kthGrammar(N, K);
        System.out.println("N:" + N + " , K:" + K + "> " + res);

        N = 4;
        K = 5;
        res = o.kthGrammar(N, K);
        System.out.println("N:" + N + " , K:" + K + "> " + res);

        N = 4;
        K = 1;
        res = o.kthGrammar(N, K);
        System.out.println("N:" + N + " , K:" + K + "> " + res);

        for(int i=1;i<=8;i++){
            N = 4;
            K = i;
            res = o.kthGrammar(N, K);
            System.out.println("N:" + N + " , K:" + K + "> " + res);

        }
    }


}

/*
* 0
* 01
* 0110
* 01101001
*
* */
// 其实每一层的数字已经确定！！！但是无法知晓
/*
* solution 1
* 结果为0或1
* 他们之间存在映射关系
* 每一层共 2^(N-1)个节点，
* 当小于等于2^(N-2)时在左节点，如果父节点是0则为0，父节点为1则为1；
* 当大于   2^(N-2)时在左节点，如果父节点是0则为1，父节点为1则为0；
* */

/*
* 异或
* ^|0 1
* -----
* 0|0 1
* 1|1 0
* */
