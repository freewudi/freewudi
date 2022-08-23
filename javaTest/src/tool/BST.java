package tool;

import pojo.Node;

public class BST<E> {
    //创建根节点
    private Node root;

    /**
     * 创建节点
     *
     * @param key
     * @param data
     */
    public void add(int key, String data) {
        //如果根节点为空，则新增节点为根节点
        if (root == null) {
            root = new Node(key, data);
        }

        Node cur = root; // cur：表示要判断的当前节点。cur从根节点开始判断，因此初始值为root
        Node pre = null; //pre表示cur的上个节点 也就是父节点
        while (cur != null) {
            if (key < cur.val) {
                pre = cur;
                cur = cur.left;
            } else if (key > cur.val) {
                pre = cur;
                cur = cur.right;
            } else {
                cur.data = data;
                return;
            }
        }
        // 循环结束 cur为null则表示已经找到了合适的添加位置

        /*3、最终判断：应当插入父节点的左边还是右边？*/
        if (key < pre.val)
            // 插入到父节点的左边
            pre.left = new Node(key, data);
        else
            // 插入到父节点的右边
            pre.right = new Node(key, data);

    }

    public Node find(int key) {
        Node cur = root;

        while (cur != null) {
            if (key == cur.val)
                return cur;

            if (key < cur.val)
                cur = cur.left;
            else
                cur = cur.right;

        }
        return null;
    }

    /**
     * 递归查询
     *
     * @param node
     * @param key
     * @return
     */
    public Node dgFind(Node node, int key) {
        // 如果节点为空 则表示已经找到末尾了还没找到
        if (node == null)
            return null;

        // 如果cur.key == key 则表示找到了,直接返回
        if (node.val == key)
            return node;

        // 下面是当前节点大于key和小于key的情况
        if (key < node.val)
            return dgFind(node.left, key);  // 切记这里是return dgFind(xxx, xxx)  不是直接调用dgFind(xxx, xxx)
        else    // key > node.key
            return dgFind(node.right, key);
    }

    /**
     * 寻找父节点
     *
     * @param key
     * @return
     */
    public Node findParent(int key) {
        // 如果搜索的key是根节点的key 那么直接返回null 因为root没有父节点
        if (key == root.val)
            return null;

        Node cur = root;
        while (cur != null) {

            //如果左节点不为空切左节点key相同
            if (cur.left != null && key == cur.left.val)
                return cur;

            if (cur.right != null && key == cur.right.val)
                return cur;

            //向下搜索
            if (key < cur.val)
                cur = cur.left;

            if (key > cur.val)
                cur = cur.right;
        }
        return null;
    }

    /**
     * 搜索该节点下最大叶子节点
     *
     * @param node
     * @return
     */
    public Node searchMax(Node node) {
        Node target = node;
        while (target.right != null) {
            target = target.right;
        }
        return target;
    }

    /**
     * 删除节点
     *
     * @param key
     * @return
     */
    public boolean delNode(int key) {
        /**
         * 先分两大种情况：
         * 删除节点为 非root节点
         * 删除节点为 root节点
         *
         * 再分三种情况：
         * 1、删除的节点是叶子节点（左右节点都为null）
         * 2、删除的节点只有一个子树（左节点为null 或者 右节点为null）
         * 3、删除的节点有两颗子树（左右节点都不为null）
         */
        // 找到要删除的节点
        Node targetNode = find(key);
        // 如果node为null  这说明树中不存在指定key的节点，直接返回false
        if (targetNode == null) {
            return false;
        }
        //找到删除节点的父节点
        Node parent = findParent(key);



        return true;
    }
}
