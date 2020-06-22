package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	@Test(dataProvider = "test1data")
	public void test1(String Username, String Password) {
		System.out.println(Username+" "+Password);
	}

	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelPath= "E:\\SeleniumFramework\\excel\\Data.xlsx";
		String sheetName= "Sheet1";
		Object data[][]= testData(excelPath, sheetName);
		return data;
		
	}
	
	public Object[][] testData(String excelPath, String sheetName ) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount= excel.getRowCount();
		int colCount= excel.getcolCount();
		Object data[][] = new Object[rowCount-1][colCount];
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String cellData=excel.getCellDataString(i, j);
				System.out.print(cellData+" ");
				data[i-1][j]= cellData;
			}
			System.out.println();
		}
		return data;
	}

}
