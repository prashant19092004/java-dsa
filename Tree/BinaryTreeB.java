import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeB{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        public static int idx = -1;

        public Node buildTree(int[] nodes){
            idx++;

            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public void preorderByRecursion(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorderByRecursion(root.left);
            preorderByRecursion(root.right);
        }

        public void preorderByIteration(Node root){
            Stack<Node> stack = new Stack<Node>();

            if(root == null){
                System.out.print("Tree is Empty");
                return;
            }

            Node ptr = root;

            while(ptr != null){
                System.out.print(ptr.data + " ");

                if(ptr.right != null){
                    stack.push(ptr.right);
                }

                if(ptr.left != null){
                    ptr = ptr.left;
                }else{
                    ptr = stack.isEmpty() ? null : stack.pop();
                }
            }
        }

        public void inorderByRecursion(Node root){

            if(root == null){
                return;
            }

            inorderByRecursion(root.left);
            System.out.print(root.data + " ");
            inorderByRecursion(root.right);
        }

        // public void inorderByIteration(Node root){
        //     if(root == null){
        //         System.out.print("Tree is Empty");
        //         return;
        //     }

        //     Node ptr = root;

        //     while(ptr != null){

        //     }
        // }

        public void postorderByRecursion(Node root){

            if(root == null){
                return;
            }

            postorderByRecursion(root.left);
            postorderByRecursion(root.right);
            System.out.print(root.data + " ");
        }

        public void displayUsingBFS(Node root){
            if(root == null){
                System.out.print("Tree is Empty");
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();

                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }

                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }
    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
        tree.preorderByRecursion(root);
        System.out.println();
        tree.preorderByIteration(root);
        System.out.println();
        tree.inorderByRecursion(root);
        System.out.println();
        tree.postorderByRecursion(root);
        System.out.println();
        tree.displayUsingBFS(root);
    }
}