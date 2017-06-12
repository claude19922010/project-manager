package com.pm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.dao.TProjectDAO;
import com.pm.dao.TProjectMemberDAO;
import com.pm.dao.TProjectTaskDAO;
import com.pm.entity.TProject;
import com.pm.entity.TProjectMember;
import com.pm.entity.TProjectTask;

@Service("missionManagerService")
public class MissionManagerService {
	
	@Autowired
	TProjectDAO tProjectDAO;
	@Autowired
	TProjectMemberDAO tProjectMemberDAO;
	@Autowired
	TProjectTaskDAO tProjectTaskDAO;
	
	//根据把登录者ID为项目管理员的所有项目显示出来
	@SuppressWarnings("unchecked")
	public void getProjectList(List<TProject> list, String userId) {
		
		List<String> projectIdList = null;
		
		//select projectId column in memberSheet where username = userId & role == leader
		projectIdList = tProjectMemberDAO.findProjectByIdAndLeader(userId);
		
		//list = result
		for (int i = 0; i < projectIdList.size(); i++) {
			list.add(tProjectDAO.findById(projectIdList.get(i)));
		}
	}
	
	//根据项目Id查询所有task
	public void getTasksByProjectId(String projectId, List<TProjectTask> list) {
		list = tProjectTaskDAO.findByProjectId(projectId);	
	}
	
	//新增一条任务
	public void addProjectTask(TProjectTask task) {
		tProjectTaskDAO.save(task);
	}
	
	//删除一条任务
	public void deleteProjectTask(TProjectTask task) {
		tProjectTaskDAO.delete(task);
	}
	
	//删除多条任务
	@Transactional
	public void deleteProjectTasks(List<TProjectTask> task) {
		for (int i = 0; i < task.size(); i++) {
			tProjectTaskDAO.delete(task.get(i));
		}
	}
	
	//修改一条任务
	public void updateProjectTask(TProjectTask task) {
		tProjectTaskDAO.merge(task);
	}
	
	//点击负责人按钮，获取项目对应所有成员
	public void getAllMembers(String projectId, List<TProjectMember> list) {
		//成员表里项目ID == projetID
		list = tProjectMemberDAO.findByProjectId(projectId);
	}
	
	//分页查询总条目数
	public int findAllProjectNo(){
		int total = 0;
		
		List<TProjectTask> list = null;
		list = tProjectTaskDAO.findAll();
		total = list.size();
		
		return total;
	}
	
	//分页查询结果
	public List<TProject> findAllProjectPaged(int pageSize, int pageNo){
		List<TProject> list = null;
		
		list = tProjectTaskDAO.findAllPaged((pageNo - 1) * pageSize, pageSize);
		
		return list;
	}
}
