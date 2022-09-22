package test;

import pojo.Node;
import tool.BST;

import java.util.*;

public class test {
//    public static void main(String[] args) {
//        Map map = new HashMap();
//        Set set = new HashSet();
//        TreeSet treeSet = new TreeSet<>();
//        System.out.println(map.put("aa","bbb"));
//    }

    public static void main(String[] args) {
        // 创建一个二叉排序树
        BST BST = new BST();
        // 并未BST设置一个root节点
        Node root = new Node(0, "root");
        BST.root = root;
        // 手动添加节点
        BST.add(3, "z3");
        BST.add(5, "z5");
        BST.add(8, "z8");
        BST.add(2, "z2");
        BST.add(2, "z22");
        BST.add(9, "z9");
        BST.add(7, "z7");
        BST.add(52, "z52");
        BST.add(66, "z66");
        BST.delNode(8);
        BST.midOrder(BST.root);
    }
}
