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
		
		//before opening, make sure that it is a string that we can deal with appropriately
		if( csvFile != null)
			if( csvFile != "")
				if (csvFile.length() >= 4)
					if( csvFile.substring(csvFile.length()-4, csvFile.length()).equals(".csv") ) {
					
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
				            AlertBox.display("File Error", "Error opening file " + csvFile);
				        }
				        
					}
			
        
        return mdList;
	}

}