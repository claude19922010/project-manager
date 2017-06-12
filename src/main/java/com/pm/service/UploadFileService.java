package com.pm.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pm.dao.TPfileDAO;
import com.pm.dao.TProjectDAO;
import com.pm.entity.TPfile;
import com.pm.entity.TProject;

@Service("uploadService")
public class UploadFileService {
	
	
	@Autowired
	TPfileDAO tPfileDAO;
	@Autowired
	TProjectDAO tProjectDAO;
	
	public Map<String, String> uploadFile(MultipartFile file, HttpServletRequest request){
		Map<String, String> ret = new HashMap<String, String>();
			if (!file.isEmpty()) {
				try {
					String id = null;
					String filePath = null;
					String businessRequirementsId = null;
					TPfile tPfile = new TPfile();
					TProject tProject = new TProject();
					
					
					filePath = request.getSession().getServletContext().getRealPath("/") 
							+ "uploadfiles/projectcontent/" 
							+ file.getOriginalFilename();
					
					file.transferTo(new File(filePath));
					System.out.println("Saving file :" + file.getOriginalFilename() + "------------->" + filePath);
					
					UUID uuid = UUID.randomUUID();
					id = uuid.toString();
					System.out.println(id);
					
					tPfile.setPath(filePath);
					tPfile.setFileName(file.getOriginalFilename());
					tPfile.setType(0);
					businessRequirementsId = tPfileDAO.save(tPfile);
					
					tProject.setBusinessRequirementsId(businessRequirementsId);
					tProjectDAO.save(tProject);
					
					ret.put("id", id);
					ret.put("projectContent", filePath);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return ret;
	}
}
