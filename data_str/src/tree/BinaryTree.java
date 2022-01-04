package tree;


import java.util.LinkedList;
import java.util.Stack;

import static java.util.Arrays.asList;

public class BinaryTree {


    /**
     * 二叉树节点
     */
    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }
    }


    /**
     * 构建二叉树
     * @param inputList    输入序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if(inputList == null || inputList.isEmpty()){
            return null;
        }

        Integer data = inputList.removeFirst();
        if(data != null){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }

        return node;
    }


    /**
     * 二叉树前序遍历
     * @param node  二叉树节点
     */
    public static void preOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树非递归前序遍历
     * @param root  二叉树根节点
     */
    public static void preOrderTraversalWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while(treeNode != null || !stack.isEmpty()){
            //迭代访问节点左孩子，并入栈
            while(treeNode != null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树中序遍历
     * @param node  二叉树节点
     */
    public static void inOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     * @param node  二叉树节点
     */
    public static void postOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }


    public static void main(String[] args) {

        LinkedList<Integer> inputList = new LinkedList<>(
            asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4})
        );

        TreeNode treeNode = createBinaryTree(inputList);

        System.out.println("前序遍历 ：");
        preOrderTraversal(treeNode);
        System.out.println("非递归前序遍历 ：");
        preOrderTraversalWithStack(treeNode);
        System.out.println("中序遍历:");
        inOrderTraversal(treeNode);
        System.out.println("后序遍历:");
        postOrderTraversal(treeNode);
    }





}
