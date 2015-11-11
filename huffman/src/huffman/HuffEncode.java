package huffman;

import java.lang.StringBuilder;

public class HuffEncode {
    private HuffTree tree;
    
    HuffEncode(HuffTree tree) {
        this.tree = tree;
    }
    
    //Given a string message, encode it in binary using the values assigned
    //in the HuffTree
    public String encodeMessage(String message) {
        StringBuilder buildEncodedMessage = new StringBuilder();
        
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            String encoding = this.tree.getEncodingForChar(currentChar);
            buildEncodedMessage.append(encoding);
        }
        
        return buildEncodedMessage.toString();
    }
}
