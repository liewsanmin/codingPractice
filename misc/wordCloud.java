import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class WordCloudData{
    private Map<String, Integer> wordsToCounts = new HashMap<>();

    public WordCloudData(String inputString){
        populateWordsToCounts(inputString);
    }

    public Map<String, Integer> getWordsToCounts(){
        return Collections.unmodifiableMap(wordsToCounts);
    }

    private void populateWordsToCounts(String inputString){
        int currentWordStartIndex = 0;
        int currentWordLength = 0;

        for(int i = 0; i < inputString.length(); i++){
            char character = inputString.charAt(i);

            if(i == inputString.length() - 1){
                if(Character.isLetter(character)){
                    currentWordLength++;
                }
                if(currentWordLength > 0){
                    String currentWord = inputString.substring(currentWordStartIndex,
                    currentWordStartIndex + currentWordLength);
                    addWordToHashMap(currentWord);
                }
            } else if (character == ' ' || character == '\u2014') {
                if(currentWordLength > 0){
                    String currentWord = inputString.substring(currentWordStartIndex,
                    currentWordStartIndex + currentWordLength);
                    addWordToHashMap(currentWord);
                    currentWordLength = 0;
                }
            } else if(character == '.'){
                if(i < inputString.length() - 1 && inputString.charAt(i+1) == '.'){
                    if(currentWordLength > 0){
                        String currentWord = inputString.substring(currentWordStartIndex,
                        currentWordStartIndex + currentWordLength);
                        addWordToHashMap(currentWord);
                        currentWordLength = 0;
                    }
                }
            }else if (Character.isLetter(character) || character == '\'') {
                if (currentWordLength == 0) {
                    currentWordStartIndex = i;
                }
                currentWordLength++;

            // if the character is a hyphen, we want to check if it's surrounded by letters
            // if it is, we add it to our current word
            } else if (character == '-') {
                if (i > 0 && Character.isLetter(inputString.charAt(i - 1))
                        && Character.isLetter(inputString.charAt(i + 1))) {
                    if (currentWordLength == 0) {
                        currentWordStartIndex = i;
                    }
                    currentWordLength++;
                } else {
                    if (currentWordLength > 0) {
                        String currentWord = inputString.substring(currentWordStartIndex,
                            currentWordStartIndex + currentWordLength);
                        addWordToHashMap(currentWord);
                        currentWordLength = 0;
                    }
                }
            }
        }
    }

    private void addWordToHashMap(String word) {

        // if the word is already in the hash map we increment its count
        if (wordsToCounts.containsKey(word)) {
            wordsToCounts.put(word, wordsToCounts.get(word) + 1);

        // if a lowercase version is in the hash map, we know our input word must be uppercase
        // but we only include uppercase words if they're always uppercase
        // so we just increment the lowercase version's count
        } else if (wordsToCounts.containsKey(word.toLowerCase())) {
            int newCount = wordsToCounts.get(word.toLowerCase()) + 1;
            wordsToCounts.put(word.toLowerCase(), newCount);

        // if an uppercase version is in the hash map, we know our input word must be lowercase.
        // since we only include uppercase words if they're always uppercase, we add the
        // lowercase version and give it the uppercase version's count
        } else if (wordsToCounts.containsKey(capitalize(word))) {
            int newCount = wordsToCounts.get(capitalize(word)) + 1;
            wordsToCounts.put(word, newCount);
            wordsToCounts.remove(capitalize(word));

        // otherwise, the word is not in the hash map at all, lowercase or uppercase
        // so we add it to the hash map
        } else {
            wordsToCounts.put(word, 1);
        }
    }

    private String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
