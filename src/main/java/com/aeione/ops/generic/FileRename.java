package com.aeione.ops.generic;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
public class FileRename {


		 public static void main(String[] args) throws IOException {

			 
			 String home = System.getProperty("user.home");
			 File file = new File(home+"/Downloads/" ); 
			 String filepath=file.toString();
			 
			  FileRename fr= new FileRename();
			  File newfile = fr.getTheNewestFile(filepath, "csv");
			  newfile.renameTo(new File(filepath +"\\i.csv"));
			  String filename= newfile.getName();
			 
			  System.out.println("latest file is="+filename);
			  
			  FileRename fr1= new FileRename();
			  File updated = fr1.getTheNewestFile(filepath,"csv");
			  System.out.println("Changed file name is ="+updated);
			  
			    }
			 
			 public File getTheNewestFile(String filePath, String ext) {
			     File theNewestFile = null;
			     File dir = new File(filePath);
			     FileFilter fileFilter = new WildcardFileFilter("*." + ext);
			     File[] files = dir.listFiles(fileFilter);

			     if (files.length > 0) {
			         /** The newest file comes first **/
			         Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			         theNewestFile = files[0];
			     }
			     return theNewestFile;
			 }
			}