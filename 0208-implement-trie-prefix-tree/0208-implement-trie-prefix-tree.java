class Trie {
    class Node{
        Node[] children;
        boolean eow;
        Node(){
            children = new Node[26];
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
            eow = false;
        }
    }
    
    public Trie() {
        
    }
    
    Node root = new Node();
    
    public void insert(String word) {
        Node currNode = root;
        int n = word.length();
        for(int i = 0; i < n; i++){
            int idx = word.charAt(i) - 'a';
            if(currNode.children[idx] == null) currNode.children[idx] = new Node();
            if(i == n - 1) currNode.children[idx].eow = true;
            currNode = currNode.children[idx];
        }
    }
    
    public boolean search(String word) {
        Node currNode = root;
        int n = word.length();
        for(int i = 0; i < n; i++){
            int idx = word.charAt(i) - 'a';
            if(currNode.children[idx] == null) return false;
            if(i == n - 1 && currNode.children[idx].eow != true) return false;
            currNode = currNode.children[idx];
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Node currNode = root;
        int n = prefix.length();
        for(int i = 0; i < n; i++){
            int idx = prefix.charAt(i) - 'a';
            if(currNode.children[idx] == null) return false;
            currNode = currNode.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */