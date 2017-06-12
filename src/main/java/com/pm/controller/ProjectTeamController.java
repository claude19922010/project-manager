package com.pm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pm.entity.TProject;
import com.pm.entity.TProjectMember;
import com.pm.service.ProjectTeamService;

@Controller
@RequestMapping(value = "projectTeam")
public class ProjectTeamController {
	
	@Autowired
	ProjectTeamService projectTeamService;
	
	//左侧显示所有项目组
	@ResponseBody
	@RequestMapping(value = "Projects", method = RequestMethod.GET)
	public List<TProject> getProjecTs() {
		List<TProject> list = null;
		list = projectTeamService.getAllProjects();
		return list;
	}
	
	//根据左侧用户选中项目组显示其中的成员
	@ResponseBody
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public List<TProjectMember> getTeamMembersByProjectId(String projectId){
		//get team members by project id
		List<TProjectMember> list = null;
		list = projectTeamService.getProjectMembers(projectId);
		return list;
	}
	
	//根据左侧用户选中项目组向其中添加成员
	@ResponseBody
	@RequestMapping(value = "member", method = RequestMethod.POST)
	public TProjectMember addMember(TProjectMember member){
		projectTeamService.addProjectMember(member);
		return member;
	}
	
	//根据右侧选中项目成员删除数据(一个或多个)
	@ResponseBody
	@RequestMapping(value = "member", method = RequestMethod.DELETE)
	public void deleteMember(List<TProjectMember> member){
		switch (member.size()) {
		case 1:
			projectTeamService.deleteMember(member.get(0));
			break;
		default:
			projectTeamService.deleteMembers(member);
			break;
		}
		
	}
	
	//根据选中成员条目，修改其中所有数据
	@ResponseBody
	@RequestMapping(value = "member", method = RequestMethod.PUT)
	public TProjectMember updateMember(TProjectMember member){
		projectTeamService.updateMember(member);
		return member;
	}
	
	//添加成员时，点击成员姓名下拉框显示所有成员姓名，选择后自动填充电话号码
	@ResponseBody
	@RequestMapping(value = "allMembers", method = RequestMethod.GET)
	public List<Map<String, String>> getAllPeople(){
		List<Map<String, String>> list = null;
		list = projectTeamService.getAllMembers();
		return list;
	}
}


