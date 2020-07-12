package ru.gorbunov.tasks._0002addtwonumbers;

//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = createListNodes(2, 4, 3);
        printListNodes(l1);
        ListNode l2 = createListNodes(5, 6 ,4);
        printListNodes(l2);
        printListNodes(new Solution().addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode inputList1, ListNode inputList2) {
        ListNode head = new ListNode(0);
        ListNode list1 = inputList1;
        ListNode list2 = inputList2;
        ListNode currentNode = head;
        int sum;
        boolean reserve = false;

        while (list1 != null || list2 != null) {

            sum = reserve ? 1 : 0;
            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }
            if (sum < 10) {
                currentNode.next = new ListNode(sum);
                reserve = false;
            } else {
                currentNode.next = new ListNode(sum - 10);
                reserve = true;
            }
            currentNode = currentNode.next;
        }
        if (reserve) {
            currentNode.next = new ListNode(1);
        }

        return head.next;
    }

    private static void printListNodes(ListNode listNode) {
        System.out.print("[");
        while (listNode.next != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println(listNode.val + "]");

    }

    private static ListNode createListNodes(int... values) {
        if (values == null && values.length == 0) {
            throw new IllegalArgumentException();
        }
        ListNode head = new ListNode(values[0]);
        ListNode previousNode = head;
        for (int i = 1 ; i < values.length; i++) {
            ListNode listNode = new ListNode(values[i]);
            previousNode.next = listNode;
            previousNode = listNode;
        }
        return head;
    }
}
