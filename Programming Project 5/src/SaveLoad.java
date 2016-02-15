import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;


public class SaveLoad<V> {
	static int[] left = {0, 0, 0, 0, 0};
	static int[] right = {0, 0, 1, 0, 0};
	static int[] main = {0, 0, 0, 0, 0};
	static ArrayList<Object> inventory = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		//if(in.equalsIgnoreCase("save")){
			//some how check what room they're in, then save left, right, main depending
			save("right", right, inventory, "save1.txt");
		//}
		
		//if(in.equalsIgnoreCase("load")){
		//System.out.print("ENTER SAVE FILE TO LOAD");
		//String file = in.readLine();
		//load(file);
		//}
		

	}

	public static void save(String arrayName, int[] roomPos, ArrayList<Object> inventory, String fileName) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		writer.println(arrayName);
		for(Integer i : roomPos){
			writer.print(i);
		}
		writer.println();
		for(Object o : inventory){
			writer.println(o);
		}
		writer.close();
	}
	
	public static void load(String fileName) throws IOException{
		FileReader fileReader = new FileReader(fileName);
		Scanner scan = new Scanner(fileReader);
		String arrayName = scan.nextLine();
		char[] roomPos = scan.nextLine().toCharArray();
		if(arrayName.equals("left")){
			for (int i = 0; i < roomPos.length; i++){
		        left[i] = roomPos[i] - '0';
		    }
		} else if(arrayName.equals("right")){
			for (int i = 0; i < roomPos.length; i++){
		        right[i] = roomPos[i] - '0';
		    }
		} else if(arrayName.equals("main")) {
			for (int i = 0; i < roomPos.length; i++){
		        main[i] = roomPos[i] - '0';
		    }
		}
		while(scan.hasNext()){
			inventory.add(scan.nextLine());
		}
		scan.close();
	}
}