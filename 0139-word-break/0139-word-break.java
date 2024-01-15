import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie tree = new Trie();
        for (var string : wordDict) {
            tree.insert(string);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && tree.search(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    class Trie {
        class Node {
            Node[] children;
            boolean EOW;

            Node() {
                children = new Node[26];
                for (int i = 0; i < 26; i++) {
                    children[i] = null;
                }
                EOW = false;
            }
        }

        Node root = new Node();

        public void insert(String word) {
            Node currNode = root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                int idx = letter - 'a';
                if (currNode.children[idx] == null) {
                    currNode.children[idx] = new Node();
                }
                if (i == word.length() - 1) {
                    currNode.children[idx].EOW = true;
                }
                currNode = currNode.children[idx];
            }
        }

        public boolean search(String word) {
            Node currNode = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (currNode.children[idx] == null) return false;
                if (i == word.length() - 1 && currNode.children[idx].EOW == false) return false;
                currNode = currNode.children[idx];
            }
            return true;
        }
    }
}
