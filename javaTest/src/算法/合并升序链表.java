package 算法;

import java.awt.*;
import java.util.*;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class 合并升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        合并升序链表 listNodes = new 合并升序链表();
        List<String> lists = new ArrayList<String>();

        ListNode listNode = new ListNode(0);
        ListNode nextnode;
        nextnode = listNode;


        for (int i = 1; i <= 10; i++){
            ListNode node = new ListNode(i);
            nextnode.next = node;
            nextnode = nextnode.next;
        }
        System.out.println(nextnode.val);
        nextnode = listNode;
        while(nextnode != null){
            System.out.println(nextnode.val);
            nextnode = nextnode.next;
        }
        nextnode = listNode;
    }
}
