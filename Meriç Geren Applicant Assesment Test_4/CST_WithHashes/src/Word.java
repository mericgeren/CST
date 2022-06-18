import java.util.*;

public class Word {
	

	
	public Word() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String Args[]) {
		
		HashMap<Character,Integer> letters = new HashMap<Character,Integer>();
		String theWord;
		int occurence=0,counter;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a word: ");
		theWord = scan.next();
		
		for(counter=0;counter<theWord.length();counter++) {
				
				if(letters.containsKey(theWord.charAt(counter))){
					
					letters.replace(theWord.charAt(counter),letters.get(theWord.charAt(counter))+1);
				
				}
				
				else {
					
					letters.put(theWord.charAt(counter), 1);
					
				}
				
		}
		
		System.out.println();
		System.out.println(letters);
		
	}
	
}
