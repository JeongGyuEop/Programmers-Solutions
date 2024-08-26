package src;

public class ToCharArray {
    public static void main(String[] args) {

        String str = "Hello World";

        // toCharArray() 사용
//        char[] chars = str.toCharArray();
//
//        for(char word : chars) {
//            System.out.print(word + " ");
//        }

        // charAt() 사용
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            System.out.print(ch + " ");
        }
    }
}
