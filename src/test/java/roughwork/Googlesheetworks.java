package roughwork;

import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Googlesheetworks extends TestSetUp
{
    public GoogleSheetAPI sheetAPI() throws IOException
    {
        return new GoogleSheetAPI();
    }

    @Test(priority = 06, enabled = false, alwaysRun = true, description = "Verify appending values into googlesheet")
    public void appendingRowValuesToGoogleSheet() throws Exception
    {

        List<List<Object>> values = Arrays.asList(Arrays.asList("A", "123"), Arrays.asList("G", "jhbbj3"));
        sheetAPI().appendRowData(TEST_DATA_GOOGLESHEET,constantRow,  "USER_ENTERED", values);
    }

    @Test(priority = 07, enabled = true, alwaysRun = true, description = "Verify delete row  from googlesheet")
    public void deleteSpecificRowFromGooglesheet() throws Exception
    {
        String columnValue="ylAcEdKm";
        String range = "Registration!A1:ZZ";
        int rowNum=sheetAPI().getRowIndexByColumnValue(TEST_DATA_GOOGLESHEET, range, columnValue);
        range = "Registration!A"+rowNum+":B"+rowNum+"";
        sheetAPI().clearSpecificRowDataByColumnName(TEST_DATA_GOOGLESHEET, range);
    }

}
