// Katarina Sperduto
//3380 001
//katarinasperduto@bellsouth.net

 // package fscbook;
import java.util.*;
import java.io.*;


class FSCbookBST{
    private int ID;
    private FSCstudent root;

// Creating the root Node of type FSC Student
     public FSCbookBST() {
        root = null;
    }

// Method to see if the tree is empty
	public boolean isEmpty() {
		return root == null;
	}

// Method to search the tree for a specific ID
// boolean value returned

	public boolean search(int ID) {
		return search(root, ID);
	}

	private boolean search(FSCstudent  p, int ID) {
		if (p == null)
			return false;
		else {
			// if the ID we are searching for is found at p (at the current root)
			if (ID == p.getID())
				return true;
			else if (ID < p.getID())
				return search(p.getLeft(), ID);
			else
				return search(p.getRight(), ID);
		}
	}

//Method to insert a new node of type FSCstudent into the tree
	public void insert(int ID, String firstName, String lastName, String department) {
		FSCstudent newStudent = new FSCstudent(ID, firstName, lastName, department);
		root = insert(root, newStudent);
	}

	private FSCstudent insert(FSCstudent p, FSCstudent newStudent) {
    if (p == null)
			return newStudent;

		else {
			if (newStudent.getID() > p.getID()) {
				FSCstudent temp = insert(p.getRight(), newStudent);
				p.setRight(temp);
			}

			else {
				FSCstudent temp = insert(p.getLeft(), newStudent);
				p.setLeft(temp);
			}
		}
		return p;
	}

//Method to print the nodes (with all their information) to the output file in order based on ID numbers
	public void printOrder(PrintWriter output) {
		printOrder(root, output);
	}

	private void printOrder(FSCstudent  p, PrintWriter output) {
		if (p != null) {
      // output.println(p.getID() + ", ");
      printOrder(p.getLeft(), output);
      output.printf("\t\tID %d, %s %s, (%s)\n", p.getID(), p.getFirstName(), p.getLastName(), p.getDepartment());
      printOrder(p.getRight(), output);
		}
	}

//Method to delete a FSCstudent from the FSCbookBST (tree)
// the save variables were added incase we are "deleting" a node with two children (which is done bycopying the information from the min of the right subTree of that node)
// and inputing that information  into the "deleted node".
// All the save variablkes are needed because without them we would lose information while copying and replacing said information
	public void delete(int ID) {
		root = delete(root, ID);
	}

	private FSCstudent delete(FSCstudent  p, int ID) {
		FSCstudent node2delete, newnode2delete, node2save, parent;
		int saveValue;
    String saveFirst;
    String saveLast;
    String saveDepartment;
    FSCfriends saveFriends;
    int saveNumFriends;
		node2delete = findNode(p, ID);
		if (node2delete == null)
			return root;
    deleteAll(ID);
		parent = parent(p, node2delete);
		if (isLeaf(node2delete)) {
			if (parent == null)
				return null;
			if (ID < parent.getID())
				parent.setLeft(null);
			else
				parent.setRight(null);
			return p;
		}
		if (hasOnlyLeftChild(node2delete)) {
			if (parent == null)
				return node2delete.getLeft();
			if (ID < parent.getID())
				parent.setLeft(parent.getLeft().getLeft());
			else
				parent.setRight(parent.getRight().getLeft());
			return p;
		}
		if (hasOnlyRightChild(node2delete)) {
			if (parent == null)
				return node2delete.getRight();
			if (ID < parent.getID())
				parent.setLeft(parent.getLeft().getRight());
			else
				parent.setRight(parent.getRight().getRight());
			return p;
		}
		newnode2delete = minNode(node2delete.getRight());
		saveValue = newnode2delete.getID();
    saveFirst = newnode2delete.getFirstName();
    saveLast = newnode2delete.getLastName();
    saveDepartment = newnode2delete.getDepartment();
    saveFriends = newnode2delete.getMyFriends();
    saveNumFriends = newnode2delete.getNumFriends();

		p = delete(p, saveValue);

    newnode2delete.setNumFriends(saveNumFriends);
		node2delete.setID(saveValue);
    node2delete.setFirstName(saveFirst);
    node2delete.setLastName(saveLast);
    node2delete.setDepartment(saveDepartment);
    node2delete.setMyFriends(saveFriends);
		return p;
	}


    public void deleteAll(int id){
      deleteAll(root, id);
    }
    private void deleteAll(FSCstudent  p, int id){
      if(p != null){
        deleteAll(p.getRight(), id);
        p.getMyFriends().delete(id);
        deleteAll(p.getLeft(), id);
      }
    }

// Method to get the smallest leaf node of a given tree or subtree
    public FSCstudent  minNode(FSCstudent  root) {
        if (root == null) {
            return null;
        }
        else {
            if (root.getLeft() == null) {
                return root;
            }
            else {
                return minNode(root.getLeft());
            }
        }
    }


// Method to get the largest leaf  node of a given tree or subtree
    public FSCstudent  maxNode(FSCstudent  root) {
        if (root == null) {
            return null;
        }
        else {
            if (root.getRight() == null) {
                return root;
            }
            else {
                return maxNode(root.getRight());
            }
        }
    }


// Method used to locate a given node based on an ID
	public FSCstudent  findNode(int ID) {
		return findNode(root, ID);
	}

	private FSCstudent findNode(FSCstudent  p, int ID) {
		if (p == null)
			return null;
		else {
			// if the ID we are searching for is found at p (at the current root)
			if (ID == p.getID())
				return p;
			else if (ID < p.getID())
				return findNode(p.getLeft(), ID);
			else
				return findNode(p.getRight(), ID);
		}
	}

// Method used to locate a node based on a first and last name incase we are not given an ID number
  public FSCstudent findNodeByName(String lastName, String firstName) {
    return findNodeByName(root, lastName, firstName);
  }

  private FSCstudent findNodeByName(FSCstudent p, String lastName, String firstName) {
    if (p == null)
      return null;
    else {
     if (lastName.compareTo(p.getLastName()) < 0)
        return findNodeByName(p.getLeft(), lastName, firstName);
     else if(lastName.compareTo(p.getLastName()) > 0 )
        return findNodeByName(p.getRight(), lastName, firstName);
     else if(lastName.compareTo(p.getLastName()) == 0){
      if(firstName.compareTo(p.getFirstName()) == 0){
        return p;
      }
      else if (lastName.compareTo(p.getFirstName()) < 0)
            return findNodeByName(p.getLeft(), lastName, firstName);
      else if(lastName.compareTo(p.getFirstName()) > 0 )
            return findNodeByName(p.getRight(), lastName, firstName);
    }
    return null;
  }
}

// Method to locate the parent node of a given child
	public FSCstudent  parent(FSCstudent  p) {
		return parent(root, p);
	}

	private FSCstudent  parent(FSCstudent  root, FSCstudent  p) {
		// Take care of NULL cases
		if (root == null || root == p)
			return null; // because there is on parent

		// If root is the actual parent of node p
		if (root.getLeft()==p || root.getRight()==p)
			return root; // because root is the parent of p

		// Look for p's parent in the left side of root
		if (p.getID() < root.getID())
			return parent(root.getLeft(), p);

		// Look for p's parent in the right side of root
		else if (p.getID() > root.getID())
			return parent(root.getRight(), p);
		else
			return null;
	}

  // Method to count the leaf nodes of the tree (AKA nodes that have no children)
  public int countLeafNodes() {
      return countLeafNodes(root);
	}

	private int countLeafNodes(FSCstudent  p) {
		if(p != null){
                    if(p.getLeft() == null && p.getRight() == null){
                       return 1;
                    }
                    else{
                        return 0 + countLeafNodes(p.getLeft())+  countLeafNodes(p.getRight());
                    }
                }
                else{
                    return 0;
                }
	}

// Method to check if the given node is a leaf node
// Used in the delete Method
	public boolean isLeaf(FSCstudent  p) {
		return (p.getLeft()==null && p.getRight()==null);
	}
// Method to check if the given node has only one child
// Used in the delete Method
	public boolean hasOnlyLeftChild(FSCstudent  p) {
		return (p.getLeft()!=null && p.getRight()==null);
	}
  // Method to check if the given node has two children
  // Used in the delete Method
	public boolean hasOnlyRightChild(FSCstudent  p) {
		return (p.getLeft()==null && p.getRight()!=null);
	}
}
