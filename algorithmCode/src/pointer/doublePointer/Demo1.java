package pointer.doublePointer;


import java.util.List;
import java.util.Stack;

//回文链表 , 解法 :使用快慢指针
//https://leetcode.cn/problems/palindrome-linked-list/?envType=study-plan-v2&envId=top-100-liked
public class Demo1 {


    public class  ListNode{
        int val;
        ListNode next;

        /**
         * ListNode构造方法
         */
        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //开始反转慢指针后面的链表
        ListNode cur = slow;
        ListNode pre = null;
        while(cur != null){
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }

        //两个子链表进行对比
        ListNode left = head;
        ListNode right = pre;
        while(left != null && right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }


    /**
     * 使用栈
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode cur = head;
        Stack<Integer> stack = new Stack<>();
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        ListNode cur1 = head;
        while(cur1 != null){
            int tmp = stack.pop();//拿出栈顶元素
            if(tmp != cur1.val){
                return false;
            }
            cur1 = cur1.next;
        }
        return true;
    }
}
