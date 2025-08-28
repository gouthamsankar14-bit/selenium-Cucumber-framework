package dataReader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetJsonData {

	public List<HashMap<String, String>> getJsonData() throws IOException {
		String path = "C:\\Users\\kgouthamsankar\\git colne_pull\\selenium-framework-login\\src\\test\\resources\\loginData.json";

		String JsonContent = FileUtils.readFileToString(new File(path), "UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(JsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
}
