package leetcode;

/**
 * 
 * @author Lu HaiTao
 * @time 2019-09-24 09:43
 * @version 1.0
 */

public class Q0005M04_ManacherAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q0005M04_ManacherAlgorithm q = new Q0005M04_ManacherAlgorithm();
		System.out.println(q.manacher("babad"));
		System.out.println(q.manacher("cbbd"));
		System.out.println(q.manacher("123456789"));
		System.out.println(q.manacher("ac"));
		System.out.println(q.manacher("1"));
		System.out.println(q.manacher(""));
		System.out.println(q.manacher("aaaaaaaaaaaa"));
	}

	// 相较于M03中使用StringBuffer使用数组更节省时间和内存
	public String manacher(String s) {
		if (s == null || s.length() <= 1)
			return s;

		char[] ch = new char[s.length() * 2 + 3];
		int k = 0;
		ch[k++] = '$';
		for (int i = 0; i < s.length(); i++) {
			ch[k++] = '#';
			ch[k++] = s.charAt(i);
		}
		ch[k++] = '#';
		ch[k++] = '*';

		// System.out.println(res);
		int[] p = new int[ch.length];
		p[0] = 1;
		p[1] = 1;
		int mi = 1; // 最大回文的中心
		int maxLen = 1; // 最大回文长度
		int maxPoint = 1; // maxLen = p[maxPoint]
		int right = 2; // 可到达的最右端

		for (int i = 2; i < ch.length - 1; i++) {
			// p[i] = right > i ? Math.min(p[2 * mi - i], right - i) : 1;
			p[i] = right > i ? (p[2 * mi - i] <= (right - i) ? p[2 * mi - i] : (right - i)) : 1;

			while (ch[i + p[i]] == ch[i - p[i]])
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
		// System.out.println(idxS + " , " + idxE);
		return s.substring(idxS, idxE);
	}

}
