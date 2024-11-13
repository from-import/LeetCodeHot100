package com.xxx;

public class LeetCode208 {
    public class Trie {
        private TrieNode root;

        // 构造函数，初始化根节点
        public Trie() {
            root = new TrieNode();
        }

        // 插入字符串到 Trie 中
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;  // 标记当前节点为字符串的结尾
        }

        // 搜索完整字符串是否在 Trie 中
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd;  // 确保节点存在并且是一个完整单词的结尾
        }

        // 搜索前缀是否在 Trie 中
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        // 辅助函数，搜索前缀，返回最后一个节点
        private TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;  // 前缀不存在
                }
                node = node.children[index];
            }
            return node;  // 返回最后一个节点
        }
    }

    class TrieNode {
        // 子节点映射
        TrieNode[] children;
        // 标记是否为完整的字符串结尾
        boolean isEnd;

        // 构造函数
        public TrieNode() {
            children = new TrieNode[26];  // 假设只包含小写字母 'a' 到 'z'
            isEnd = false;
        }
    }
}
