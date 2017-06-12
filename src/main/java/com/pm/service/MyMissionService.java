package com.pm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.dao.TProjectDAO;
import com.pm.dao.TProjectMemberDAO;
import com.pm.dao.TProjectTaskDAO;
import com.pm.entity.TProject;
import com.pm.entity.TProjectMember;
import com.pm.entity.TProjectTask;

@Service("myMissionService")
public class MyMissionService {

	@Autowired
	TProjectMemberDAO tProjectMemberDAO;
	@Autowired
	TProjectDAO tProjectDAO;
	@Autowired
	TProjectTaskDAO tProjectTaskDAO;
	
	//显示左侧所有我的项目
	public void getMyProjects(List<TProject> list, String userId) {
		List<TProjectMember> projectList = tProjectMemberDAO.findByUserName(userId);
		for (int i = 0; i < projectList.size(); i++) {
			list.add(tProjectDAO.findById(projectList.get(i).getProjectId()));
		}
	}
	
	//查找我的任务，在任务表中查项目ID为选中并且负责人ID是我的条目
	@SuppressWarnings("unchecked")
	public void getMyMissionsInProject(List<TProjectTask> list, String projectId, String userId) {
		list = tProjectTaskDAO.findMyTaskInProject(projectId, userId);
	}
	
	//修改任务进度
	public void updateTaskProgress(TProjectTask task) {
		tProjectTaskDAO.update(task);
	}
	
}
