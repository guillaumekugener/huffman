package huffman;

import java.lang.StringBuilder;

public class HuffDecode {
    private HuffTree tree;
    
    HuffDecode(HuffTree tree) {
        this.tree = tree;
    }
    
    //Given a string in binary, decode the message in the string
    public String decodeMessage(String message) {
        StringBuilder finalMessage = new StringBuilder();
        
        StringBuilder currentBits = new StringBuilder();
        
        for (int i = 0; i < message.length(); i++) {
            char bit = message.charAt(i);
            currentBits.append(bit);
            String currentBitString = currentBits.toString();
            char value = this.tree.getNodeValue(currentBitString);
            
            if (value != '\0') {
                finalMessage.append(value);
                currentBits.delete(0, currentBitString.length());
            }
            
        }
        
        return finalMessage.toString();
    }
}
