public class GuitarHero {
      public static void main(String[] args) {
    	  
    	  // Create an array of GuitarStrings with various frequencies
    	  String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    	  GuitarString[] keyboard_array = new GuitarString [keyboard.length()];
    	  for (int i = 0; i < keyboard_array.length; i++) {
    		  keyboard_array[i] = new GuitarString(440 *(Math.pow(1.05956, (i-24))));
    	  }
    	  
    	  
          while (true) {
              // check if the user has typed a key; if so, process it   
              if (StdDraw.hasNextKeyTyped()) {
                  char key = StdDraw.nextKeyTyped();
                  // If the key pressed isn't a part of the keyboard, print it out
                  if (keyboard.indexOf(key) == -1) {
                	  System.out.println("Not on keyboard");
                  }
                  
                  // Gets the string based off of the index of the key equaling the index of the array
                  else {
                	 GuitarString string = keyboard_array[keyboard.indexOf(key)];
                     string.pluck();  
                  }
              }
              
              // Computes the superposition of the samples by adding all the samples together
              double sample = 0;
              for(int i = 0; i < keyboard_array.length; i++) {
            	  GuitarString stringi = keyboard_array[i];
            	  sample += stringi.sample();
            	  
            	  // Advance the simulation of each guitar string by one step   
            	  stringi.tic();
              }
              // Play the sample on standard audio
              StdAudio.play(sample);  
          }
     }
}