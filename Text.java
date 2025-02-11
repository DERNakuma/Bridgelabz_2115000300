class TextNode {
    String text;
    TextNode prev, next;

    public TextNode(String text) {
        this.text = text;
        this.prev = this.next = null;
    }
}
class TextEditor {
    private TextNode head, tail, current;
    private final int maxHistory;
    private int size;

    public TextEditor(int maxHistory) {
        this.maxHistory = maxHistory;
        this.head = this.tail = this.current = null;
        this.size = 0;
    }

    public void addState(String newText) {
        TextNode newNode = new TextNode(newText);
        if (current != null) {
            newNode.prev = current;
            current.next = newNode;
        } else {
            head = newNode;
        }
        current = newNode;
        tail = newNode;
        size++;
        if (size > maxHistory) removeOldestState();
    }

    private void removeOldestState() {
        if (head == null || head == current) return;
        head = head.next;
        if (head != null) head.prev = null;
        size--;
    }

    public void undo() {
        if (current != null && current.prev != null) current = current.prev;
        else System.out.println("No more undo available.");
    }

    public void redo() {
        if (current != null && current.next != null) current = current.next;
        else System.out.println("No more redo available.");
    }

    public void displayCurrentState() {
        System.out.println("Current Text: " + (current != null ? current.text : "No text available"));
    }
}

public class Text {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
        editor.undo();
        editor.undo();
        editor.displayCurrentState();
    }
}