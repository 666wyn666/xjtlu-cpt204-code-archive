public class AVLTree<E extends Comparable<E>> extends BST<E> {      //继承BST 因为AVLTree 是BST的一种
    @Override
    protected AVLTreeNode<E> createNewNode(E element) {
        return new AVLTreeNode<>(element);
    }

    @Override
    public boolean insert(E element) {
        boolean successful = super.insert(element);
        if (!successful) return false;
        else {
            balancePath(element); // Balance from element to the root if necessary
        }
        return true;
    }

    // 代码甚至是图片 直接让gpt补全了
    private void balancePath(E element) {
        java.util.ArrayList<TreeNode<E>> path = path(element);
        for (int i = path.size() - 1; i >= 0; i--) {
            TreeNode<E> A = path.get(i);
            updateHeight((AVLTreeNode<E>) A);
            balance(A);
        }
    }

    private java.util.ArrayList<TreeNode<E>> path(E element) {
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
        TreeNode<E> current = root;

        while (current != null) {
            list.add(current);
            if (element.compareTo(current.element) < 0) {
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                current = current.right;
            } else
                break;
        }

        return list;
    }

    private void updateHeight(AVLTreeNode<E> node) {
        if (node.left == null && node.right == null) // node is a leaf
            node.height = 0;
        else if (node.left == null) // node has no left subtree
            node.height = 1 + ((AVLTreeNode<E>) (node.right)).height;
        else if (node.right == null) // node has no right subtree
            node.height = 1 + ((AVLTreeNode<E>) (node.left)).height;
        else
            node.height = 1 + Math.max(
                    ((AVLTreeNode<E>) (node.left)).height,
                    ((AVLTreeNode<E>) (node.right)).height);
    }

    private void balance(TreeNode<E> A) {
        int balanceFactor = getBalanceFactor((AVLTreeNode<E>) A);

        if (balanceFactor == -2) {
            if (getBalanceFactor((AVLTreeNode<E>) A.left) <= 0) {
                balanceLL(A, parentOf(A));
            } else {
                balanceLR(A, parentOf(A));
            }
        } else if (balanceFactor == 2) {
            if (getBalanceFactor((AVLTreeNode<E>) A.right) >= 0) {
                balanceRR(A, parentOf(A));
            } else {
                balanceRL(A, parentOf(A));
            }
        }
    }

    private int getBalanceFactor(AVLTreeNode<E> node) {
        if (node.right == null) {
            return -node.height;
        } else if (node.left == null) {
            return node.height;
        } else {
            return ((AVLTreeNode<E>) node.right).height - ((AVLTreeNode<E>) node.left).height;
        }
    }

    private TreeNode<E> parentOf(TreeNode<E> node) {
        TreeNode<E> current = root;
        TreeNode<E> parent = null;
        while (current != null && current != node) {
            parent = current;
            if (((Comparable<E>) node.element).compareTo(current.element) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return parent;
    }
    //平衡的操作 看懂就行了 不用会写
    private void balanceLL(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.left; // A is left-heavy and B is left-heavy
        if (A == root) {
            root = B;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = B;
            } else {
                parentOfA.right = B;
            }
        }
        A.left = B.right; // Make T2 the left subtree of A
        B.right = A; // Make A the right child of B
        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
    }

    private void balanceRR(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.right; // A is right-heavy and B is right-heavy
        if (A == root) {
            root = B;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = B;
            } else {
                parentOfA.right = B;
            }
        }
        A.right = B.left; // Make T2 the right subtree of A
        B.left = A;
        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
    }

    private void balanceLR(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.left; // A is left-heavy
        TreeNode<E> C = B.right; // B is right-heavy
        if (A == root) {
            root = C;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = C;
            } else {
                parentOfA.right = C;
            }
        }
        A.left = C.right; // Make T3 the left subtree of A
        B.right = C.left; // Make T2 the right subtree of B
        C.left = B;
        C.right = A;
        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
        updateHeight((AVLTreeNode<E>) C);
    }

    private void balanceRL(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.right; // A is right-heavy
        TreeNode<E> C = B.left; // B is left-heavy
        if (A == root) {
            root = C;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = C;
            } else {
                parentOfA.right = C;
            }
        }
        A.right = C.left; // Make T2 the right subtree of A
        B.left = C.right; // Make T3 the left subtree of B
        C.left = A;
        C.right = B;
        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
        updateHeight((AVLTree
