package leetcode;

/**
 * 
 * @author Lu HaiTao
 * @time 2019-09-24 15:31
 * @version 1.0
 */

public class Q0011M02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q0011M02 q = new Q0011M02();
		System.out.println(q.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

	//
	public int maxArea(int[] height) {
		if (height == null || height.length <= 1)
			return 0;
		int r = 0;
		int i = 0;
		int j = height.length - 1;
		while (i < j) {
			int h = Math.min(height[i], height[j]) + 1;
			r = Math.max(r, (h - 1) * (j - i));
			while (i < j && height[i] < h) {i++;}
			while (i < j && height[j] < h) {j--;}
		}
		return r;
	}

	//

}
