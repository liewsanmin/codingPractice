/**
I wrote a crawler that visits web pages, stores a few keywords in a database,
and follows links to other web pages. I noticed that my crawler was wasting a
lot of time visiting the same pages over and over, so I made a hash set,
 visited, where I'm storing URLs I've already visited. Now the crawler only
  visits a URL if it hasn't already been visited.

Thing is, the crawler is running on my old desktop computer in my parents'
basement (where I totally don't live anymore), and it keeps running out of
memory because visited is getting so huge.

How can I trim down the amount of space taken up by visited?

*/

class TrieNode{
    private HashMap<Character, TrieNode> nodeChildren;

    public TrieNode(){
        this.nodeChidlren = new HashMap<Character, TrieNode>();
    }

    public boolean hasChildNode(char character){
        return this.nodeChildren.containsKey(character);
    }

    public void makeChildNode(char character){
        this.nodeChildren.put(character, new TrieNode());
    }

    public TrieNode getChildNode(char character){
        return this.nodeChildren.get(character);
    }
}


public class Trie{
    private TrieNode rootNode;
    private final char endOfWordMarker = "\0";

    public Trie(){
        this.rootNode = new TrieNode();
    }

    public boolean checkPresentAndAdd(String word){
        TrieNode currentNode = this.rootNode;
        boolean isNewWord = false;

        // Work downwards through the trie, adding nodes
        // as needed, and keeping track of whether we add
        // any nodes.
        for(int i = 0; i < word.length(); i++){
            char character = word.charAt(i);

            if(!currentNode.hasChildNode(character)){
                isNewWord = true;
                currentNode.makeChildNode(character);
            }

            currentNode = currentNode.getChildNode(character);
        }

        if(!currentNode.hasChildNode(endOfWordMarker)){
            isNewWord = true;
            currentNode.makeChildNode(endOfWordMarker);
        }

        return isNewWord;
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        String word = "www.google.com";
        String add = "www.google.com/about";
        System.out.println(trie.checkPresentAndAdd(word));
        System.out.println(trie.checkPresentAndAdd(add));
        System.out.println(trie.checkPresentAndAdd(add));
    }
}
