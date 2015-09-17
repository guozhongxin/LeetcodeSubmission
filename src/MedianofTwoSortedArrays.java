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
		if (tag ==0){
			m1 = Math.round((nums1Longth + nums2Longth)/2);
			m2 = m1 + 1;
		}else {
			m1 = Math.round((nums1Longth + nums2Longth)/2)+1;
			m2=m1;

		}

		int p1=0,p2 = 0;
//		int median1, median2=0;
		int newNums[] = new int[m2];

		for (int i = 0; i < m2; i++){
			if (p1==nums1Longth){
				p2 += m1-1-i;
				newNums[m1-tag] = nums2[p2+(1-tag)];
				newNums[m1-1] = nums2[p2];
				break;
			}
			if (p2==nums2Longth){
				p1 += m1-1-i;
				newNums[m1+(1-tag)] = nums2[p2+ (1-tag)];
				newNums[m1] = nums2[p1];
				break;
			}
			if (nums1[p1] > nums2[p2] ){
				newNums[i] = nums2[p2];
				p2++;
			}else {
				newNums[i] = nums2[p1];
				p1++;
			}
		}



		return (newNums[m1-1]+newNums[m2-1])/2;
	}

	public static void main(String[] args) {
		int nums1[] = new int[0];
		int nums2[] = new int[1];
		nums2[0] = 1;
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
