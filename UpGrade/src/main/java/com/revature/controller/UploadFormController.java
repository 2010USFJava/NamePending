package com.revature.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFormController {

	public static void uploadForms(HttpServletRequest req) {
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> multiFiles = sf.parseRequest(req);
			for(FileItem item: multiFiles) {
				item.write(new File("C:\\Users\\David\\Documents\\stsworkspaces\\UpGrade\\src\\main\\webapp\\Attachments\\" + item.getName()));
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
