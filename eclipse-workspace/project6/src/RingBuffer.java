public class RingBuffer {
	
	// Creates the instance variables needed
	private double[] rb;
	private int capacity;
	private int size;
	private int first;
	
	/**
	 * Initializes a new double array of a certain capacity
	 * @param initialCapacity, sets the capacity of the array
	 */
	public RingBuffer(int initialCapacity) {
		rb = new double[initialCapacity];
		first = 0;
		capacity = initialCapacity;
	}
	
	/**
	 * Returns the number of items in the buffer
	 * @return int, the size
	 */
	public int size() { 
		return size;
	}
	
	/** 
	 * Returns true if queue is empty
	 * @return boolean, true if empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/** 
	 * Returns true if queue is full
	 * @return boolean, true if full
	 */	
	public boolean isFull() {
		return size == capacity;
	}
	
	/** 
	 * Takes an item from the user and insert it to the back
	 * @param int, the item to be inserted
	 */
	public void enqueue(double item) {
		if (isFull()) throw new RuntimeException("Buffer is full");
		else{ 
			rb[(first + size) % capacity] = item; 
			size++; 
		}

	}
	/**
	 * Delete and return the item from the front
	 * @return int, the first item in the array
	 */
	public double deQueue() {
		if (isEmpty()) throw new RuntimeException("Queue is empty");
		else {
			int temp = first;
			first++; 
			size--; 
			if (first == capacity) first = 0; 
			return rb[temp]; 
		}
	}
	
	/** 
	 * Returns the the first element from my queue
	 * @return int, the first element
	 */
	public double peek() {
		return rb[first];
	}
	
	// Testing
	public static void main(String[] args) {
		   int N = Integer.parseInt(args[0]);
	        RingBuffer buffer = new RingBuffer(N);
	        for (int i = 1; i <= N; i++) {
	            buffer.enqueue(i);
	        }
	        double t = buffer.deQueue();
	        buffer.enqueue(t);
	        System.out.println("Size after wrap-around is " + buffer.size());
	        while (buffer.size() >= 2) {
	            double x = buffer.deQueue();
	            double y = buffer.deQueue();
	            buffer.enqueue(x + y);
	        }
	        System.out.println(buffer.peek());
	    }
	
} // End class