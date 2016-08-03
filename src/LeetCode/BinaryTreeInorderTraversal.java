package LeetCode;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by v-zhoguo on 8/2/2016.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root == null){
            return res;
        }
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode t, List<Integer> list){
        if (t.left != null){
            inorder(t.left, list);
        }
        list.add(t.val);
        if(t.right !=null){
            inorder(t.right, list);
        }
    }
}
