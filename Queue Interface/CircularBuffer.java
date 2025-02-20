class CircularBuffer {
    private int[] buffer;
    private int size;
    private int head;
    private int tail;
    private int count;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public void insert(int value) {
        if (count == size) {
            head = (head + 1) % size;
            count--;
        }
        buffer[tail] = value;
        tail = (tail + 1) % size;
        count++;
    }

    public int[] getBuffer() {
        int[] result = new int[count];
        int index = head;
        for (int i = 0; i < count; i++) {
            result[i] = buffer[index];
            index = (index + 1) % size;
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.println(java.util.Arrays.toString(buffer.getBuffer())); 
        buffer.insert(4);
        System.out.println(java.util.Arrays.toString(buffer.getBuffer())); 
    }
}