/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Leetcode113M;

import com.mycompany.commonTreeNode.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author emili
 */
public class Solution_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> targetPaths = new LinkedList<>();
        
        if(root != null){
            LinkedList<Integer> pathList = new LinkedList<>();
            int pathSum = 0;
            treePaths(root, pathList, targetPaths, pathSum, targetSum);
            
        }
        return targetPaths;        
    }

    private void treePaths(TreeNode node, List<Integer> pathList, List<List<Integer>> targetPaths, int pathSum, int targetSum){
        List<Integer> pathList2 = new LinkedList<Integer>();
        for(Integer integer : pathList){
            pathList2.add(integer);
        }
        int pathSum2 = pathSum;
        if(node.left == null && node.right == null){
            pathList2.add(node.val);
            pathSum += node.val;
            if(pathSum == targetSum){
                targetPaths.add(pathList2);
            }
            pathSum = 0;
            pathList.clear();
            
        }if(node.left != null){
            pathList2.add(node.val);
            pathSum2 += node.val;
            treePaths(node.left, pathList2, targetPaths, pathSum2, targetSum);

        }if(node.right != null){
            pathList.add(node.val);
            pathSum += node.val;
            treePaths(node.right, pathList, targetPaths, pathSum, targetSum);
        }
    }
}
