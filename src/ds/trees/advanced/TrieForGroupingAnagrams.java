package ds.trees.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
/*
    Group and Print all anagrams of a given string together
    Given a sequence of words, print all anagrams together, For example, if given word sequence is ["car", "ape", "meal", "pea", "male", "arc", "lame", "dog"] then output of the program should be - 
        car, arc
        ape, pea
        lame, meal, male
        dog
    Order of groups and order of group members between themselves could be different but group members must be same.
    
    http://www.ideserve.co.in/learn/anagram-grouping-in-a-sequence-using-trie
    http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
*/
public class TrieForGroupingAnagrams {
 
    // we are only dealing with keys with chars 'a' to 'z'
    final static int ALPHABET_SIZE = 26;
     
    class TrieNode
    {
         
        ArrayList<Integer> anagramIndices;
        TrieNode[] children;
         
        TrieNode()
        {
            children = new TrieNode[ALPHABET_SIZE];
            this.anagramIndices = new ArrayList();
        }
    }
 
    TrieNode root;
     
    TrieForGroupingAnagrams()
    {
        this.root = new TrieNode();
    }
 
    private int getIndex(char ch)
    {
        return ch - 'a';
    }
 
    public void insertIntoTrie(String key, int index, HashMap anagramNodes)
    {
        // null keys are not allowed
        if (key == null) return;
         
        key = key.toLowerCase();
         
        TrieNode currentNode = this.root;
        int charIndex = 0;
         
        while (charIndex < key.length())
        {
            int childIndex = getIndex(key.charAt(charIndex));
 
            if (childIndex < 0 || childIndex >= ALPHABET_SIZE)
            {
                System.out.println("Invalid Key");
                return;
            }
             
            if (currentNode.children[childIndex] == null)
            {
                currentNode.children[childIndex] = new TrieNode();
            }
             
            currentNode = currentNode.children[childIndex];
             
            charIndex  += 1;
        }
         
        if (charIndex == key.length())
        {
            currentNode.anagramIndices.add(index);
            anagramNodes.put(currentNode, currentNode.anagramIndices);
        }
         
        return;
    }
 
    public void printGroupedAnagrams(String[] sequence)
    {
        HashMap<TrieNode, ArrayList<Integer>> anagramNodes = new HashMap();
        for (int i = 0;  i < sequence.length; i++)
        {
            char[] charSequence = sequence[i].toCharArray(); 
            Arrays.sort(charSequence);
             
            insertIntoTrie(new String(charSequence), i, anagramNodes);
        }
 
        //Method 1 - to print nodes
        printFromMap(anagramNodes, sequence);
        System.out.println("Using tree itself:");
        //Method 2 - to print nodes without using hashmap(so hashmap can be removed
        printFromTree(root, sequence);
        System.out.println();
    }

    private void printFromMap(HashMap<TrieNode, ArrayList<Integer>> anagramNodes, String[] sequence) {
        Iterator<ArrayList<Integer>> mapItr = anagramNodes.values().iterator();
        while (mapItr.hasNext())
        {
            ArrayList<Integer> currentAnagramList = mapItr.next();
            for (int j = 0; j < currentAnagramList.size(); j++)
            {
                int indexIntoSequence = currentAnagramList.get(j);
                System.out.print(" " + sequence[indexIntoSequence]);
            }
            System.out.println("");
        }
    }
     
    public void printFromTree(TrieNode node, String[] sequence){
        if(node == null){
            return;
        }
        if(! node.anagramIndices.isEmpty() ){
            System.out.println();
            for (Integer indexIntoSequence : node.anagramIndices) {
                System.out.print(" " + sequence[indexIntoSequence]);
            }
        }
        for (TrieNode trieNode : node.children) {
            printFromTree(trieNode, sequence);
        }
    }
     
    public static void main(String[] args)
    {
        TrieForGroupingAnagrams tr = new TrieForGroupingAnagrams();
        String[] sequence = {"car", "ape", "meal", "pea", "male", "arc", "lame", "dog"};
        tr.printGroupedAnagrams(sequence);
         
    }
}