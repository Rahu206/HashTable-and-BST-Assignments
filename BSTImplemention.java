package com.bst;

import java.util.Scanner;

public class BSTImplemention<T> {
	MyBinaryNode<T> root;
	int size =0;
	 public BSTImplemention() {
	        this.root = null;
	    }

	
	public static void main(String[] args) {
		BSTImplemention bst = new BSTImplemention();
		 Scanner scanner = new Scanner(System.in);
	        System.out.println("Welcome to BST Program !!!");

	        boolean flag = true;
	        while (flag) {

	            System.out.println("\n1.To insert new node\n2To display BST\n3.To exit");
	            int choice = scanner.nextInt();

	            switch (choice) {

	                case 1:
	                    System.out.println("Enter the data to be inserted in new node : ");
	                    int data = scanner.nextInt();
	                    bst.insertNewNode(data);
	                    break;

	                case 2:
	                    bst.inorderTraversal(bst.root);
	                    break;

	                case 3:
	                    System.out.println("\nExited !!!");
	                    flag = false;
	                    break;

	                default:
	                    System.out.println("Enter Valid Input");
	                    break;

	            }

	        }

	    }
	public void insertNewNode(int data) {

        // create new Node
		MyBinaryNode<T> newNode = new MyBinaryNode<>(data);

        // Check if BST is empty or not
        if (root == null) {

            root = newNode;
            size ++;
            return;

        } else {

        	MyBinaryNode<T> current = root, parent = null;
            while (true) {

                //parent keep track of the parent node of current node.
                parent = current;

                //If data is less than current's data, node will be inserted to the left of tree
                if (data < current.data) {

                    current = current.left;

                    if (current == null) {

                        parent.left = newNode;
                        size++;
                        return;

                    }
                }

                //If data is greater than current's data, node will be inserted to the right of tree
                else {

                    current = current.right;

                    if (current == null) {

                        parent.right = newNode;
                        size++;
                        return;

                    }

                }
            }

        }
    }
	 public void inorderTraversal(MyBinaryNode<T> node) {

	        //Check whether tree is empty
	        if (root == null) {

	            System.out.println("Tree is empty");
	            return;

	        } else {

	            if (node.left != null)
	                inorderTraversal(node.left);

	            System.out.print(node.data + " ");

	            if (node.right != null)
	                inorderTraversal(node.right);


	        }
	    }
				
	}
	
	

	