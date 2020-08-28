package com.aeione.ops.generic;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static com.aeione.ops.generic.IAutoConst.AUTHORIZE_URI;

/**
 * @author Kirthana SS
 *
 * To Handle Google Sheet such as ::  Fetching data, Updating data, Deleting data, Appending data etc
 *
 */
public class GoogleSheetAPI {

    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "OnePageSpotLight";

    /**
     * Directory to store user credentials for this application.
     */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-quickstart");

    /**
     * Global instance of the {@link FileDataStoreFactory}.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /**
     * Global instance of the HTTP transport.
     */
    private static HttpTransport HTTP_TRANSPORT;

    /**
     * Global instance of the scopes required .
     * <p>
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.DRIVE);
    //private static final List<String> SCOPES = Arrays.asList(SheetsScopes.DRIVE);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }


    /**
     * Creates an authorized Credential object.
     *
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in = GoogleSheetAPI.class.getResourceAsStream("/client_secret_sheet.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));


        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        // Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        // Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("1pagespotlight.automation@gmail.com");
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize(AUTHORIZE_URI);
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;

    }


    /**
     * Build and return an authorized Sheets API client service.
     *
     * @return an authorized Sheets API client service
     * @throws IOException
     */
    public static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }


    public List<List<Object>> getSpreadSheetRecords(String spreadsheetId, String range) throws Exception {
        Sheets service = getSheetsService();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values != null && values.size() != 0) {
            return values;
        } else {
            System.out.println("No data found.");
            return null;
        }
    }


    public ArrayList<String> getSpreadSheetValues(String TEST_DATA_GOOGLESHEET, String range, int Num) throws Exception {
        ArrayList<String> sheetvalues = new ArrayList<String>();
        List<List<Object>> rowvalues = getSpreadSheetRecords(TEST_DATA_GOOGLESHEET, range);
        for (int j = 0; j <= rowvalues.size() - 1; j++) {
            if (j == Num - 1) {

                for (int i = 0; i <= rowvalues.get(j).size() - 1; i++) {

                    sheetvalues.add(String.valueOf(rowvalues.get(j).get(i)));
                }
            }
        }
        return sheetvalues;
    }


    public ArrayList<String> getSpreadSheetValuesOfSpecificRow(String TEST_DATA_GOOGLESHEET, String range) throws Exception {
        ArrayList<String> sheetvalues = new ArrayList<String>();
        List<List<Object>> rowvalues = getSpreadSheetRecords(TEST_DATA_GOOGLESHEET, range);
        for (int j = 0; j <= rowvalues.size() - 1; j++) {


            for (int i = 0; i <= rowvalues.get(j).size() - 1; i++) {

                sheetvalues.add(String.valueOf(rowvalues.get(j).get(i)));
            }

        }
        return sheetvalues;
    }


    /**
     * @author Kirthana SS
     *
     * @param TEST_DATA_GOOGLESHEET
     * @param range
     * @return
     * @throws Exception
     *
     *  Get row value by column header name
     */
    public Map<String, String> getSpreadSheetRowValueByColumnName(String TEST_DATA_GOOGLESHEET, String range) throws Exception {
        ArrayList<String> sheetRowvalues = new ArrayList<String>();
        ArrayList<String> sheetHeadervalues = new ArrayList<String>();

        //Get Row Values
        List<List<Object>> rowvalues = getSpreadSheetRecords(TEST_DATA_GOOGLESHEET, range);
        for (int j = 0; j <= rowvalues.size() - 1; j++) {
            for (int i = 0; i <= rowvalues.get(j).size() - 1; i++) {
                sheetRowvalues.add(String.valueOf(rowvalues.get(j).get(i)));
            }
        }

        //Get Header range
        String[] a = range.split("!");
        String[] b = a[1].split(":");
        String[] c = b[0].split("");
        String[] d = b[1].split("");
        String e = c[0] + "1";
        String f=null;
        String temp=null;

        if(d.length>2)
        {
            if(true==Character.isLetter(d[1].charAt(0)))
            {
                f = d[0] + d[1] + "1";
            }else
            {
                f = d[0]  + "1";
            }
        }else
        {
             f = d[0]  + "1";
        }
        String headerRange = a[0] + "!" + e + ":" + f;


        List<List<Object>> headervalues = getSpreadSheetRecords(TEST_DATA_GOOGLESHEET, headerRange);

        for (int i = 0; i <= headervalues.get(0).size() - 1; i++) {

            sheetHeadervalues.add(String.valueOf(headervalues.get(0).get(i)));
        }


        Map<String, String> keyValues = new HashMap<>();
        for (int i = 0; i <= sheetHeadervalues.size() - 1; i++) {
            keyValues.put(sheetHeadervalues.get(i).trim(), sheetRowvalues.get(i).trim());
        }

        return keyValues;
    }


    public void updateSingleCellValues(String spreadsheetId, String range)
            throws IOException {

        String valueInputOption = "RAW";
        // Build a new authorized API client service.
        Sheets service = getSheetsService();
        // Prints the names and majors of students in a sample spreadsheet:

        List<List<Object>> arrData = getData();

        ValueRange oRange = new ValueRange();
        oRange.setRange(range); // I NEED THE NUMBER OF THE LAST ROW
        oRange.setValues(arrData);

        List<ValueRange> oList = new ArrayList<>();
        oList.add(oRange);

        Sheets.Spreadsheets.Values.Update request =
                service.spreadsheets().values().update(spreadsheetId, range, oRange);
        request.setValueInputOption(valueInputOption);
        UpdateValuesResponse response = request.execute();
        System.out.println(response);
    }

    public static List<List<Object>> getData() {

        List<Object> data1 = new ArrayList<Object>();
        data1.add("Ashwin");

        List<List<Object>> data = new ArrayList<List<Object>>();
        data.add(data1);

        return data;
    }


    public UpdateValuesResponse updateMultipleCellValues(String spreadsheetId, String range, String valueInputOption, List<List<Object>> _values)
            throws IOException {
        Sheets service = getSheetsService();
        // [START sheets_update_values]
        List<List<Object>> values = Arrays.asList(
                Arrays.asList(
                        // Cell values ...
                )
                // Additional rows ...
        );
        // [START_EXCLUDE silent]
        values = _values;
        // [END_EXCLUDE]
        ValueRange body = new ValueRange()
                .setValues(values);
        UpdateValuesResponse result =
                service.spreadsheets().values().update(spreadsheetId, range, body)
                        .setValueInputOption(valueInputOption)
                        .execute();
        System.out.printf("%d cells updated.", result.getUpdatedCells());
        // [END sheets_update_values]
        return result;
    }


    /**
     *
     * @autor Kirthana SS
     * @param spreadsheetId
     * @param range
     * @param valueInputOption
     * @param _values
     * @return
     * @throws IOException
     *
     * Method to append row data into google sheet
     *
     */
    public AppendValuesResponse appendRowData(String spreadsheetId, String range, String valueInputOption, List<List<Object>> _values)
            throws IOException
    {
        Sheets service = getSheetsService();
        // [START sheets_append_values]
        List<List<Object>> values = Arrays.asList(
                Arrays.asList(
                        // Cell values ...
                )
                // Additional rows ...
        );


        // [START_EXCLUDE silent]
        values = _values;
        // [END_EXCLUDE]
        ValueRange body = new ValueRange()
                .setValues(values);
        AppendValuesResponse result =
                service.spreadsheets().values().append(spreadsheetId, range, body)
                        .setValueInputOption(valueInputOption)
                        .execute();
        System.out.printf("%d cells appended.", result.getUpdates().getUpdatedCells());
        // [END sheets_append_values]
        return result;
    }

    /**
     * @author Kirthana SS
     *
     * @param spreadsheetId
     * @param range
     * @throws IOException
     *
     * To Clear specific row data based on column name
     *
     */
    public void clearSpecificRowDataByColumnName(String spreadsheetId, String range)
            throws IOException
    {
        Sheets service = getSheetsService();
        // The ID of the spreadsheet to update.
        // TODO: Assign values to desired fields of `requestBody`:
        ClearValuesRequest requestBody = new ClearValuesRequest();
        Sheets.Spreadsheets.Values.Clear request = service.spreadsheets().values().clear(spreadsheetId, range, requestBody);
        ClearValuesResponse response = request.execute();
        // TODO: Change code below to process the `response` object:
        System.out.println(response);
    }


    /**
     * @autor Kirthana SS
     *
     * @param spreadsheetId
     * @param range
     * @param value
     * @return
     * @throws IOException
     */
    public int getRowIndexByColumnValue(String spreadsheetId, String range, String value)
            throws IOException
    {
        int returnValue=0;
        Sheets service = getSheetsService();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        System.out.println(values);

        outerloop:
        for(int i=1; i <=values.size(); i++)
        {
            innerloop:
            for(int j=0 ; j<=values.get(i).size()-1 ;  j++)
            {
                if(values.get(i).get(j).toString().trim().equals(value.trim()))
                {
                    returnValue=++i;
                    break outerloop;
                }
            }
        }
        return returnValue;
    }


}
