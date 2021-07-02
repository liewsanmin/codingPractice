public class Solution {
    public static String reverseString(String s, int i, int j){
         char[] inputChar = s.toCharArray();
         while (i < j){
                char temp = inputChar[i];
                inputChar[i] = inputChar[j];
                inputChar[j] = temp;
                i++;
                j--;
         }
        return new String(inputChar);
    }

    public static String reverseWords(String msg){
		String reverse = reverseString(msg, 0, msg.length() - 1);
        char[] arr = reverse.toCharArray();
        int start = 0;
        for(int i = 0; i < reverse.length(); i++){
            if(i == reverse.length() - 1){
                reverse = reverseString(reverse, start, i);
            }
			else if(arr[i] == ' '){
                reverse = reverseString(reverse, start, i - 1);
                start = i + 1;
            }
        }
     	return reverse;
    }

    public static void main(String[] args) {
		String message = "find you will pain only go you recordings security the into if";
		System.out.println(reverseWords(message));
    }
}
