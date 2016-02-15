import java.io.*;
import java.util.Scanner;
/***
 * 
 * @author Darren Wiltse
 * @author Nicholas Thomas
 * @author Alex Stanage
 *
 */

public class Jukebox {
	
	static String fileName = "Jukebox.txt";
	static Scanner input;

	public static void main(String[] args) throws IOException, DequeOnEmptyQueueException, PeekOnEmptyQueueException {
		Queue<String> musicQueue = new Queue<String>();
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line;
		String[] temp;
		while(input.hasNext()){
			line = input.nextLine();
			if(line.contains("ADD")){
				//line.replace("ADD", "");
				temp = line.split(",");
				MusicTrack musicTrack = new MusicTrack();
				musicTrack.setName(temp[0]);
				musicTrack.setArtist(temp[1]);
				musicQueue.enque(musicTrack);
			} else if(line.contains("PLAYNEXT")){
				System.out.println((musicQueue.peek().getName() + ", " + musicQueue.peek().getArtist()).replace("ADD", ""));
				
				musicQueue.deque();
			} 
			//System.out.println(line);
		}
		input.close();
		if(musicQueue.isEmpty()) {
			System.out.println("Waiting for music to be queued.");
		}

	}

}
