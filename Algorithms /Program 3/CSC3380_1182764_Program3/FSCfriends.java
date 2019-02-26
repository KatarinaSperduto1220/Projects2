// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net

// package fscbook;

import java.util.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

class FSCfriends{
	// head: reference variable to the first node of the list
    private FSCfriend head;

    // CONSTRUCTORS
    // Create a new linked list fo type FSCfriends
    public FSCfriends(){
        head = null;
    }

// Method to check if the linked list has any nodes
	public boolean isEmpty() {
		return head == null;
	}

  // Method to search the linked list for a specific ID
  // boolean value returned

	public boolean search(int data) {
		return search(head, data);
	}
//Method to get the length of the linked list(number of friends)
  public int getCount() {
    FSCfriend temp = head;
    int count = 0;
    while (temp != null)
    {
        count++;
        temp = temp.getNext();
    }
    return count;
}

	private boolean search(FSCfriend p, int data) {
		FSCfriend helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getID() == data)
				return true;
			helpPtr = helpPtr.getNext();
		}
		return false;
	}


// Method used to locate a given node based on an ID
	public FSCfriend findNode(int data) {
		return findNode(head, data);
	}

	private FSCfriend findNode(FSCfriend p, int data) {
		FSCfriend helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getID() == data)
				return helpPtr;
			helpPtr = helpPtr.getNext();
		}
		return null;
	}

// Method used to print out all the nodes in the linked list and print the information to the output file
  public void PrintList2(PrintWriter output, FSCbookBST accounts) {
    PrintList2(head, output, accounts);
  }

  // void | PrintList(LLnode)

  private void PrintList2(FSCfriend head, PrintWriter output, FSCbookBST accounts) {
    // We need to traverse...so we need a help ptr
    FSCfriend helpPtr = head;
    FSCstudent tempStudent;
    // Traverse to correct insertion point
    while (helpPtr != null) {
      // Print the data value of the node
      int id = helpPtr.getID();
      tempStudent = accounts.findNode(id);
      output.printf("\t\tStudent ID %d, %s %s (%s)\n", id, tempStudent.getFirstName(), tempStudent.getLastName(), tempStudent.getDepartment()) ;
      // Step one node over
      helpPtr = helpPtr.getNext();
    }
  }

//Method to insert a new node of type FSCfriend into the linked list
	public void insert(int data) {
		head = insert(head, data);
	}
	//
	// LLnode | insert(LLnode, value)
	//
	private FSCfriend insert(FSCfriend head, int data) {
		// IF there is no list, newNode will be the first node, so just return it
		if (head == null || head.getID() > data) {
			head = new FSCfriend(data, head);
			return head;
		}

		// ELSE, we have a list. Insert the new node at the correct location
		else {
			// We need to traverse to the correct insertion location...so we need a help ptr
			FSCfriend helpPtr = head;
			// Traverse to correct insertion point
			while (helpPtr.getNext() != null) {
				if (helpPtr.getNext().getID() > data)
					break; // we found our spot and should break out of the while loop
				helpPtr = helpPtr.getNext();
			}
			// Now make the new node. Set its next to point to the successor node.
			// And then make the predecessor node point to the new node
			FSCfriend newNode = new FSCfriend(data, helpPtr.getNext());
			helpPtr.setNext(newNode);
		}
		// Return head
		return head;
	}


	//
// Method used to delete a specific node from the linked list by ID
	public void delete(int data) {
		head = delete(head, data);
	}
	//
	// LLnode | delete(LLnode, value)
	//
	private FSCfriend delete(FSCfriend head, int data) {
		// We can only delete if the list has nodes (is not empty)
		if (!isEmpty()) {
			// IF the first node (at the head) has the data value we are wanting to delete
			// we found it. Delete by skipping the node and making head point to the next node.
			if (head.getID() == data) {
				head = head.getNext();
			}
			// ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
			else {
				// We need to traverse to find the data we want to delete...so we need a help ptr
				FSCfriend helpPtr = head;
				// Traverse to correct deletion point
				while (helpPtr.getNext() != null) {
					if (helpPtr.getNext().getID() == data) {
						helpPtr.setNext(helpPtr.getNext().getNext());
						break; // we deleted the value and should break out of the while loop
					}
					helpPtr = helpPtr.getNext();
				}
			}
			// return the possibly updated head of the list
			return head;
		}
		return head;
	}
}
