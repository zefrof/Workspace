/**
 * 
 * @author Darren Wiltse
 * Feb 1st, 2017
 * ANN | NN2
 *
 */
public class ANN2 {
	
	//wights
	private static double w02, w03, w12, w13, w24, w34;
	//activation values
	private static double a2, a3, a4;
	//bias
	private static double b2, b3, b4;
	//deltas
	private static double delta2, delta3, delta4;
	//learning constant
	private static double c = .001;
	
	//the maximum number of times the loops will be run before stopping
	private static int maxRuns = 5;
	//the current run the loop in main is on
	private static int curRun = 0;
	//keeps the loop running untiil maxRuns is reached
	private static boolean loop = true;
	
	/**
	 * This is where the weights and biases are first initialized. In addition to that, a loop runs, which passes training values to
	 * the Neuron function and prints out points to be graphed. Once curRun >= maxRuns, the program exits. 
	 * @param args
	 */
	public static void main(String[] args) {
		//Initialize each weight with a value.
		w02 = .5;
	    w03 = .5;
	    w12 = .5;
	    w13 = .5;
	    w24 = 1;
	    w34 = 1;
	    b2 = 1;
	    b3 = 1;
	    b4 = 1;
	    
	    while(loop) {
	    
	    	//Pass the training value to the Neuron. 
	    	Neuron(.5,.5,1);
	    	Neuron(1,2,1);
	    	Neuron(1.5,1.5,0);
	    	Neuron(2,2.5,0);
	    	
	    	curRun++;
	    	//System.out.println(w24/w34);
    		System.out.println(w02/w12);
    		System.out.println((-1) * (w03/w13));
    		//System.out.println(" ");
    		
	    	if(curRun >= maxRuns) {
	           //System.out.println("Max runs reached!");
	            //System.out.println(w02 + " " + w03);
	            //System.out.println(w12 + " " + w13);
	            //System.out.println(w24 + " " + w34);
	            System.exit(0);
	        }
	    }
	    
	}

	/**
	 * Mimics the sigmoid function so it doesn't have to be typed in multiple times.
	 * @param ex
	 * @return the value calculated by the sigmoid function
	 */
	private static double sigmoid(double ex) {
	    return (1.0/(1 + Math.pow(Math.E, (-1) * ex)));
	}
	
	/**
	 * Calculates the values for the different node activations based off the training values passed to the funciton. Then uses the
	 * activation values and the expected value to calculate the different delta values. 
	 * @param x1
	 * @param x2
	 * @param expected
	 */
	private static void Neuron(double x1, double x2, int expected) {
		//Activations are being calculated based off the training values and weights. 
		a2 = (x1 * w02) + (x2 * w12);
		a3 = (x1 * w03) + (x2 * w13);
		a4 = (sigmoid(a2) * w24) + (sigmoid(a3) * w34);
		//System.out.println(sigmoid(a4));
		//System.out.println("activations: " + a2 + " " + a3 + " " + a4);
		
		//Deltas are being calculated based off of the activations and expected values. 
		delta2 = a2 * (1 - a2) * (expected - a2);
		delta3 = a3 * (1 - a3) * (expected - a3);
		delta4 = a4 * (1 - a4) * (expected - a4);
		
		training(x1, x2);
	}
	/**
	 * This is where all weights and bias are adjusted to teach y=x^2.
	 */
	private static void training(double x1, double x2) {
		
		//weights heading to node 4 and the bias for node 4 are being updated
		w24 = w24 + c * a2 * delta4;
		w34 = w34 + c * a3 * delta4;
		b4 = b4 + c * 1 * delta4;
		//System.out.println("weights: " + w24 + " " + w34);
		
		//weights heading to node 2 and the bias for node 4 are being updated
		w02 = w02 + c * x1 * delta2;
		w12 = w12 + c * x2 * delta2;
		b2 = b2 + c * 1 * delta2;
		//System.out.println("weights: " + w02 + " " + w12);
		
		//weights heading to node 3 and the bias for node 4 are being updated
		w03 = w03 + c * x1 * delta3;
		w13 = w13 + c * x2 * delta3;
		b3 = b3 + c * 1 * delta3;
		//System.out.println("weights: " + w03 + " " + w13);
		//System.out.println(" ");
		
	}
}
