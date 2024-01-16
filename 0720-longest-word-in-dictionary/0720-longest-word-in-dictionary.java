class Solution {
    
    public String longestWord(String[] words) {
        Trie dictionary = new Trie();
        int n = words.length;
        for(int i = 0; i < n; i++){
            dictionary.insert(words[i]);
        }   
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        dictionary.getAns(dictionary.root, temp, ans);
        return ans.toString();
    }
    class Trie{
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
        Node root = new Node();
        public void insert(String word){
            Node curr = root;
            int n = word.length();
            for(int i = 0; i < n; i++){
                int idx = word.charAt(i) - 'a';
                if(curr.children[idx] == null) curr.children[idx] = new Node();
                if(i == n - 1) curr.children[idx].eow = true;
                curr = curr.children[idx];
            }
        }
        public void getAns(Node root, StringBuilder temp, StringBuilder ans){
            if(root == null) return;
            for(int i = 0; i < 26; i++){
               if(root.children[i] != null && root.children[i].eow == true){
                    temp.append((char)(i + 'a'));
                    if(temp.length() > ans.length()) ans.replace(0, ans.length(), temp.toString());
                    getAns(root.children[i], temp, ans);
                    temp.deleteCharAt(temp.length() - 1);
               }   
           }
        } 
    }
}