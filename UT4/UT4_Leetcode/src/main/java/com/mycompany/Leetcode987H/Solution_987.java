/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Leetcode987H;

import com.mycompany.commonTreeNode.TreeNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author emili
 */
public class Solution_987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        // This exercise is qualified as Hard by Leetcode
        
        TreeMap<Integer, ArrayList<NodeWithLocation>> columns = new TreeMap<>(); 
        int location = 0;
        int level = 0;

        traversal(root, columns, location, level);

        Collection<ArrayList<NodeWithLocation>> collection = columns.values();
        List<List<NodeWithLocation>> collectionToList = new ArrayList<>(collection);
        
        List<List<Integer>> exit = new LinkedList<>();
        for(List<NodeWithLocation> list : collectionToList){
            Collections.sort(list, (l1, l2) -> Integer.compare(l1.getVal(), l2.getVal()));
            Collections.sort(list, (l1, l2) -> Integer.compare(l1.getLevel(), l2.getLevel()));
            LinkedList<Integer> exitSubList = new LinkedList<>(); 
            for(NodeWithLocation node : list){
                exitSubList.add(node.getVal());
            }
            exit.add(exitSubList);
        }
        return exit;
    }

    public void traversal(TreeNode root, TreeMap<Integer, ArrayList<NodeWithLocation>> columns, int position, int level){
        if(columns.containsKey(position)){
            columns.get(position).add(new NodeWithLocation(root.val, level));
        }else{
            columns.put(position, new ArrayList<NodeWithLocation>());
            columns.get(position).add(new NodeWithLocation(root.val, level));
        }
        if(root.left != null){
            traversal(root.left, columns, position - 1, level + 1);
        }
        if(root.right != null){
            traversal(root.right, columns, position + 1, level + 1);
        }
    }
}
class NodeWithLocation{
    public int val;
    public int level;

    public NodeWithLocation(int aVal,int aLevel){
        this.val = aVal;
        this.level = aLevel;
    }

    public int getVal(){
        return val;
    }

    public int getLevel(){
        return level;
    }
}
