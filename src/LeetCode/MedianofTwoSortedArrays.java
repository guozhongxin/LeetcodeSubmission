package LeetCode;

/**
 * Created by guozhongxin on 15/9/14.
 */
public class MedianofTwoSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1Longth = nums1.length;
		int nums2Longth = nums2.length;
		int m1,m2=0;
		int tag = (nums1Longth+nums2Longth)%2;

		m2 = Math.round((nums1Longth + nums2Longth)/2)+1;

		int p1 = 0, p2 = 0;

		int medianNumber1 = 0;
		int medianNumber2 =0;

		for (int i = 0; i < m2-1+tag; i++){
			if (p1==nums1Longth) {
				p2 += m2-2+tag-i;
				medianNumber2 = nums2[p2];
				break;
			} else if (p2==nums2Longth){
				p1 += m2-2+tag-i;
				medianNumber2 = nums1[p1];
				break;
			}else if (nums1[p1] > nums2[p2] ){
				medianNumber2 = nums2[p2];
				p2++;
			}else {
				medianNumber2 = nums1[p1];
				p1++;
			}
		}if (tag ==1){
			return medianNumber2;
		}else {
			if (p1 == nums1Longth) {
				medianNumber1 = medianNumber2;
				if (nums2[p2]> medianNumber1){
					return 0; //ssssssssssssss
				}
				medianNumber2 = nums2[++p2];
			} else if (p2 == nums2Longth) {
				medianNumber1 = medianNumber2;
				medianNumber2 = nums1[++p1];
			} else if (nums1[p1] > nums2[p2]) {
				medianNumber1 = medianNumber2;
				medianNumber2 = nums2[p2];
			} else {
				medianNumber1 = medianNumber2;
				medianNumber2 = nums1[p1];
			}

			return (medianNumber1 + medianNumber2) / 2d;
		}
	}

	public static void main(String[] args) {
		int nums1[] = new int[1];
		int nums2[] = new int[1];
		nums1[0] =5;
		nums2[0] = 1;
//		nums2[1] = 2;
//		nums2[2] = 3;
//		nums2[3] = 4;
//		nums2[4] = 5;

		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
