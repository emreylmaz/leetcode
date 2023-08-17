package leetcodeSolution1;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target){
        /* Bu, sayıları ve indislerini hızlıca saklamamıza yardımcı olacak bir araç.
        HashMap demek, verilerin anahtarlarla eşleştirilmesi demek.
        Biz de her sayıyı bir anahtar olarak saklayacağız ve bu sayının dizideki indisi de değeri olacak.
         */
        HashMap<Integer, Integer> map = new HashMap<>();

        // Her bir sayıyı tek tek hesaplayabilmek için döngüye alıyoruz.
        for (int i = 0; i < nums.length; i++) {
            //Eksik tamamlayıcı hedef sayıya ulaşmak için hangi sayının ekleneceğini bulmamıza yardımcı olur.
            int complement = target - nums[i];

            //Emre burada da eksik tamamlayıcıyı bulmak için hashmapte arama yapıyoruz.
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Eğer HashMap eksik tamamlayıcıyı içeriyorsa, bu demek oluyor ki zaten daha önce gördüğümüz bir sayı ile bu sayının toplamı hedef sayıya ulaşıyor.
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution found");
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 9);

        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
