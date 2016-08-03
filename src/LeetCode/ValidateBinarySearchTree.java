package LeetCode;

import utils.TreeNode;

/**
 * Created by v-zhoguo on 8/3/2016.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean leftvalid = true;
        if (root.left != null){
            if (root.val > root.left.val ){

                TreeNode rightmost = root.left;
                while (rightmost.right!=null){
                    rightmost = rightmost.right;
                }
                if (rightmost.val > root.val){
                    return false;
                }
                leftvalid = isValidBST(root.left);
            }else{
                return false;
            }
        }
        boolean rightvalid=true;
        if (root.right !=null){
            if (root.val < root.right.val){
                TreeNode leftmost = root.right;
                while (leftmost.left !=null){
                    leftmost = leftmost.left;
                }
                if (leftmost.val < root.val){
                    return false;
                }
                rightvalid = isValidBST(root.right);

            }else{
                return false;
            }
        }
        return (leftvalid && rightvalid);
    }
}
