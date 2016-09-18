import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/***
 * 
 * @author Darren Wiltse
 * dkwiltse@mtu.edu
 * CS2321
 * This program reads the contents of a file and outputs the counts of each character
 *
 */
public class CharacterCounts {

	public static void main(String[] args) throws IOException{
		String fileName = args[0];
		BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
		ArrayList<Integer> vals = new ArrayList<Integer>();
		ArrayList<Integer> valCounts = new ArrayList<Integer>();
		
		int c = 0;
		while((c = in.read()) != -1){
			vals.add(c);
		}
		in.close();
		
		Collections.sort(vals);
		
		//This counts how many times each char occures,
		//resets count to 0 upon finding a new char.
		int count = 0;
		for(int i = 1; i < vals.size(); i++){
			if(vals.get(i - 1).equals(vals.get(i))){
				count++;
			} else {
				valCounts.add(count + 1);
				count = 0;
			}
		}
		
		while(vals.get(vals.size() - 1).equals(vals.size() - 2)){
			count++;
		}
		valCounts.add(count + 1);
		
		//Removes duplicates from vals by moving from set then back to ArrayList
		Set<Integer> hs = new HashSet<Integer>();
		hs.addAll(vals);
		vals.clear();
		vals.addAll(hs);
		Collections.sort(vals);
				
		//System.out.print(vals.size() + "," + valCounts.size());
		
		for(int i = 0; i < vals.size(); i++){
			//System.out.println(vals.get(i));
			if(vals.get(i).equals(10)){
				System.out.printf("'\\n' %d\n", valCounts.get(i));
			} else {
				System.out.printf("'%c' %d\n", vals.get(i), valCounts.get(i));
			}
		}
	}
}