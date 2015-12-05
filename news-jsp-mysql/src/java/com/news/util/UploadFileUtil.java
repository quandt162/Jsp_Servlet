/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author ThangDM
 */
public class UploadFileUtil {

    public static String upload(HttpServletRequest request, String paramName, String fileName) {
        String result = "";
        File file;
        int maxFileSize = 5000 * 1024;
        int maxMemSize = 5000 * 1024;
        String filePath = "";
        ///opt/apache-tomcat-7.0.59/webapps/noithat
        //filePath = getServletContext().getRealPath("") + File.separator + "test-upload" + File.separator;
        filePath = File.separator + File.separator + "opt" + File.separator + File.separator;
        filePath += "apache-tomcat-7.0.59" + File.separator + File.separator + "webapps";
        filePath += File.separator + File.separator + "noithat";
        filePath += File.separator + File.separator + "upload" + File.separator + File.separator;
        filePath += "images" + File.separator;

        //filePath = "E:" + File.separator;

        // Verify the content type
        String contentType = request.getContentType();
        System.out.println("contentType=" + contentType);
        if (contentType != null && (contentType.indexOf("multipart/form-data") >= 0)) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            // maximum size that will be stored in memory
            factory.setSizeThreshold(maxMemSize);
            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File("c:\\temp"));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // maximum file size to be uploaded.
            upload.setSizeMax(maxFileSize);
            try {
                // Parse the request to get file items.
                List fileItems = upload.parseRequest(request);
                System.out.println("fileItems.size()=" + fileItems.size());
                // Process the uploaded file items
                Iterator i = fileItems.iterator();

                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (!fi.isFormField() && fi.getFieldName().equals(paramName)) {
                        // Get the uploaded file parameters
                        String fieldName = fi.getFieldName();
                        int dotPos = fi.getName().lastIndexOf(".");
                        if (dotPos < 0) {
                            fileName += ".jpg";
                        } else {
                            fileName += fi.getName().substring(dotPos);
                        }
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();
                        // Write the file
                        if (fileName.lastIndexOf("\\") >= 0) {
                            file = new File(filePath
                                    + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            file = new File(filePath
                                    + fileName.substring(fileName.lastIndexOf("\\") + 1));
                        }
                        fi.write(file);
                        System.out.println("Uploaded Filename: " + filePath
                                + fileName + "<br>");
                        result = fileName;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String uploadReq(InputStream inputStream, String fileName, String newName,String forder) {
        String result = "";
        //path write file
        String filePath = "";

        ///opt/apache-tomcat-7.0.59/webapps/noithat
        filePath = File.separator + File.separator + "opt" + File.separator + File.separator;
        filePath += "apache-tomcat-7.0.59" + File.separator + File.separator + "webapps";
        filePath += File.separator + File.separator + "noithat";
        filePath += File.separator + File.separator + "upload" + File.separator + File.separator;
        filePath += "images" + File.separator;
        if (forder != null && !"".equals(forder)) {
            filePath += forder + File.separator;
        }
//        filePath = "E:"+File.separator;
        OutputStream outputStream = null;
        try {
		// write the inputStream to a FileOutputStream

            int dotPos = fileName.lastIndexOf(".");
            if (dotPos < 0) {
                newName += ".jpg";
            } else {
                newName += fileName.substring(dotPos);
            }

            if (newName.lastIndexOf("\\") >= 0) {
                outputStream = new FileOutputStream(new File(filePath
                        + newName.substring(newName.lastIndexOf("\\"))));
            } else {
                outputStream = new FileOutputStream(new File(filePath
                        + newName.substring(newName.lastIndexOf("\\") + 1)));
            }

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            result = newName;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return result;
    }
    
    public static String genFileName(String fileName, String newName) {
        int dotPos = fileName.lastIndexOf(".");
        if (dotPos < 0) {
            newName += ".jpg";
        } else {
            newName += fileName.substring(dotPos);
        }
        return newName;
    }
}
