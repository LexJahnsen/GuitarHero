import java.util.*;

public class GuitarString {	
	
	// Creates instance variables
	private RingBuffer buffer; // Creates a ring buffer
	private int size;
	private int counter = 0;

	/**
	 * Creates a GuitarString based off of RingBuffer, filled with 0's
	 * @param frequency, the frequency for calculating the capacity N
	 */
	public GuitarString(double frequency) {
		int N = (int) Math.ceil(44100/frequency);
		buffer = new RingBuffer(N);
		size = buffer.size();
		for (int i = 0; i< N; i++) {
			buffer.enqueue(0);
		}
	}
	
	/**
	 * Creates a GuitarString based off of an array, filled with the values in that array
	 * @param init, the array used
	 */
	public GuitarString(double[] init) {
		buffer = new RingBuffer(init.length);
		size = buffer.size();
		for (int i = 0; i< size; i++) {
			buffer.enqueue(init[i]);
		}
	}
	
	/**
	 * Sets the buffer to white noise
	 */
	public void pluck() {
		for (int i = 0; i <= size; i++) {
			Random random = new Random();
			double value = (random.nextDouble(0.5));
			buffer.deQueue();
			buffer.enqueue(value);
		}
	}
	
	/**
	 * Moves the simulation forward one step,
	 * as well as adding to the counter of how many times the funcation is called
	 */
	public void tic() {	
		buffer.enqueue(0.994 * ((buffer.deQueue() + buffer.peek())/2));
		counter++;
	} 
	
	/**
	 * @return the current sample
	 */
	public double sample() {
		return buffer.peek();
	}
	
	/**
	 * @return the number of times tic was called
	 */
	public int time() {
		return counter;
	}

	// Testing 
	public static void main(String[] args) {
        }
	}