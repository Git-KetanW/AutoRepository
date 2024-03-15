package dataDriven;

import org.testng.annotations.DataProvider;

public class DataSupplier {
	
	@DataProvider(name="DataSet") // we can rename of our DataProvider
	public String[][] Data_provider() { //this is our set of data
		
		String [][] data = {{"johnmac@somthing.com","Johnmac@123"},
				{"johnmac@somthing.com","Johnmac@123"},
				{"johnmac@somthing.com","Johnmac@123"}};
		
		return data;
		
	}

}
