class WordDictionary {

    Trie root = new Trie();

    public WordDictionary() {

    }

    public void addWord(String word) {
        if(word == null) {
            return;
        }
        Trie temp = root;
        for(int i=0;i<word.length();i++) {
            char character = word.charAt(i);
            if(temp.child.get(character)==null) {
                temp.child.put(character, new Trie());
            } 
            temp = temp.child.get(character);
        }
        temp.endWord = word;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }


boolean dfs(Trie node, String word, int index) {
    if(index == word.length()) {
        return true;
    }
    if(index > word.length()) {
        return false;
    }
    char character = word.charAt(index);
    if(character == '.') {
        for(Map.Entry<Character, Trie> entry: node.child.entrySet()) {
             Trie child = entry.getValue();
            if(dfs(child, word, ++index)) {
                return true;
            }
        }
    } else {
        Trie child = node.child.get(character);
        if(child == null) {
            return false;
        }
        return dfs(child, word, ++index);
    }
    return false;
}
}
class Trie {
    String value;
    Map<Character, Trie> child = new HashMap();
    String endWord;
}
