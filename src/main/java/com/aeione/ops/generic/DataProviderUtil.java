package com.aeione.ops.generic;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;

public class DataProviderUtil {


//    public static String[][] getExcelData(String fileName, String sheetName)
//    {
//        String[][] arrayExcelData = null;
//        try {
//            FileInputStream fs = new FileInputStream(fileName);
//            Workbook wb = new XSSFWorkbook(fs);
//            Sheet sh = wb.getSheet(sheetName);
//
//            int totalNoOfCols = sh.get
//            int totalNoOfRows = sh.getRows();
//
//            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
//
//            for (int i= 1 ; i < totalNoOfRows; i++)
//            {
//
//                for (int j=0; j < totalNoOfCols; j++) {
//                    arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
//                }
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        }
//        return arrayExcelData;
//    }


    public static String[][] getExcelData(String fileName, String sheetName) throws IOException
    {

        String[][] arrayExcelData = null;


        FileInputStream fis = new FileInputStream(fileName);
        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        // Return first sheet from the XLSX workbook
        XSSFSheet mySheet = myWorkBook.getSheet(sheetName);
        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();



        arrayExcelData = new String[mySheet.getLastRowNum()-1][mySheet.getDefaultColumnWidth()];

        int i=0;

        // Traversing over each row of XLSX file
        while (rowIterator.hasNext())
        {

            Row row = rowIterator.next();
            //For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();

            int j=0;

            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch (cell.getCellType())
                {
                    case STRING:
                        System.out.println(cell.getStringCellValue() + "\t");
                        arrayExcelData[i][j] =cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue() + "\t");
                        arrayExcelData[i][j]=String.valueOf(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue() + "\t");
                        arrayExcelData[i][j]=String.valueOf(cell.getBooleanCellValue());
                        break;
                    default:
                }

                j++;
            }

           i++;
        }

        return arrayExcelData;

    }


    @DataProvider(name = "testExecutionConfigData")
    public static Object[][] testExecutionConfigData() throws IOException {
        Object[][] arrayObject = getExcelData("/Users/qualitrix/Documents/onepagespotlight/Test.xls", "LoginPageTest");
        System.out.println(arrayObject);
        return arrayObject;


    }


}

