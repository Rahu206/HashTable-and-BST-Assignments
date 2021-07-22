package com.hashTable;

public class MyMapNode<K ,V> {
	K key;
	V value;
    MyMapNode<K,V> next;
    
	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public MyMapNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
    

}
