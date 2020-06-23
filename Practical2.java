import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Practical2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter file path: ");
		String path = scan.nextLine();
		
		if(doesFileExist(path)) {
			
			System.out.println("File exists.");
			// Reading..
			// First is Word Key, Second is list of meanings.
			Map<String, List<String>> dictionary = new HashMap<>();
			try {
				
				Scanner reader = new Scanner(new File(path));
				while(reader.hasNextLine()) {
					
					String line = reader.nextLine().trim();
					if(!line.isEmpty()) {
						
						// first token is word and second is meanings.
						String[] tokens = line.split("-");
						if(tokens.length > 1) {
							
							String word = tokens[0].trim();
							String[] meanings = tokens[1].split(",");
							List<String> listOfMeanings = new ArrayList<String>(Arrays.asList(meanings));
							// adding in data structure.
							dictionary.put(word, listOfMeanings);
							
						}
						
					}
					
				}
				reader.close();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			// Printing the details after reading.
			for(String word: dictionary.keySet()) {
				
				// getting meanings for each word.
				List<String> meanings = dictionary.get(word);
				System.out.println(word);
				for(int i = 0; i < meanings.size(); i++) {
					
					System.out.println(meanings.get(i).trim());
					
				}
				System.out.println();
				
			}
			
		} else {
			
			System.out.println("File path "+path+" does not exists.");
			
		}
		
		scan.close();
		
	}
	
	private static boolean doesFileExist(String path) {
		
		File file = new File(path);
		return file.exists();
		
	}
	
}
