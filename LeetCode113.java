import java.util.ArrayList;
import java.util.List;

/**
 * Created by uagrawal on 11/26/16.
 */
public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return null;
        return helper(root, sum);
    }

    public List<List<Integer>> helper(TreeNode root, int sum) {
        if (root == null) return null;
        if (root.left == null && root.right == null && root.val-sum == 0) {
            List<Integer> path = new ArrayList<Integer>();
            path.add(root.val);
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(path);
            return result;
        } else {
            List<List<Integer>> leftPath = helper(root.left, sum - root.val);
            List<List<Integer>> rightPath = helper(root.right, sum - root.val);
            List<List<Integer>> finalResult = null;
            if (leftPath!= null) {
                finalResult = new ArrayList<List<Integer>>();
                for (List lst: leftPath) {
                    lst.add(root.val);
                }

                for (List lst : leftPath) {
                    finalResult.add(new ArrayList<Integer>(lst));
                }
            }

            if (rightPath != null) {
                if (finalResult == null) finalResult = new ArrayList<List<Integer>>();
                for (List lst : rightPath) {
                    lst.add(root.val);
                }

                for (List lst : rightPath) {
                    finalResult.add(new ArrayList<Integer>(lst));
                }
            }

            return finalResult;
        }
    }

}
