/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Leetcode124H;

import com.mycompany.commonTreeNode.TreeNode;
import java.util.LinkedList;

/**
 *
 * @author emili
 */
class Solution_124 {
    
    // This exercise is qualified as Hard by Leetcode
    
    int maximum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        traversal(root);
        return maximum;
    }

    public int traversal(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftMaximum = traversal(node.left);
        int rightMaximum = traversal(node.right);
        leftMaximum = Math.max(0, leftMaximum);
        rightMaximum = Math.max(0, rightMaximum);
        maximum = Math.max(maximum, node.val + rightMaximum + leftMaximum);
        return node.val + Math.max(leftMaximum, rightMaximum);
    }
}
