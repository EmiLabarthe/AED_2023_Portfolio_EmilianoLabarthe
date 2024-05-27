/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Leetcode100;

import com.mycompany.commonTreeNode.TreeNode;

/**
 *
 * @author emili
 */
public class Leetcode100_Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            if(root.left != null){
                invertTree(root.left);
            }if(root.right != null){
                invertTree(root.right);
            }
        }
        return root;
    }
}
