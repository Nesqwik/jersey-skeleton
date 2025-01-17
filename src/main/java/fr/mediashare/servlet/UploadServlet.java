package fr.mediashare.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import fr.mediashare.utils.FileFormatUtils;
import fr.mediashare.utils.Requests;
import fr.mediashare.utils.Ressources;


@WebServlet(name = "uploadServlet", urlPatterns = { "/upload" }, initParams = { @WebInitParam(name = "simpleParam", value = "paramValue") })
/*@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
				maxFileSize=1024*1024*10,      // 10MB
				maxRequestSize=1024*1024*50)   // 50MB*/
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        
        if (isMultipart) {
        	// Create a factory for disk-based file items
        	FileItemFactory factory = new DiskFileItemFactory();

        	// Create a new file upload handler
        	ServletFileUpload upload = new ServletFileUpload(factory);
        	
        	String folderPath = "";
        	String fileName = "";
        	String description = "";
        	Integer idUser = -1;
            try {
            	// Parse the request
            	List<FileItem> items = upload.parseRequest(request);
                for(FileItem item : items) {
                    if (!item.isFormField()) {
                        String name = item.getName();
                        fileName = FileFormatUtils.getUniqFileName(name);
                        
                        String root = getServletContext().getRealPath("/");
                        
                        folderPath = getFilePath(name);
                        
                        File path = new File(root + folderPath);
                        if (!path.exists()) {
                            path.mkdirs();
                        }
                        
                        File uploadedFile = new File(root + folderPath + fileName);
                        System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
                    } else {
                         if(item.getFieldName().equals("description")) {
                        	 description = item.getString();
                         }
                         if(item.getFieldName().equals("cookie")) {
                        	 idUser = Integer.parseInt(item.getString());
                         }
                    }
                }
                
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                
                Requests r = new Requests();
                r.insertPost(description, folderPath + fileName, Ressources.getUser(idUser).getPseudo());
                
                out.println("<html><head><meta http-equiv=\"refresh\" content=\"0; URL=murGeneral.html\"></head></html>");
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	
	private String getFilePath(String fileName) {
		String basePath = "/files/";
		if(FileFormatUtils.isAudioFile(fileName))
			return basePath + "audio/";
		
		if(FileFormatUtils.isVideoFile(fileName))
			return basePath + "video/";
		
		if(FileFormatUtils.isImageFile(fileName))
			return basePath + "image/";
		
		if(FileFormatUtils.isPdfFile(fileName))
			return basePath + "pdf/";
		
		return basePath + "other/";
	}

}