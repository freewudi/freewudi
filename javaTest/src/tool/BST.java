package tool;

import pojo.Node;

public class BST<E> {
    //创建根节点
    public Node root;

    public int size;
    /**
     * 创建节点
     *
     * @param key
     * @param data
     */
    public void add(int key, String data) {
        //如果根节点为空，则新增节点为根节点
        if (root == null) {
            size++;
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

        size++;
    }

    public boolean contain(Node node){
        return node.data.equals(find(node.val).data);
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
        if (targetNode == null)
            return false;

        //找到删除节点的父节点
        Node parent = findParent(key);
        if (parent != null) {
            if (targetNode.left == null && targetNode.right == null) {  // 1、删除节点是叶子节点
                if (parent.left != null && parent.left.val == targetNode.val) // 待删除节点是父节点的左节点
                    parent.left = null;
                else    // 待删除节点是父节点的右节点
                    parent.right = null;
            } else if (targetNode.left != null && targetNode.right != null) {    // 3、待删除节点有两棵子树
                // 备份一下要替换的节点
                Node maxNode = searchMax(targetNode.left);
                Node temp = new Node(maxNode.val, maxNode.data);
                // 将这个节点从树中删除
                delNode(maxNode.val);
                // temp节点 的左、右指针指向 待删除节点的左、右节点
                //最大子节点被删除，最大子节点的子节点成为targetNode的左节点，再把temp的左右节点指向targetNode的左右节点
                temp.left = targetNode.left;
                temp.right = targetNode.right;
                // 父节点的左指针或者右指针指向temp节点， 备份节点彻底替换掉待删除节点
                if (parent.left != null && parent.left.val == targetNode.val)
                    parent.left = temp;
                else
                    parent.right = temp;
            } else {
                // 如果待删除节点是parent的左节点
                if (parent.left != null && parent.left.val == targetNode.val) {
                    if (targetNode.left != null) {
                        parent.left = targetNode.left;
                    } else if (targetNode.right != null) {
                        parent.left = targetNode.right;
                    }
                    //如果待删除节点是parent的右节点
                } else {
                    if (targetNode.left != null) {
                        parent.right = targetNode.left;
                    } else if (targetNode.right != null) {
                        parent.right = targetNode.right;
                    }
                }
            }

        } else { // parent为null，则表示删除节点是root节点
            if (targetNode.left == null && targetNode.right == null) {
                root = null;
            } else if (targetNode.left != null && targetNode.right != null) {
                Node maxNode = searchMax(targetNode.left);
                Node temp = new Node(maxNode.val, maxNode.data);
                delNode(maxNode.val);
                temp.right = targetNode.right;
                temp.left = targetNode.left;
                // 将这个备份节点设置为root节点
                this.root = temp;
            } else {
                if (targetNode.left != null)
                    this.root = targetNode.left;
                else
                    this.root = targetNode.right;
            }
        }
        size--;
        return true;
    }

    /**
     * 中序遍历
     * @param node
     */
    public void midOrder(Node node) {
        if (node != null) {
            midOrder(node.left);
            System.out.println("节点的key："+node.val+" 节点的值："+node.data);
            midOrder(node.right);
        }
    }

    /**
     * 判断bst是否为空
     * @return
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * bst大小
     * @return
     */
    public int size(){
        return size;
    }
}
