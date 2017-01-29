package ds.linkedlists;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Implement Least Recently Used (LRU) cache
 *
 * http://www.ideserve.co.in/learn/lru-cache-implementation
 * https://www.quora.com/What-is-the-best-way-to-Implement-an-LRU-Cache
 */
public class LRUCache {
     
    private LRUDoublyLinkedList pageList;
    private Map<Integer, LRuNode> pageMap;
    private final int cacheSize;
     
    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        pageList = new LRUDoublyLinkedList(cacheSize);
        pageMap = new HashMap<Integer, LRuNode>();
    }
     
    public void accessPage(int pageNumber) {
        LRuNode pageNode = null;
        if(pageMap.containsKey(pageNumber)) {
            // If page is present in the cache, move the page to the start of list
            pageNode = pageMap.get(pageNumber);
            pageList.movePageToHead(pageNode);
        } else {
            // If the page is not present in the cache, add the page to the cache
            if(pageList.getCurrSize() == pageList.getSize()) {
                // If cache is full, we will remove the tail from the cache pageList
                // Remove it from map too
                pageMap.remove(pageList.getTail().getPageNumber());
            }
            pageNode = pageList.addPageToList(pageNumber);
            pageMap.put(pageNumber, pageNode);
        }
    }
     
    public void printCacheState() {
        pageList.printList();
        System.out.println();
    }
 
    public static void main(String[] args) {
        int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
    }
}
 
class LRUDoublyLinkedList {
     
    private final int size;
    private int currSize;
    private LRuNode head;
    private LRuNode tail;
 
    public LRUDoublyLinkedList(int size) {
        this.size = size;
        currSize = 0;
    }
 
    public LRuNode getTail() {
        return tail;
    }
 
    public void printList() {
        if(head == null) {
            return;
        }
        LRuNode tmp = head;
        while(tmp != null) {
            System.out.print(tmp);
            tmp = tmp.getNext();
        }
    }
 
    public LRuNode addPageToList(int pageNumber) {
        LRuNode pageNode = new LRuNode(pageNumber);       
        if(head == null) {
            head = pageNode;
            tail = pageNode; 
            currSize = 1;
            return pageNode;
        } else if(currSize < size) {
            currSize++;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
        return pageNode;
    }
 
    public void movePageToHead(LRuNode pageNode) {
        if(pageNode == null || pageNode == head) {
            return;
        }
 
        if(pageNode == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        }
         
        LRuNode prev = pageNode.getPrev();
        LRuNode next = pageNode.getNext();
        prev.setNext(next);
 
        if(next != null) {
            next.setPrev(prev);
        }
 
        pageNode.setPrev(null);
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;    
    }
 
    public int getCurrSize() {
        return currSize;
    }
 
    public void setCurrSize(int currSize) {
        this.currSize = currSize;
    }
 
    public LRuNode getHead() {
        return head;
    }
 
    public void setHead(LRuNode head) {
        this.head = head;
    }
 
    public int getSize() {
        return size;
    }   
}
 
class LRuNode {
     
    private int pageNumber;
    private LRuNode prev;
    private LRuNode next;
     
    public LRuNode(int pageNumber) {
        this.pageNumber = pageNumber;
    }
 
    public int getPageNumber() {
        return pageNumber;
    }
 
    public void setPageNumber(int data) {
        this.pageNumber = data;
    }
     
    public LRuNode getPrev() {
        return prev;
    }
 
    public void setPrev(LRuNode prev) {
        this.prev = prev;
    }
 
    public LRuNode getNext() {
        return next;
    }
 
    public void setNext(LRuNode next) {
        this.next = next;
    }
     
    public String toString() {
        return pageNumber + "  ";
    }
}