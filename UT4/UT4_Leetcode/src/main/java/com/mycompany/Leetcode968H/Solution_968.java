/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Leetcode968H;

import com.mycompany.commonTreeNode.TreeNode;

/**
 *
 * @author emili
 */
public class Solution_968 {

    // This exercise is qualified as Hard by Leetcode
    
    /*
    *  -1: without security
    *   0: vigilated by a son
    *   1: has a camera
    */

    public int quantity = 0;

    public int minCameraCover(TreeNode root) {
        if(cameraCounter(root) == -1){
            quantity ++;
        }
        return quantity;
    }

    private int cameraCounter(TreeNode node){
        if(node == null){
            return 0;
        }
            int left = cameraCounter(node.left);
            int right = cameraCounter(node.right);
            if(left == -1 || right == -1 ){
                quantity ++;
                return 1;
            }if(left == 1 || right == 1){
                return 0;
            }
        return -1;
    }
}

