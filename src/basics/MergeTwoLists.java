package basics;

import basics.helpers.ListNode;

public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode currNode;
        ListNode prevNode = new ListNode();
        ListNode startNode = prevNode;
        while (list1 != null && list2 != null ) {
                currNode = new ListNode();
                if (list1.val < list2.val) {
                    currNode.val = list1.val;
                    list1 = list1.next;
                } else {
                    currNode.val = list2.val;
                    list2 = list2.next;
                }
                prevNode.next = currNode;
                prevNode = prevNode.next;

        }
        if (list1 == null && list2 != null) {
            prevNode.next = list2;
        }
        if (list2 == null && list1 != null) {
            prevNode.next = list1;
        }
        return startNode.next;
    }

    public static void printList(ListNode list) {
        if (list.equals(new ListNode())) {
            return;
        }
        System.out.print(list.val + " ");
        do {
            list = list.next;
            System.out.print(list.val + " ");
        } while (list.next != null);
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(4);
        for (int i = 3; i > 0; i--) {
            list1 = new ListNode(i, list1);
        }
        printList(list1);

        ListNode list2 = new ListNode(8);
        for (int i = 7; i > 1; i-=2) {
            list2 = new ListNode(i, list2);
        }
        printList(list2);

        ListNode resultList = mergeTwoLists(list1, list2);

        printList(resultList);
    }
}
