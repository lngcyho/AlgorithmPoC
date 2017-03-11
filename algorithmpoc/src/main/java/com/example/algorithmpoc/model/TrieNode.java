package com.example.algorithmpoc.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cyho on 29/01/2017.
 */

public class TrieNode {
    private final String word;
    private final char c;

    //Option of an array or Hashmap
    private TrieNode[] listOfCharacters = new TrieNode[26]; //a to z
    private Map<Character, TrieNode> mapOfCharacters = new HashMap<>(); // a to z

    public TrieNode(Character c) {
        this(c, null);
    }

    public TrieNode(Character c, String word) {
        this.c = c;
        this.word = word;
    }

    public Character getChar() {
        return c;
    }

    public String getWord() {
        return word;
    }

    //This should life in Trie structure...
    public void insert(String trieNode) {
//        Character character = trieNode.getChar();
//        //either insert to character - 'a'
//
//        int index = character - 'a';
//        if (listOfCharacters[index] != null) {
//            listOfCharacters[index] = trieNode;
//        } else {
//
//        }
//
//
//        //OR
//
//        if (!mapOfCharacters.containsKey(character)) {
//            mapOfCharacters.put(character, trieNode);
//        }
    }
}
