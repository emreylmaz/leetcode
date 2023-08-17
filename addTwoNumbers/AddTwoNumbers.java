package addTwoNumbers;
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // Bu düğüm, sonuç bağlı listesini oluşturmak için kullanılacak.
            ListNode dummy = new ListNode(0);
            // bu referansla sonuç bağlı listesini gezineceğiz
            ListNode current = dummy;
            //toplama işlemi sırasında oluşabilecek taşıma durumunu temsil edecek.
            int carry = 0;

            while (l1 != null || l2 != null) {
                // sum değeri bağlı listelerin elemanlarının toplamını temsil ediyor.
                int sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
            /** 10'a böldüğümüzde kaç tane 10'luk basamak olduğunu temsil ediyor.
             *Kalanı alarak gerçek toplama sonucunu buluyoruz ve bu sonucu yeni bir düğüm olarak
             *current.next bağlı listesine ekliyoruz
             */
                carry = sum / 10;
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
            /**
          * sonuca bir sonraki düğüm olarak eklemek, sonucun düzgün bir şekilde oluşturulmasını sağlıyor.
          * Eğer döngü bittiğinde taşıma durumu hala 0'dan büyükse,
          * sonuca bir sonraki düğüm olarak taşıma durumunu ekliyoruz.
             * */

            if (carry > 0) {
                current.next = new ListNode(carry);
            }

            return dummy.next;
        }

        public static void main(String[] args) {
            AddTwoNumbers solution = new AddTwoNumbers();

            // Create linked list representations of the input numbers
            ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
            ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

            // Calculate the sum
            ListNode result = solution.addTwoNumbers(l1, l2);

            // Print the result
            while (result != null) {
                System.out.print(result.val + " ");
                result = result.next;
            }
        }

}
