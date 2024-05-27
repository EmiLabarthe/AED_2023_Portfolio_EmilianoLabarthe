/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Leetcode100;

import com.mycompany.commonTreeNode.TreeNode;

/**
 *
 * @author emili
 */
public class Leetcode100_main {

    public static void main(String[] args) {
        TreeNode nodo7 = new TreeNode(7);
        TreeNode nodo9 = new TreeNode(9);
        TreeNode nodo15 = new TreeNode(15);
        TreeNode nodo20 = new TreeNode(20, nodo15, nodo7);
        TreeNode nodo10 = new TreeNode(-10, nodo9, nodo20);
        
        Leetcode100_Solution solutionInstance = new Leetcode100_Solution();
        
        System.out.println(nodo10.left.val);
        solutionInstance.invertTree(nodo10);
        System.out.println(nodo10.left.val);
    }
}
