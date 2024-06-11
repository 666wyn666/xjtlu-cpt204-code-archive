public class AVLTreeNode<E> extends TreeNode<E> {
    int height = 0;         //需要记录高度

    public AVLTreeNode(E element) {
        super(element);
    }
}