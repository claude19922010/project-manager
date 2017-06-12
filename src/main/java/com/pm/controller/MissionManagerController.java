package com.pm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pm.dao.TProjectDAO;
import com.pm.entity.TProject;
import com.pm.entity.TProjectMember;
import com.pm.entity.TProjectTask;
import com.pm.service.MissionManagerService;

@RestController
@RequestMapping(value = "misssionManager")
@SessionAttributes("userName")
public class MissionManagerController {
	
	private static final Logger log = LoggerFactory.getLogger(MissionManagerController.class);
	
	@Autowired
	MissionManagerService missionManagerService;
	
	//左侧根据登录者ID与登录权限获取所有可显示项目列表
//	@ResponseBody
	@RequestMapping(value = "projects", method = RequestMethod.GET)
	public Map<String, Object> getProjectIdByTeamLeader(HttpSession session, int pageSize, int pageNo) {
		
		int total = 0;
		String userId = null;
		Map<String, Object> ret = new HashMap<String, Object>();
		List<TProject> list = new ArrayList<TProject>();
		
		//应该根据session获取当前登陆人的ID，并且通过ID获取项目列表
		userId = (String) session.getAttribute("userName");
//		log.info(userId + "misssionManagerController loger");
//		System.out.println(userId + "misssionManagerController system.out");
		
		missionManagerService.getProjectList(list, userId);
		
		ret.put("$data", list);
		ret.put("$entityCount", total);
		
		return ret;
	}
	
	//任务的增删改查
	//查
//	@ResponseBody
	
	@RequestMapping(value = "task", method = RequestMethod.GET)
	public List<TProjectTask> getTasksByProjectId(String projectId) {
		List<TProjectTask> list = null;
		missionManagerService.getTasksByProjectId(projectId, list);
		return list;
	}
	
	//增 右侧新增任务
//	@ResponseBody
	@RequestMapping(value = "task", method = RequestMethod.PUT)
	public TProjectTask addProjectTask(TProjectTask task) {
		missionManagerService.addProjectTask(task);
		return task;
	}
	
	//删 右侧删除任务
//	@ResponseBody
	@RequestMapping(value = "task", method = RequestMethod.DELETE)
	public void deleteProjectTask(List<TProjectTask> task) {
		//do delete
		switch (task.size()) {
		case 1:
			missionManagerService.deleteProjectTask(task.get(0));
			break;
			
		default:
			missionManagerService.deleteProjectTasks(task);
			break;
		}		
	}
	
	//改 右侧修改任务
//	@ResponseBody
	@RequestMapping(value = "task", method = RequestMethod.POST)
	public TProjectTask updateProjectTask(TProjectTask task) { 
		//do uptate
		missionManagerService.updateProjectTask(task);
		return task;
	}
	
	//点击负责人，获得所有项目成员列表
//	@ResponseBody
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public List<TProjectMember> getProjectMemberByProjectId(String projectId) {
		List<TProjectMember> list = null;
		missionManagerService.getAllMembers(projectId, list);
		return list;
	}
}