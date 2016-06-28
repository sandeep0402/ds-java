package ds.trees;

import java.util.HashMap;
import java.util.Map;

public class TrieExample{
	TrieNode root = new TrieNode('0');
	
	public static void main(String[] args) {
		TrieExample dict = new TrieExample();
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");
        dict.insert("basement");
 
        String input = "ca";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input)); 
        
        input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
 
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));                      
 
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
 
        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
                      
        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));
        
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input)); 
    }
	
	public void insert(String word){
		char[] chars = word.toCharArray();
		int length = chars.length;
		TrieNode crawl = root;
		for(int i=0; i<length; i++){
			char ch = chars[i];
			if(crawl.getChildren().containsKey(ch)){
				crawl = crawl.getChildren().get(ch);
			}else{
				TrieNode node = new TrieNode(ch);
				crawl.getChildren().put(ch, node);
				crawl = node;
			}
		}
		crawl.setIsEnd(true);
	}
	public String getMatchingPrefix(String word){
		char[] chars = word.toCharArray();
		int length = chars.length;
		int depthCount = 0;
		String result = "";
		TrieNode crawl = root;
		for(int i = 0; i < length; i++){
			char ch = chars[i];
			if(crawl.getChildren().containsKey(ch)){
				result += ch;
				System.out.println("REsult "+ result);
				crawl = crawl.getChildren().get(ch);
				if(crawl.getIsEnd()){
					depthCount = i + 1;
				}
				//System.out.println("REsult "+ result+ " , depth "+depthCount);
			}else{
				break;
			}
		}
		if(!crawl.getIsEnd()){
			//System.out.println("depthCount : "+ depthCount);
			return result.substring(0, depthCount);
		}else 
			return result;
	}
	class TrieNode{
		public char key;
		public boolean isEnd;
		public Map<Character, TrieNode> children;
		TrieNode(char key){
			this.key = key;
			this.children = new HashMap<>();
		}
		public char getKey() {
			return key;
		}
		public void setKey(char key) {
			this.key = key;
		}
		public boolean getIsEnd() {
			return isEnd;
		}
		public void setIsEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}
		public Map<Character, TrieNode> getChildren() {
			return children;
		}
		public void setChildren(Map<Character, TrieNode> children) {
			this.children = children;
		}
		
	}
}