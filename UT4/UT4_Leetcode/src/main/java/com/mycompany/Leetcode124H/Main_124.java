/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.Leetcode124H;

import com.mycompany.commonTreeNode.TreeNode;

/**
 *
 * @author emili
 */
public class Main_124 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeNode nodo7 = new TreeNode(7);
        TreeNode nodo9 = new TreeNode(9);
        TreeNode nodo15 = new TreeNode(15);
        TreeNode nodo20 = new TreeNode(20, nodo15, nodo7);
        TreeNode nodo10 = new TreeNode(-10, nodo9, nodo20);
        
        Solution_124 solutionInstance = new Solution_124();
        System.out.println(solutionInstance.maxPathSum(nodo10));
    }
    
}
