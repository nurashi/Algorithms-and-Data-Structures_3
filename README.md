# Algorithms-and-Data-Structures_3

this repository contains implementation of MyHashTable and Binary Search Tree (BST)

## MyHashTable<K, V>

- custom hash table implemented with array of chains (linked lists)
- put(), get(), remove(), contains(), getKey() methods are implemented
- custom hash() function used to calculate bucket index
- separate MyTestingClass created with own hashCode() method (not using Objects.hash())
- added 10000 random elements to test distribution in buckets

##  MyTestingClass

- simple class with id field
- own hashCode() method created to make good uniform distribution
- used random id's to generate random keys

## BST<K, V>

- binary search tree without recursion
- methods implemented: put(), get(), delete()
- iterator implemented using in-order traversal (without recursion)
- size() method added to count number of nodes
- during iteration can access both key and value easily


