// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net
package fsctelecom;

import java.util.*;
import java.io.*;

class FSCTelecomAccounts{
  
    private Student head;
    
    // CONSTRUCTORS
    public FSCTelecomAccounts() {
        head = null;
    }

	public boolean isEmpty() {
		return head == null;
	}
  
	public boolean search(int ID) {
		return search(head, ID);
	}

	private boolean search(Student s, int ID) {
		Student helpPtr = s;
		while (helpPtr != null) {
			if (helpPtr.getID() == ID)
				return true;
			helpPtr = helpPtr.getNext();			
		}
		return false;
	}

	public Student findStudent(int ID) {
		return findStudent(head, ID);
	}

	private Student findStudent(Student s, int ID) {
		Student helpPtr = s;
		while (helpPtr != null) {
			if (helpPtr.getID() == ID)
				return helpPtr;
			helpPtr = helpPtr.getNext();			
		}
		return null;
	}
	public void PrintList() {
		PrintList(head);
	}

	private void PrintList(Student head) {
		Student helpPtr = head;
		while (helpPtr != null) {
			System.out.print(helpPtr.getID() + ", ");
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
	}
	public void ModifyAllNodes() {
		ModifyAllNodes(head);
	}

	private void ModifyAllNodes(Student head) {
		Student helpPtr = head;
		while (helpPtr != null) {
			helpPtr.setID(helpPtr.getID() + 10);

			helpPtr = helpPtr.getNext();
		}
	}

	public int sumNodes() {
		return sumNodes(head);
	}

	private int sumNodes(Student head) {
		// We need to traverse...so we need a help ptr
		Student helpPtr = head;
		int sum = 0; // counter
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Increase sum
			sum += helpPtr.getID();
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		return sum;
	}
	
	
	//
	// void | insert(int)
	//
	public void insert(Student tempStudent) {
		head = insert(head, tempStudent);
	}
	//
	// LLnode | insert(LLnode, value)
	//
	private Student insert(Student head, Student tempStudent) {
		// IF there is no list, newNode will be the first node, so just return it
		if (head == null || head.getID() > tempStudent.getID()) {
			tempStudent.setNext(head);
                        head = tempStudent;
			return head;
		}
		
		// ELSE, we have a list. Insert the new node at the correct location
		else {
			// We need to traverse to the correct insertion location...so we need a help ptr
			Student helpPtr = head;
			// Traverse to correct insertion point
			while (helpPtr.getNext() != null) {
				if (helpPtr.getNext().getID() > tempStudent.getID())
					break; // we found our spot and should break out of the while loop
				helpPtr = helpPtr.getNext();
			}
			// Now make the new node. Set its next to point to the successor node.
			// And then make the predecessor node point to the new node
                        tempStudent.setNext(helpPtr.getNext());
			helpPtr.setNext(tempStudent);
		}
		// Return head
		return head;
	}
	
	
	//
	// void | delete(int)
	//
	public void delete(int ID) {
		head = delete(head, ID);
	}
	//
	// LLnode | delete(LLnode, value)
	//
	private Student delete(Student head, int ID) {
		// We can only delete if the list has nodes (is not empty)
		if (!isEmpty()) {
			// IF the first node (at the head) has the data value we are wanting to delete
			// we found it. Delete by skipping the node and making head point to the next node.
			if (head.getID() == ID) {
				head = head.getNext();
			}
			// ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
			else {
				// We need to traverse to find the data we want to delete...so we need a help ptr
				Student helpPtr = head;
				// Traverse to correct deletion point
				while (helpPtr.getNext() != null) {
					if (helpPtr.getNext().getID() == ID) {
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

