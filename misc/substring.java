import java.io.*;
import java.util.*;
/*
collect a list of substring that start with a vowel and ends with a consonant
*/
public class substring{
	public static ArrayList<String> getSubstrings(String input){
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < input.length(); i++){
			for(int j = i+1; j < input.length()+ 1; j++){
				String curr = input.substring(i, j);
				if((curr.charAt(0) == 'a' ||
					curr.charAt(0) == 'e' ||
				   	curr.charAt(0) == 'i' ||
				   	curr.charAt(0) == 'o' ||
				   	curr.charAt(0) == 'u') &&
				   (curr.charAt(curr.length()-1) != 'a' && 
				   	curr.charAt(curr.length()-1) != 'e' &&
				   	curr.charAt(curr.length()-1) != 'i' &&
				   	curr.charAt(curr.length()-1) != 'o' &&
				   	curr.charAt(curr.length()-1) != 'u'))
					list.add(curr);  
			}
		}
		return list;
	}
	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<>();
		list = getSubstrings(args[0]);
		for(String curr : list){
			System.out.println(curr);
		}
	}
}
