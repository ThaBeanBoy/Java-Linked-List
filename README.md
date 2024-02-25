# LinkedLists

## Introduction

These notes are derived from the [Data Structures and Algorithms in Java: International Student Version 6th Edition by Goodrich, M and Tamassia, R](https://www.directtextbook.com/isbn/9781118808573).

Similar to the array data structure, linked-list data structure is a linear data structure meant to storing 
things in a particular order. Arrays however have a few drawbacks, mainly:

- The capacity of an array is fixed when it's created.
- Insertion & deletions at interior positions of the array can be time-consuming &  if many elements need to be shifted.

A linked list resolves these issues through the use of nodes, where each node is connected to the next node.

## Node

A node in linked list serves 2 functions:

- **Store the value.** Similar to the array data structure, a linked list also stores multiple values (the way it stores the values in memory
  is different though). Since a linked list is made up of nodes, the linked list therefore stores the values.
- **Store a reference to the next node.** By storing the reference to the next node, we can travers all the nodes in the linked list by pointer hopping. 

![node](./docs/node.png)

## Linked List

As discussed in the previous section, a linked list is made up of nodes. The linked list will keep a reference to the **head node** 
(head node is the first node in the linked list). Without a reference to the head, there would be no way to locate the head node and 
all the nodes that follow it.

Another option is to keep a reference to the **tail node**(the last node in the list). The tail node is identified by having a null
as it's next reference. Keeping a reference to this node increases efficiency because you would not need to perform link-hopping to 
get to the tail node.

Another optional attribute of a linked list, is to keep count of all the nodes in the list, this way, there is no need to traverse the 
list and count each traversal.

![linked list](./docs/linked-list.png)

### Insertions

#### Inserting New Head Node

#### Inserting New Tail

#### Inserting in Interior of List

### Deletions

#### Deleting Head Node

#### Deleting Tail

#### Deleting Node in Interior of List

## UML

## Tests