public abstract class BST<E extends Comparable<E>> {
    protected TreeNode<E> root;

    protected abstract AVLTreeNode<E> createNewNode(E element);

    // 插入一个元素   顺便可以通过这个学习下compareTo怎么用的
    //这里插入后会导致不平衡 所以需要平衡二叉树
    public boolean insert(E element) {
        if (root == null) {
            root = new TreeNode<>(element);
        } else {
            TreeNode<E> current = root;
            TreeNode<E> parent = null;

            while (current != null) {
                parent = current;
                if (element.compareTo(current.element) < 0) {
                    current = current.left;
                } else if (element.compareTo(current.element) > 0) {
                    current = current.right;
                } else {
                    return false; // 重复节点
                }
            }

            if (element.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(element);
            } else {
                parent.right = new TreeNode<>(element);
            }
        }
        return true;
    }

    // 查找元素
    public boolean search(E element) {
        TreeNode<E> current = root;
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    // In-order traversal
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode<E> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }
    }

    // Pre-order traversal
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode<E> root) {
        if (root != null) {
            System.out.print(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Post-order traversal
    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode<E> root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.element + " ");
        }
    }
}
