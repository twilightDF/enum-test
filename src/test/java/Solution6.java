import lombok.AllArgsConstructor;
import org.junit.Test;


public class Solution6 {

    @Test
    public void test01(){

        //创建链表,并赋值,赋值时保证为升序
        int[] arr;
        ListNode l1 = createList(arr = new int[]{1,2,3,4,5,6,7,8});
        ListNode l2 = createList(arr = new int[]{2,3,4,5});//1,2,2,3,3,4,4,5,5,6,7,8

        //合并链表
        ListNode mergeTwoLists = mergeTwoLists(l1, l2);

        //打印链表
        print(mergeTwoLists);
    }
    /*
    思路1:固定一个链表,将另一个链表的节点逐个插入到合适的位置
        太复杂且不好实现
     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode theFixed;//定义固定不动的链表
//        ListNode theInsert;//定义等待被分解的链表
//        //选择l1和l2中头节点小的作为固定链表,另一个链表作插入操作
//        if(l1.val <= l2.val){
//            theFixed = l1;
//            theInsert = l2;
//        }else{
//            theFixed = l2;
//            theInsert = l1;
//        }
//        ListNode node = theFixed;
//
//        while (theInsert != null){//此层循环目的是从待分解的链表中逐个拿到val
//            int num = theInsert.val;
//
//            while(theFixed != null) {
    //FIXME
//                if (num >= theFixed.val) {
//                    ListNode node1 = new ListNode(num);
//                    node1.next = theFixed.next;
//                    theFixed.next = node1;
//                    theFixed = node;
//                    break;
//                } else if (theFixed.next == null) {
//                    //若num大于theFixed中的所有值,则直接加在theFixed的尾端
//                    ListNode node1 = new ListNode(num);
//                    theFixed.next = node1;
//                } else {
//                    theFixed = theFixed.next;
//                }
//            }
//            theInsert = theInsert.next;
//        }
//        return node;
//    }


    /*
    思路2:比较两个链表的当前节点的大小,小者接入到新建链表中且小者的链表节点往后移一位
     */
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){

        ListNode node = new ListNode(0);//新建一个代返回的链表
        ListNode nodeSta = node;//保存头节点地址

        while(l1!=null&l2!=null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if(l1==null) node.next = l2;
        if (l2==null) node.next = l1;
        return nodeSta.next;
    }

    //方便创建链表
    public ListNode createList(int[] num){
        ListNode nodeSta = new ListNode(num[0]);//创建一个首节点
        ListNode nextNode;//声明一个变量在移动过程中指向当前节点
        nextNode = nodeSta;
        for (int i = 1; i < num.length; i++) {
            ListNode node = new ListNode(num[i]);//生成新的节点
            nextNode.next = node;//将新节点连进来
            nextNode = nextNode.next;//nextNode往后移动一位
        }//当for循环之后nextNode指向过最后一个节点
        return nodeSta;
    }

    //方便打印链表
    public void print(ListNode node){
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}

@AllArgsConstructor
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
}
