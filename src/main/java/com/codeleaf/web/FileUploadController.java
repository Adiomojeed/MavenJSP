package com.codeleaf.web;

import java.io.File;
import java.io.IOException;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class FileUploadController
 */
@WebServlet("/uploadFile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "uploads";
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (JakartaServletFileUpload.isMultipartContent(request)) {
//			String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
			String uploadPath = "/Users/codeleaf/eclipse-workspace/MavenJSP/";
//			File uploadDir = new File(uploadPath);
//			if (!uploadDir.exists()) uploadDir.mkdir();
			for (Part part : request.getParts()) {
			    String fileName = part.getSubmittedFileName();
			    System.out.println(fileName);
			    part.write(uploadPath + fileName);
			}

		} else {
			response.getWriter().println("Only multipart content is accepted");
		}
	}

}
