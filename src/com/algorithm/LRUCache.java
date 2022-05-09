package com.algorithm;

import java.util.*;

public class LRUCache {
    private int size;
    private Map<CacheKey, String> cacheMap = new HashMap<>(size);
    private CacheKey first;
    private CacheKey last;

    public LRUCache(int size) {
        this.size = size;
    }

    public void addEntry(String key, String value) {
        if(isCacheFull()){
            System.out.println("Cache is full !");
            deleteFirstElementInCache();
        }
        if (cacheMap.size() == 0) { //first = last => new entry
            CacheKey cacheKey = new CacheKey(key, null, null);
            cacheMap.put(cacheKey, value);
            first = cacheKey;
            last = cacheKey;
        } else {// adding new entry at last
            CacheKey cacheKey = new CacheKey(key, last, null);
            makeCacheKeyLastElement(cacheKey);
            cacheMap.put(cacheKey, value);
        }

    }

    private void deleteFirstElementInCache() {
        CacheKey firstKey = first;
        System.out.println("Previous first key -->"+first.key);
        first.next.previous = null;
        first = first.next;
        System.out.println("Deleting element with key -->"+firstKey.key);
        cacheMap.remove(firstKey);
    }

    public String getEntry(String key) {
        Set<Map.Entry<CacheKey, String>> setEntry = cacheMap.entrySet();
        final CacheKey cacheKey;
        Optional<Map.Entry<CacheKey, String>> cacheKeyEntry = setEntry.stream()
                .filter(entry -> entry.getKey().equals(new CacheKey(key, null, null)))
                .findFirst();
        cacheKey = cacheKeyEntry.get().getKey();

        if (cacheKey.previous != null && cacheKey.next != null) {
            cacheKey.previous.next = cacheKey.next.previous;
            //System.out.println("New first -->"+first.key);

        } else if (cacheKey.previous == null) { // if cacheKey is first element or size is one
            if(first.next != null){
                first = first.next;
            }
        }
        makeCacheKeyLastElement(cacheKey);

        return cacheKeyEntry.get().getValue();
    }

    private void makeCacheKeyLastElement(CacheKey cacheKey) {
        cacheKey.previous = last;
        cacheKey.next = null;
        last.next = cacheKey;
        last = cacheKey;
        //System.out.println("New last -->"+last.key);
    }

    public boolean isCacheFull(){
        return cacheMap.size() >= size ;
    }

    private void printMap() {
        System.out.println("Printing key in order -->");
        CacheKey key = first;
        while(key != null){
            System.out.print(" Key -->"+key.key);
            key = key.next;
        }
        /*Set<Map.Entry<CacheKey,String>> mapSet = cacheMap.entrySet();
        mapSet.stream().forEach((entry)-> System.out.print(" Key - "+entry.getKey().key));*/
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.addEntry("A", "1");
        cache.addEntry("B", "2");
        cache.addEntry("C", "3");
        cache.addEntry("D", "4");
        cache.printMap();

        System.out.println(cache.getEntry("B"));
        System.out.println(cache.getEntry("C"));
        System.out.println(cache.getEntry("D"));
        System.out.println(cache.getEntry("A"));
        cache.printMap();

        cache.addEntry("E","5");
        cache.addEntry("F","6");

        cache.printMap();
    }

}


class CacheKey {
    String key;
    CacheKey previous;
    CacheKey next;

    public CacheKey(String key, CacheKey previous, CacheKey next) {
        this.key = key;
        this.previous = previous;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheKey cacheKey = (CacheKey) o;
        return Objects.equals(key, cacheKey.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
