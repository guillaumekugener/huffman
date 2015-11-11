package huffman;

import java.util.HashMap;

public class HuffTree {
    private Node root;
    private HashMap<Character, String> encodingMap;
    
    //Node class for the nodes in the tree
    private static class Node {
        private Node parent;
        private Node left;
        private Node right;
        private char value;
        
        Node(Node parent, Node left, Node right, char value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.value = value;
        }
        
        //Assign a value to the node
        public void assignValue(char value) {
            this.value = value;
        }
        
        //Assign a parent to the node
        public void addParent(Node parent) {
            this.parent = parent;
        }
        
        //Add the left child ('0') to the node
        public void addLeftChild(Node child) {
            this.left = child;
        }
        
        //Add the right child ('1') to the node
        public void addRightChild(Node child) {
            this.right = child;
        }
        
        //Get this node's parent
        public Node getParent() {
            return this.parent;
        }
        
        //Get this node's left child ('0')
        public Node getLeftChild() {
            return this.left;
        }
        
        //Get this node's right child ('1')
        public Node getRightChild() {
            return this.right;
        }
        
        //Get the value assigned to this node, if it has one
        //otherwise return the null character
        public char getValue() {
            return this.value;
        }
    }
    
    HuffTree () {
        this.root = new Node(null, null, null, '\0');
        this.encodingMap = new HashMap<Character, String>();
    }
    
    //Add a new node to the tree
    public void addNode(String path, char value) {
        //Add the node mapping to the encoding map for when we encode messages
        this.encodingMap.put(value, path);
        
        //Iterate through the path until you reach the node you want to add
        //If a node along the path does not exist, we also create it 
        Node currentNode = this.root;
        for (int i =0; i < path.length(); i++) {
            if (path.charAt(i) == '0') {
                //Go left
                Node child = currentNode.getLeftChild();
                if (child == null) {
                    child = new Node(currentNode, null, null, '\0');
                    currentNode.addLeftChild(child);
                    currentNode = child;
                }
                else {
                    currentNode = child;
                }
            }
            else if (path.charAt(i) == '1') {
                //Go right
                Node child = currentNode.getRightChild();
                if (child == null) {
                    child = new Node(currentNode, null, null, '\0');
                    currentNode.addRightChild(child);
                    currentNode = child;
                }
                else {
                    currentNode = child;
                }
            }
            else {
                System.out.println("The path supplied had an incorrect value");
            }
        }
        currentNode.assignValue(value);
    }
    
    //Given a character, return its corresponding binary encoding
    public String getEncodingForChar(char c) {
        return this.encodingMap.get(c);
    }
    
    //Given binary string encoding, return the value of that encoding
    //Returns the null character if no value matches the encoding
    public char getNodeValue(String path) {
        char c = '\0';
        Node currentNode = this.root;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '0') {
                currentNode = currentNode.getLeftChild();
            }
            else if (path.charAt(i) == '1') {
                currentNode = currentNode.getRightChild();
            }
            else {
                break;
            }
        }
        c = currentNode.getValue();
        return c;
    }
    
    public HuffTree sampleTree() {
        //Create the sample tree
        HuffTree fakeTree = new HuffTree();
        fakeTree.addNode("000", 'e');
        fakeTree.addNode("110", ' ');
        fakeTree.addNode("0010", 's');
        fakeTree.addNode("0011", 'h');
        fakeTree.addNode("0100", 'i');
        fakeTree.addNode("0110", 'n');
        fakeTree.addNode("0111", 'o');
        fakeTree.addNode("1001", 'a');
        fakeTree.addNode("1010", 't');
        fakeTree.addNode("10000", 'l');
        fakeTree.addNode("10111", 'd');
        fakeTree.addNode("11111", 'r');
        fakeTree.addNode("010100", 'p');
        fakeTree.addNode("010101",',');
        fakeTree.addNode("010110", 'y');
        fakeTree.addNode("100010", 'g');
        fakeTree.addNode("100011", 'f');
        fakeTree.addNode("101101", 'w');
        fakeTree.addNode("111000", 'm');
        fakeTree.addNode("111001", 'c');
        fakeTree.addNode("111011", '\n');
        fakeTree.addNode("111100", 'u');
        fakeTree.addNode("1011000", 'v');
        fakeTree.addNode("1110100", '.');
        fakeTree.addNode("1110101", 'b');
        fakeTree.addNode("11110110",'"');
        fakeTree.addNode("11110111", 'k');
        fakeTree.addNode("010111101", '-');
        fakeTree.addNode("010111111", 'P');
        fakeTree.addNode("101100100", 'A');
        fakeTree.addNode("101100101", 'T');
        fakeTree.addNode("111101000",'\'');
        fakeTree.addNode("111101010",'I');
        fakeTree.addNode("0101110001",'j');
        fakeTree.addNode("0101110010",'z');
        fakeTree.addNode("0101110011", 'q');
        fakeTree.addNode("0101110111", 'W');
        fakeTree.addNode("0101111000", 'S');
        fakeTree.addNode("0101111001", 'R');
        fakeTree.addNode("0101111100", '?');
        fakeTree.addNode("0101111101", 'M');
        fakeTree.addNode("1011001101", 'B');
        fakeTree.addNode("1011001110", 'N');
        fakeTree.addNode("1011001111", 'x');
        fakeTree.addNode("1111010010", '!');
        fakeTree.addNode("1111010111", 'H');
        fakeTree.addNode("01011100000", 'V');
        fakeTree.addNode("01011100001", ';');
        fakeTree.addNode("01011101000", 'K');
        fakeTree.addNode("01011101001",'Y');
        fakeTree.addNode("01011101011", 'G');
        fakeTree.addNode("10110011000",'O');
        fakeTree.addNode("11110100110", 'F');
        fakeTree.addNode("11110100111",'D');
        fakeTree.addNode("11110101100",'C');
        fakeTree.addNode("11110101101",'E');
        fakeTree.addNode("010111010101",'(');
        fakeTree.addNode("010111011000", ')');
        fakeTree.addNode("010111011001",'X');
        fakeTree.addNode("010111011010",'L');
        fakeTree.addNode("101100110011",':');
        fakeTree.addNode("0101110101000",'*');
        fakeTree.addNode("0101110101001",'J');
        fakeTree.addNode("0101110110111",'1');
        fakeTree.addNode("01011101101100",'2');
        fakeTree.addNode("01011101101101",'0');
        fakeTree.addNode("10110011001000",'8');
        fakeTree.addNode("10110011001011",'U');
        fakeTree.addNode("101100110010011",'Z');
        fakeTree.addNode("1011001100100100",'7');
        fakeTree.addNode("1011001100100101",'5');
        fakeTree.addNode("1011001100101000",'6');
        fakeTree.addNode("1011001100101001",'3');
        fakeTree.addNode("10110011001010100", '/');
        fakeTree.addNode("10110011001010101",'9');
        fakeTree.addNode("10110011001010110",'0');
        fakeTree.addNode("101100110010101111",'4');
        fakeTree.addNode("10110011001010111011",'[');
        fakeTree.addNode("101100110010101110000",'#');
        fakeTree.addNode("101100110010101110001",']');
        fakeTree.addNode("101100110010101110010",'%');
        fakeTree.addNode("101100110010101110011",'=');
        fakeTree.addNode("101100110010101110100",'@');
        fakeTree.addNode("101100110010101110101",'$');
       
        return fakeTree;
    }
}
