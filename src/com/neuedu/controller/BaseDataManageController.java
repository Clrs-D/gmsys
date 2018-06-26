package com.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.model.Category;
import com.neuedu.service.BaseDataManageService;
import com.neuedu.service.UserAccountService;

//����mvc�Ŀ�������
@Controller
public class BaseDataManageController {

	// ��mvc�Ŀ��Ʋ�����service�����
	@Autowired
	private BaseDataManageService baseDataManageService;
	
	//�������ͨ��URL��������������е�¼:findAll.do
	@RequestMapping("/category/findAll.do")
	public String findAll(HttpServletRequest request){
		List<Category> listcategory=baseDataManageService.selectAll();
		request.setAttribute("listCategory", listcategory);
		//session.setAttribute("listCategory", listcategory);
		
		return "zcflxinxi";
	}
	///category/findBymh.do?zha="+params
}
