package com.pm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pm.entity.TProject;
import com.pm.service.ProjectService;

@Controller
@RequestMapping(value = "project")
@SessionAttributes("currUser")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	private static final Logger loger = Logger.getLogger(ProjectController.class);
	
	@RequestMapping(value = "sessionTest")
	public String sessionTest(ModelMap model) {
		loger.info("11111");
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value = "find")
	public Map<String, Object> projcetFind(int pageSize, int pageNo){
		Map<String, Object> ret = new HashMap<String, Object>();
		List<TProject> list = new ArrayList<TProject>();
		int total = 0;
		
		list = projectService.findAllProjectPaged(pageSize, pageNo);
		total = projectService.findAllProjectNo();
		
		ret.put("$data", list);
		ret.put("$entityCount", total);
		System.out.println(ret);
		return ret;
	}
	
	@ResponseBody
	@RequestMapping(value = "commitProject", method = RequestMethod.PUT)
	public TProject commitProject(@RequestBody TProject tProject){
		projectService.commitNewProject(tProject);
		return tProject;
	}
}
