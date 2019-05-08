package com.sjqi.algorithms.binarytree;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @ClassName Utils
 * @Description 算法工具类
 * @Author sjqi
 * @Date 14:42 2019/5/6
 * @Version 1.0
 **/
public class Utils {
    /**
     * 随机生成一个满二叉树
     *
     * @return
     */
    public static Node randomBinaryTree(int height) {
        //节点总个数=2的(height+1)次方-1,第k层的节点个数=2的k次方。
        Node root = new Node(new Random().nextInt(), null, null);
        int num = (int) Math.pow(2, height + 1) - 1;
        System.out.println("节点个数为："+num);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < num; i += 2) {
            Node node = queue.removeFirst();
            node.left = new Node(new Random().nextInt(), null, null);
            queue.add(node.left);
            node.right = new Node(new Random().nextInt(), null, null);
            queue.add(node.right);
        }
        return root;
    }

    /**
     * 前序遍历二叉树
     * @param root
     */
    public static void preBinaryTree(Node root) {
        if(root==null)return;
        System.out.println(root.value);
        preBinaryTree(root.left);
        preBinaryTree(root.right);
    }

    public static void main(String[] args) {
        Node binaryTree = Utils.randomBinaryTree(2);
        preBinaryTree(binaryTree);

    }
}
