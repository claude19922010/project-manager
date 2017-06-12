package com.pm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.dao.TProjectDAO;
import com.pm.entity.TProject;
import com.pm.entity.TProjectTime;

@Service("projcetService")
public class ProjectService {

	@Autowired
	TProjectDAO tProjectDAO;
	
	public int findAllProjectNo(){
		int total = 0;
		
		List<TProject> list = null;
		list = tProjectDAO.findAll();
		total = list.size();
		
		return total;
	}
	
	public List<TProject> findAllProjectPaged(int pageSize, int pageNo){
		List<TProject> list = null;
		
		list = tProjectDAO.findAllPaged((pageNo - 1) * pageSize, pageSize);
		
		return list;
	}
	
	public void commitNewProject(TProject tProject) {
		tProjectDAO.updateEntity(tProject);
	}
}
