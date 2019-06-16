import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.ObservableList;

public class CSVReader {

    public CSVReader() {
    	
    }
    
	/*
	 * TODO verify this function with a csv file
	 * 
	 * @param csvFile String for the filepath of the csv file
	 */
	public static ObservableList<MartenData> readCSV(ObservableList<MartenData> mdList, String csvFile) {
		
		if( csvFile != "" ) { //check first to see if it is a null string
			
	        String line = "";
	        
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	
	            while ((line = br.readLine()) != null) {
	
	                String[] row = line.split(",");	                
	                MartenData md = new MartenData();
	                md.insertAll(row);
	                
	                mdList.add(md);
	                
	            }
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
		}
        
        return mdList;
	}

    
    

}