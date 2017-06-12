package com.pm.service;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.dao.TProjectDAO;
import com.pm.dao.TProjectMemberDAO;
import com.pm.entity.TProject;
import com.pm.entity.TProjectMember;

@Service("projectTeamService")
public class ProjectTeamService {

	@Autowired
	TProjectDAO tProjectDAO;
	@Autowired
	TProjectMemberDAO tProjectMemberDAO;
	
	//显示所有项目组
	@SuppressWarnings("unchecked")
	public List<TProject> getAllProjects() {
		return tProjectDAO.findAll();
	}
	
	//显示项目组中成员
	public List<TProjectMember> getProjectMembers(String projectId) {
		return tProjectMemberDAO.findByProjectId(projectId);
	}
	
	//添加项目组成员
	public void addProjectMember(TProjectMember member) {
		tProjectMemberDAO.save(member);
	}
	
	//删除成员 单
	public void deleteMember(TProjectMember member) {
		tProjectMemberDAO.delete(member);
	}
	
	//删除成员 多
	@Transactional
	public void deleteMembers(List<TProjectMember> members) {
		for(TProjectMember member : members) {
			tProjectMemberDAO.delete(member);
		}
	}
	
	//修改成员
	public void updateMember(TProjectMember member) {
		tProjectMemberDAO.update(member);
	}
	
	//点击下拉框显示所有成员
	//根据用户ID找并且去重
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> getAllMembers(){
		List<Map<String, String>> userList = null;
		userList = tProjectMemberDAO.findAllUserNameUnique();
		return userList;
	}
}
