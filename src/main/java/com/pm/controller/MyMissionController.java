package com.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pm.entity.TProject;
import com.pm.entity.TProjectTask;
import com.pm.service.MyMissionService;

@RestController
@RequestMapping(value = "myMission")
public class MyMissionController {

	@Autowired
	MyMissionService myMissionService;
	
	//显示左侧项目列表
//	@ResponseBody
	@RequestMapping(value = "myProjects", method = RequestMethod.GET)
	public List<TProject> getMyProjects(){
		List<TProject> list = null;
		
		//get my id in session
		String userId = null;
		
		myMissionService.getMyProjects(list, userId);
		return list;
		
	}
	
	//显示列表，我在选定项目中的任务
//	@ResponseBody
	@RequestMapping(value = "missions", method = RequestMethod.GET)
	public List<TProjectTask> getMyMissionInProject(String projectId){
		List<TProjectTask> list = null;
		
		//get my id in session
		String userId = null;
		
		myMissionService.getMyMissionsInProject(list, projectId, userId);
		
		return list;
	}
	
	//修改任务进度
//	@ResponseBody
	@RequestMapping(value = "progress", method = RequestMethod.POST)
	public TProjectTask updateTaskProgress(TProjectTask task){
		//do some update with task.Progress
		return task;
	}
	
}
