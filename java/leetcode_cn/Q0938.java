package leetcode_cn;


/**
 * Created by Administrator on 2020/9/4.
 */
public class Q0938 {

    /*
    * version:1.0
    * 能继续优化
    * */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int sum = 0;
        if (root.val >= L && root.val <= R)
            sum += root.val;
        return sum + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    public static void main(String[] args) {
        Q0938 o = new Q0938();
        TreeNode node1 = new TreeNode(10);
        TreeNode node1L = new TreeNode(5);
        TreeNode node1R = new TreeNode(15);
        TreeNode node1LL = new TreeNode(3);
        TreeNode node1LR = new TreeNode(7);
        TreeNode node1RR = new TreeNode(18);

        node1.left = node1L; // 5
        node1.right = node1R; // 10
        node1L.left = node1LL; // 3
        node1L.right = node1LR;  // 7
        node1R.right = node1RR; // 18

        int res = o.rangeSumBST(node1, 7, 15);
        System.out.println(res);


    }
}
