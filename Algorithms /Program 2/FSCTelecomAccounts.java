// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net
// package fsctelecom;

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

	public void insert(Student tempStudent) {
		head = insert(head, tempStudent);
	}
	private Student insert(Student head, Student tempStudent) {
		if (head == null || head.getID() > tempStudent.getID()) {
			tempStudent.setNext(head);
                        head = tempStudent;
			return head;
		}

		else {
			Student helpPtr = head;
			while (helpPtr.getNext() != null) {
				if (helpPtr.getNext().getID() > tempStudent.getID())
					break;
				helpPtr = helpPtr.getNext();
			}
      tempStudent.setNext(helpPtr.getNext());
			helpPtr.setNext(tempStudent);
		}
		return head;
	}

	public void delete(int ID) {
		head = delete(head, ID);
	}

	private Student delete(Student head, int ID) {
		if (!isEmpty()) {
			if (head.getID() == ID) {
				head = head.getNext();
			}
			else {
				Student helpPtr = head;
				while (helpPtr.getNext() != null) {
					if (helpPtr.getNext().getID() == ID) {
						helpPtr.setNext(helpPtr.getNext().getNext());
						break;
					}
					helpPtr = helpPtr.getNext();
				}
			}
			return head;
		}
		return head;
	}
    }
