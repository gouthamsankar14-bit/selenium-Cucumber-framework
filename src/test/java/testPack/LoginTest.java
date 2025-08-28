package testPack;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePack.DriverSetUp;
import dataReader.GetExcelData;
import dataReader.GetJsonData;
import testPage.Loginpage;

public class LoginTest extends DriverSetUp {

	@Test(dataProvider = "JsonData")
	public void logInValidation(HashMap<String, String> input) throws IOException {
		Loginpage login = new Loginpage(getdriver());
		login.logIn(input.get("userMail"), input.get("userPass"));
	}
	//dataProviders using JSON
	@DataProvider(name = "JsonData")
	public Object[][] getdata() throws IOException {
		GetJsonData data = new GetJsonData();
		List<HashMap<String, String>> value = data.getJsonData();
		Object[][] result = new Object[value.size()][1];
		for (int i = 0; i < value.size(); i++) {
			result[0][i] = value.get(i);
		}
		return result;
	}
	//dataProviders using excel 
	@DataProvider(name = "Exceldata")
	public Object[][] getexceldata() throws IOException {
		String filePath = "C:\\Users\\kgouthamsankar\\git colne_pull\\selenium-framework-login\\src\\test\\resources\\Book1.xlsx";
		String sheetName = "Sheet1";
		return GetExcelData.getExcelData(filePath, sheetName);
	}
}
