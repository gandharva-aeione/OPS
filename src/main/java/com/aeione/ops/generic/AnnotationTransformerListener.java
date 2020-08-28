package com.aeione.ops.generic;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import static com.aeione.ops.generic.IAutoConst.TEST_EXECUTION_SHEET;

public class AnnotationTransformerListener implements IAnnotationTransformer
{

    public GoogleSheetAPI sheetAPI() throws IOException
    {
        return new GoogleSheetAPI();
    }


    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
    {
        try{
        String range = "SanityTestCase!A6:D";

        Map<String, String> values = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_EXECUTION_SHEET, range);

        String testCaseName=values.get("TestCaseName").trim();
        String priority=values.get("Priority").trim();
        String enabled=values.get("Enabled").trim();

        System.out.println(testCaseName + "," + priority+ "," + enabled);
        System.out.println(testMethod.toString().trim().split("\\.")[5].split("\\(\\)")[0] + "," + annotation.getPriority()+ "," + annotation.getEnabled());

        if(testMethod.toString().trim().equals(testCaseName))
        {
            annotation.setPriority(Integer.valueOf(priority));
            annotation.setEnabled(Boolean.valueOf(enabled.toLowerCase()));
        }

    }catch(Exception e)
        {
             System.out.println(e.fillInStackTrace()  );
        }

    }
}
