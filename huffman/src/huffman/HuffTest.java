package huffman;

public class HuffTest {
    public static void main(String[] args) {
        HuffTree tree = new HuffTree();
        tree = tree.sampleTree();
        
        HuffEncode encoder = new HuffEncode(tree);
        HuffDecode decoder = new HuffDecode(tree);
        
        String messageToEncode = "When are we getting drinks?";
        String encodedMessage = encoder.encodeMessage(messageToEncode);
        System.out.println(encodedMessage);
        
        String decodedMessage = decoder.decodeMessage(encodedMessage);
        System.out.println(decodedMessage);
    }
}
