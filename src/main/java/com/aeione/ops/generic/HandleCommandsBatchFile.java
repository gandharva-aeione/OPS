package com.aeione.ops.generic;


import java.io.File;
import java.io.IOException;

/**
 * @author Kirthana
 *
 * To Run,Write commands on Batch File
 *
 */
public  class HandleCommandsBatchFile extends TestSetUp
{

    public static void runBatchFile(String batchfileName, String platformName) throws IOException
    {
        ProcessBuilder pb=null;
        switch (platformName.split(" ")[0].trim()) {

            case WINDOWS:

                pb = new ProcessBuilder("cmd", "/c", ""+batchfileName+"");
                break;

            case LINUX:

                pb = new ProcessBuilder("cmd", "/c", ""+batchfileName+"");
                break;


            case MAC:
                pb= new ProcessBuilder("open", "/c", ""+batchfileName+"");
                break;

            default:
                System.out.println("Platform is not specified ");
        }


        File dir = new File(""+userDirPath+"");
        pb.directory(dir);
        Process p = pb.start();
    }


}