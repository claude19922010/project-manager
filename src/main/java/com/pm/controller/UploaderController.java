package com.pm.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;

import com.pm.service.UploadFileService;


@Controller
@RequestMapping(value = "file")
public class UploaderController {
	
	@Autowired
	UploadFileService uploadFileService;
	@Autowired
	HttpServletRequest request;

	@ResponseBody
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public Map<String, String> fileUpload(@RequestParam("file") MultipartFile file) {
		Map<String, String>	ret = null;
		
		ret = uploadFileService.uploadFile(file, request);
		
		return ret;
	}
}
