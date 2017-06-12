//项目申请模块
cola((model)=>{
	//项目列表
	//获取项目列表
	model.describe('projects',{
		provider:{
			url:'project/find',
			pageSize:5
		}
	})

	//项目数据绑定至c-table
	model.widgetConfig({
	    projectTable: {
	        $type: 'table',
	        bind: 'project in projects',
	        showHeader: true,
	        currentPageOnly: true,
	        columns: [
				{$type:'select'},
		        {bind: 'project.state',caption:'状态'},
				{bind: 'project.name',caption:'项目名称'},
				{bind: 'project.projectDept',caption:'申报单位'},
				{bind: 'project.projectTime',caption:'填报时间'},
				{bind: 'project.deliveryTime',caption:'交付时间'},
				{bind: 'project.tagProject',caption:'是否续建项目'},
				{bind: 'project.budgetProject',caption:'项目预算'},
				{bind: 'project.tagHeadBank',caption:'是否与总行应用相关'},
				{bind: 'project.externalParties',caption:'涉及的外部单位'},
				{bind: 'project.projectType',caption:'项目类型'},
				{bind: 'project.declareMeans',caption:'申报方式'},
				{bind: 'project.callUser',caption:'联系人'},
				{bind: 'project.callUserPhone',caption:'联系方式'},
				{bind: 'project.projectBackground',caption:'项目背景及必要性'},
				{bind: 'project.projectTarget',caption:'项目建设目标'},
				{bind: 'project.projectContent',caption:'项目主要内容'},
				{bind: 'project.businessRequirementsId',caption:'业务需求书'}
			]
	    }
	});

	//双击进入修改界面
	//获取点击目标数据，初始化至界面
	model.action({
		doubleClick: (self, arg) => {
			model.set('projectData', arg.item.toJSON())
			cola.widget('projectDetailFrame').show()
		}
	})

	//项目操作
	//新增项目


	//数据校验
	model.dataType({
		name : 'projectDataType',
		properties : {
			name:{
				validators : 'required',
				dataType : 'string',
				required : true
			}
		}
	})
	model.describe('projectData','projectDataType')

// //表单内部
// // 绑定单选框内显示内容

	// 创建数据内容 
	model.set('projectData',{})

	//绑定界面中单选框数据
	model.widgetConfig({
		tagProjectValue:{
			$type:"RadioGroup",
			items:[{
				label:'是',
		 		value:true
		 	},{
		 		label:'否',
		 		value:false
		 	}]
		},
		tagHeadBankValue:{
			$type:"RadioGroup",
			items:[{
				label:'是',
		 		value:1
		 	},{
		 		label:'否',
		 		value:0
		 	}]
		},
	})

	
	model.set('declareMeans',['集中申报','非集中申报'])
	model.set('projectType',['应用系统建设','信息化系统建设','网络建设'])
	// model.set('tagHeadBank',['是','否'])
	// model.set('tagProject',['是','否'])

	//确认并提交
	model.action({
		submitProject: () => {
			if(model.get('projectData').validate()){
				console.log(JSON.stringify(model.get('projectData').toJSON()))
				$.ajax({
					url:'project/commitProject',
					type:'PUT',
					dataType:"json",
					data: JSON.stringify(model.get('projectData').toJSON()),
					contentType: 'application/json',
					success:(r)=>{
						model.get("projects").current.set(r)
						cola.widget('projectDetailFrame').hide()
						cola.NotifyTipManager.success({
							message: '系统消息',
							description: '修改成功！',
							showDuration: 5000
						})

						model.set('projectData',{})
					},
					error:(r)=>{
						console.log(r)
					}
				})
			} else {
				cola.NotifyTipManager.error({
					message: "系统消息",
					description: "请填写指定内容",
					showDuration: 5000
				})
			}
		}
	})


})
	
