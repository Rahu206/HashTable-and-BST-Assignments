package com.hashTable;

import java.util.LinkedList;

public class HashTableImpli<K ,V> {

		private LinkedList<MyMapNode<K, V>> myBucketArray;
		private int numOfBuckets;
		    // size of linked list
		private int size;
		public HashTableImpli() {
			myBucketArray = new LinkedList<>();
			numOfBuckets = 8;
			size = 0;
			for (int i = 0; i < numOfBuckets; i++) {
				myBucketArray.add(null);
			}
		}
		public int size() {
			return size;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		private int bucketIndex(K key) {
			int hashCode = Math.abs(key.hashCode());
			int index = hashCode % numOfBuckets;
			return index;
		}

		/**
		 * This method is returning value of key
		 * @param key : First argument of method
		 * @return value for the key
		 */
		public V get(K key) {
			// find head of bucket for given key
			int bucketIndex = bucketIndex(key);
			MyMapNode<K, V> head = myBucketArray.get(bucketIndex);
			// search key in bucket
			while (head != null) {
				if (head.key.equals(key))
					return head.value;
				head = head.next;
			}
			return null;    // If key not found
		}
		
		/**
		 * function of adding key and value
		 * @param key : first argument of method
		 * @param value : second argument of method
		 */
		public void add(K key, V value) {
			int bucketIndex = bucketIndex(key);
			// get head of chain
			MyMapNode<K, V> head = myBucketArray.get(bucketIndex);
			// Check if key is already present
			while (head != null) {
				if (head.key.equals(key)) {
					head.value = value;
					return;
				}
				head = head.next;
			}
			// Insert key in chain
			size++;
			head = myBucketArray.get(bucketIndex);
			MyMapNode<K, V> newNode = new MyMapNode<K, V>(key, value);
			newNode.next = head;
			myBucketArray.set(bucketIndex, newNode);
			// If load factor goes beyond threshold, then double hash table size
			if ((1.0 * size) / numOfBuckets >= 0.7) {
				LinkedList<MyMapNode<K, V>> temp = myBucketArray;
				myBucketArray = new LinkedList<>();
				numOfBuckets = 2 * numOfBuckets;
				size = 0;
				for (int i = 0; i < numOfBuckets; i++) {
					myBucketArray.add(null);

					for (MyMapNode<K, V> headNode : temp) {
						while (headNode != null) {
							add(headNode.key, headNode.value);
							headNode = headNode.next;
						}
					}
				}
			}
		}

		//This method displays the key of bucket along with it's value it occurred. 
		public void show() {
			for (int i = 0; i < myBucketArray.size(); i++) {
				MyMapNode<K, V> head = myBucketArray.get(i);
				while (head != null) {
					System.out.println(head.key + "-" + head.value);
					head = head.next;
				}
			}
		}
		public static void main(String[] args) {
			HashTableImpli<String, Integer> hashMap = new HashTableImpli<>();
			String str = "To be or not or to be";
			String[] stringArray = str.split(" ");
			for (int i = 0; i < stringArray.length; i++) {
				Integer value = hashMap.get(stringArray[i]);
				value = (value == null) ? Integer.valueOf(1) : value + 1;
				hashMap.add(stringArray[i].toString(), value);
			}
			hashMap.show();
		}

	}
	
	
