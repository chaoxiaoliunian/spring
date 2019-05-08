package com.sjqi.algorithms.binarytree;

/**
 * @ClassName Node
 * @Description 链式存储的二叉树节点
 * @Author sjqi
 * @Date 14:40 2019/5/6
 * @Version 1.0
 **/
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
