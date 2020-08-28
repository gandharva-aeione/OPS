package com.aeione.ops.generic;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.google.gson.GsonBuilder;

public class ReadJSONExample
{

	@SuppressWarnings("unchecked")
	public static void readHAR(String fileName,String newFileName) throws Exception{
		Logger log = Logger.getLogger(GenericFunctions.class.getName());
	
		Object responseData1 = null;
		try (FileReader reader = new FileReader(
				fileName)) {
			

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(reader);
			
			JSONObject jObject = new JSONObject();
			JSONArray array = new JSONArray();
			
			System.out.println("Done");

			String fileAsString = obj.toString();

			org.json.JSONObject jsonResult = new org.json.JSONObject(fileAsString.trim());
			
			
			Object result = jsonResult.get("log");
			

			org.json.JSONObject jsonForm = new org.json.JSONObject(result.toString().trim());
			Object resultForm = jsonForm.get("entries");
			Object[] resultForm2 = resultForm.toString().split("startedDateTime");
			

			for (int i = 0; i < resultForm2.length - 1; i++) {

				org.json.JSONObject jsonData = new org.json.JSONObject(
						resultForm2[i + 1].toString().substring(resultForm2[i + 1].toString().indexOf('{')));
				
				Object urlData = jsonData.get("url");
				
				if (urlData.toString().contains("/api/")) {
					System.out.println("request url:" + urlData);
					int responseIndex = resultForm2[i + 1].toString().indexOf("response");
					org.json.JSONObject jsonResponseData = new org.json.JSONObject(resultForm2[i + 1].toString()
							.substring(resultForm2[i + 1].toString().indexOf("{", responseIndex)));
					
					Object statusTextData = jsonResponseData.get("statusText");
					
					if (statusTextData.equals("OK")) {
						System.out.println("No Issue in this response,checking the next one");

					} else {
						
						
						
						
						System.out.println("request:" + jsonData);
						System.out.println("statustext:" + statusTextData);

						System.out.println("response:" + jsonResponseData);
						
						
						JSONObject failedReqObj = new JSONObject();
						
						failedReqObj.put("request", jsonData);
						
						failedReqObj.put("response", jsonResponseData);
						
						
						array.add(failedReqObj);
					}
					
				}
			}
			File file = new File(
					fileName);
			if (file.delete()) {
				System.out.println("file deleted");
			} else {
				System.out.println("file not available");

			}

			// try-with-resources statement based on post comment below :)
			try (FileWriter filewriter = new FileWriter(
					fileName)) {
				
				
				jObject.put("apifailureinfo", array);
				
				

				filewriter.write(jObject.toJSONString());
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("created json file");

			} catch (Exception e) {
				e.printStackTrace();
			}
			try (FileWriter newFilewriter = new FileWriter(
					newFileName)) {
				
				
				jObject.put("apifailureinfo", array);
				System.out.println("jObject to String:: " + jObject.toJSONString());
				String formattedData=new GsonBuilder().setPrettyPrinting().create().toJson(jObject);
				newFilewriter.write(formattedData);
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("created formatted json file");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}

