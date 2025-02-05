// TC: O(N)
// SC: O(N)
// where N is the number of nodes in the tree

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LC515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while(size>0){
                TreeNode poppedEle = q.poll();
                max = Math.max(max, poppedEle.val);
                if(poppedEle.left!=null) q.add(poppedEle.left);
                if(poppedEle.right!=null) q.add(poppedEle.right);
                size--;
            }
            ans.add(max);
        }
        return ans;
    }
}