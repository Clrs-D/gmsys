package com.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	//�������ͨ��URL��������������е�¼:findBymh.do
		@RequestMapping("/category/findBymh.do")
		public String findByCname(@RequestParam("zha") String cname,HttpServletRequest request){
			List<Category> listcategory=baseDataManageService.selectByCnamemohu(cname);
			request.setAttribute("listCategory", listcategory);
			//session.setAttribute("listCategory", listcategory);
			
			return "zcflxinxi";
		}
	///category/findBymh.do?zha="+params
}
