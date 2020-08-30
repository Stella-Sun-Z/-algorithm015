package Week1;

public class Swap_nodes_in_pairs {
    // 递归法
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs1(second.next);
        second.next = first;
        return second;
    }

    // 迭代法
    public ListNode swapPairs2(ListNode head) {
        ListNode output = new ListNode(0);
        output.next =head;
        ListNode pre = output;
        ListNode first = head;
        while (first != null && first.next != null) {
            ListNode second = first.next;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
            first = first.next;
        }
        return output.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
