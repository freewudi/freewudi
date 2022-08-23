package pojo;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class Node {
    public int val;
    public Node left;
    public Node right;

    public String data;

    Node() {
    }

    public Node(int val, String data) {
        this.val = val;
        this.data = data;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", data='" + data + '\'' +
                '}';
    }
}
