package leetcode;

/**
 * 
 * @author Lu HaiTao
 * @time 2019-09-24 09:43
 * @version 1.0
 */

// Manacher Algorithm O(n)

public class Q0005M03_ManacherAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q0005M03_ManacherAlgorithm q = new Q0005M03_ManacherAlgorithm();
		System.out.println(q.manacher("babad"));
		System.out.println(q.manacher("cbbd"));
		System.out.println(q.manacher("123456789"));
		System.out.println(q.manacher("ac"));

		System.out.println(q.manacher("1"));
		System.out.println(q.manacher(""));
		System.out.println(q.manacher("aaaaaaaaaaaa"));
	}

	public String manacher(String s) {
		if (s == null || s.length() <= 1)
			return s;

		StringBuffer sb = new StringBuffer("$#");
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i) + "#");
		}
		sb.append("*");
		String res = sb.toString();
		//System.out.println(res);
		int[] p = new int[res.length()];
		p[0] = 1;
		p[1] = 1;

		int mi = 1; // 最大回文的中心
		int maxLen = 1; // 最大回文长度
		int maxPoint = 1;
		int right = 2; // 可到达的最右端

		for (int i = 2; i < res.length() - 1; i++) {
			if (right > i) {
				int j = 2 * mi - i;
				p[i] = Math.min(p[j], right - i);
			} else {
				p[i] = 1; // self length is 1
			}
			while (res.charAt(i + p[i]) == res.charAt(i - p[i]))
				p[i]++;

			if (i + p[i] > right) {
				right = i + p[i];
				mi = i;
			}
			if (p[i] > maxLen) {
				maxLen = p[i];
				maxPoint = i;
			}
		}

		int idxS = (maxPoint - maxLen + 1) / 2;
		int idxE = idxS + maxLen - 1;
		//System.out.println(idxS + " , " + idxE);
		return s.substring(idxS, idxE);
	}

}
