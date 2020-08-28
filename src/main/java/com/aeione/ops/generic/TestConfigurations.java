/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Ajith Manjunath

* Date: 06/10/2018

* Purpose: All the locators of login page.
*/
package com.aeione.ops.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;


public class TestConfigurations 
{
	public static Properties APPCONFIG=null;
	public static Properties COLUMNHEADERSPROP=null;
	public static Properties OTHERCONFIGPROP=null;
	public static boolean isTestConfigInitialized = false;

	static Logger log = Logger.getLogger(TestConfigurations.class.getName());

	@BeforeClass
	public static void initTestConfiguration() throws IOException {

		if(!isTestConfigInitialized) {

			APPCONFIG = new Properties();
			COLUMNHEADERSPROP = new Properties();
			OTHERCONFIGPROP = new Properties();


			try  {
				Path currentPath = Paths.get("");
				String strCurrentPath = currentPath.toAbsolutePath().toString();
				
				System.out.println("strCurrentPath:: " + strCurrentPath);
				
				System.out.println("Before Reading AppConfig");
				APPCONFIG.load(new FileInputStream("./application.config"));
				System.out.println("After Reading AppConfig");
			}  catch (FileNotFoundException e) {
				System.out.println("FileNotFoundException");
				e.printStackTrace();
				log.error("Method: initTestConfiguration ::" + "file not found exception occured = " + e
						+ " Line Number = " +  Thread.currentThread().getStackTrace()[3].getLineNumber());
			}  catch (IOException e) {
				System.out.println("IOException");
				e.printStackTrace();
				log.error("Method: initTestConfiguration ::" + "IO exception occured = " + e
						+ " Line Number = " +  Thread.currentThread().getStackTrace()[3].getLineNumber());
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			System.out.println("APPCONFIG.size():: " + APPCONFIG.size());
			
			try {
				if (APPCONFIG.size() > 0) {

					FileInputStream ColumnHeaderFile = new FileInputStream(APPCONFIG.getProperty("ExcelColumnHeadersFilePath"));
					COLUMNHEADERSPROP.load(ColumnHeaderFile);
					FileInputStream OtherConfigFile = new FileInputStream(APPCONFIG.getProperty("OtherConfigurationsPath"));
					OTHERCONFIGPROP.load(OtherConfigFile);
					System.out.println("After loading Other Config Prop");

				}
			} catch (Exception e) {
				log.error("Method: initTestConfiguration ::" + "Exception occured = " + e
						+ " Line Number = " +  Thread.currentThread().getStackTrace()[3].getLineNumber());
				e.printStackTrace();
			}
			isTestConfigInitialized = true;
		}
	}
}
