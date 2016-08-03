package LeetCode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by v-zhoguo on 8/2/2016.
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (n == 0){
            return res;
        }
        res = generate(1, n);
        return res;
    }

    private List<TreeNode> generate(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();

        if (start>end){
            res.add(null);
            return res;
        }
        if (start == end){
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }
        for (int rootValue = start; rootValue<=end; rootValue++){
            List<TreeNode> leftTrees = generate(start, rootValue-1);
            List<TreeNode> rightTrees = generate(rootValue+1, end);
            for (TreeNode leftTree : leftTrees){
                for (TreeNode rightTree : rightTrees){
                    TreeNode root = new TreeNode(rootValue);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
