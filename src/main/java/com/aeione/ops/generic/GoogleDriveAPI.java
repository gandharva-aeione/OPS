package com.aeione.ops.generic;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.aeione.ops.generic.IAutoConst.AUTHORIZE_URI;

public class GoogleDriveAPI {

    public static String userDir = null;

    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "OnePageSpotLight";

    /**
     * Directory to store user credentials for this application.
     */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".credentials/drive.googleapis.com-java-quickstart");

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
     * Global instance of the scopes required by this quickstart.
     * <p>
     * If modifying these scopes, delete your previously saved credentials at
     * ~/.credentials/drive-java-quickstart
     */
    private static final java.util.Collection<String> SCOPES = DriveScopes.all();

    static {
        userDir = System.getProperty("user.dir");
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
        InputStream in = GoogleDriveAPI.class.getResourceAsStream("/client_secret_drive.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES).setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();
       // Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
      //  Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("1pagespotlight.automation@gmail.com");
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize(AUTHORIZE_URI);
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }


    /**
     * Build and return an authorized Drive client service.
     *
     * @return an authorized Drive client service
     * @throws IOException
     */
    public static Drive getDriveService() throws IOException {
        Credential credential = authorize();
        return new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME).build();
    }

    public void getDownloadGoogleDriveFileWithFileID(String inputFileID) throws IOException, GeneralSecurityException {
        Drive service = getDriveService();
        // Print the names and IDs for up to 10 files.
        FileList result = getDriveService().files().list().setPageSize(1000).setFields("nextPageToken, files(id, name)").execute();
        List<File> files = result.getFiles();


        if (files == null || files.size() == 0) {
            System.out.println("No files found.");
        } else {

            for (File file : files) {

                String fname = file.getName();
                String ex = fname.substring(fname.lastIndexOf(".") + 1);
                System.out.printf("%s (%s)\n", file.getName(), file.getId());

                try {
                    Drive.Files f = service.files();
                    HttpResponse httpResponse = null;
                    String fileid = file.getId();
                    if (fileid.equals(inputFileID)) {
                        Drive.Files.Get get = f.get(file.getId());
                        httpResponse = get.executeMedia();
                    }
                    if (null != httpResponse) {
                        InputStream instream = httpResponse.getContent();
                        FileOutputStream output = new FileOutputStream(
                                file.getName());
                        try {
                            int l;
                            byte[] tmp = new byte[2048];
                            while ((l = instream.read(tmp)) != -1) {
                                output.write(tmp, 0, l);
                            }
                        } finally {
                            output.close();
                            instream.close();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void getUploadFileIntoGoogleDrive(String uploadingFilePath, String googleDriveFolderId) {
        try {
            Drive service = getDriveService();
            final java.io.File UPLOAD_FILE = new java.io.File(uploadingFilePath);

            File fileMetadata = new File();
            fileMetadata.setName(UPLOAD_FILE.getName());
            fileMetadata.setParents(Collections.singletonList(googleDriveFolderId));
            FileContent mediaContent = new FileContent("text/html", UPLOAD_FILE);


            Drive.Files.Create create = service.files().create(fileMetadata, mediaContent);
//            MediaHttpUploader uploader = create.getMediaHttpUploader();
//            //choose your chunk size and it will be automatically divided parts
//            uploader.setChunkSize(MediaHttpUploader.MINIMUM_CHUNK_SIZE);
//            //As per Google, this enables gzip in future (optional) // got from another post
//            uploader.setDisableGZipContent(false);
//            //true enables direct upload, false resume-able upload
//            uploader.setDirectUploadEnabled(true);
//            uploader.setProgressListener();
            File file = create.execute();
            System.out.println("File ID: " + file.getId());
            // return file.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * Purpose :  To Download File from Google Drive using FileID as imput .
     *
     * @param fileId
     */
    public static void downloadFileFromGoogleDrive(String fileId)
    {
        try {

            Drive service = getDriveService();

            File file = service.files().get(fileId).execute();
            System.out.println("Title: " + file.getName());
            System.out.println("Description: " + file.getDescription());
            System.out.println("MIME type: " + file.getMimeType());
            String MIMIE_Type = file.getMimeType();
            String FileName = file.getName();
            OutputStream outputStream = new FileOutputStream(new java.io.File(userDir + "//" + FileName));
            // service.files().export(fileId, MIMIE_Type).executeMediaAndDownloadTo(outputStream);
            service.files().get(fileId).executeMediaAndDownloadTo(outputStream);
            System.out.println(outputStream);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }
    }


    public String createSubFolder(String parentFolderId, String subFolderName) {
        System.out.println("Sub Folder Name: "+subFolderName);
        File file = null;
        try {
            Drive service = getDriveService();
            File fileMetadata = new File();
            fileMetadata.setName(subFolderName);
            fileMetadata.setMimeType("application/vnd.google-apps.folder");
            if (parentFolderId != null) {
                List<String> parents = Arrays.asList(parentFolderId);
                fileMetadata.setParents(parents);
            }
            file = service.files().create(fileMetadata).setFields("id, name").execute();
            System.out.println("Folder ID: " + file.getId());
            return file.getId();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }



}


