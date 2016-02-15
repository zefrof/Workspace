import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Program4 {
	static String line;
	static int maxSize;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[ ] args) throws IOException, QueueFullException, QueueEmptyException {
		
		Scanner input = new Scanner(System.in);
		try {
			input = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String value = input.next();
		System.out.println(value.substring(2));
		String intValue = value.replaceAll("[^0-9]", "");
		char[] foo = intValue.toCharArray();
		String quux = "" + foo[0] + foo[1];
		//maxSize = Integer.parseInt(intValue, 10);
		maxSize = Integer.valueOf(quux);
		//System.out.println(maxSize);
		input.close();
		
		if(maxSize == 0){
			throw new QueueFullException();
		}
		
		Scanner scan = new Scanner(System.in);
		try {
			scan = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String temp = "";
		while(scan.hasNext()){
			//System.out.println(scan.nextLine());
			temp = temp + scan.nextLine();
		}
		scan.close();
		char[] array = temp.toCharArray();
		Queue queue = new Queue(maxSize);
		for(int i = 2; i < array.length; i++){
			if(!queue.isFull()){
				queue.enqueue(array[i]);
			} else {
				for(int j = 0; j < maxSize; j++){
					System.out.print(queue.dequeue());
				}
				System.out.println("");
			}
			
		}
	} 
}
