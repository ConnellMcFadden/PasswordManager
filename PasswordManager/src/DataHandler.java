import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DataHandler {
static List<String> tempLines = new LinkedList<String>();
	
//	Takes data from default file and writes each line into Linked list tempLines
	public static void retrieveData(){
		String fileName = "data.txt";
		String line = null;
				
		try{
			
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				tempLines.add(line);
			}
          
        bufferedReader.close();         
		}
		
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");                
		}
		
		catch(IOException ex) {System.out.println("Error reading file '" + fileName + "'");          
		}
		
	}
	
	
	public static void writeData(String data){
		String fileName = "data.txt";

		tempLines.clear();
				
		retrieveData();
		tempLines.add(data);
		
		try{
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
			for(String line : tempLines){
			
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
			
			bufferedWriter.close();
			}
		
		catch(IOException ex) {System.out.println("Error writing to file '" + fileName + "'");
			}
		
		}
}
