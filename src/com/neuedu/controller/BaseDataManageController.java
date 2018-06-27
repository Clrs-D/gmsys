package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.model.Category;
import com.neuedu.model.Department;
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
		
		return "zcflxinxi";
	}
	//�������ͨ��URL��������������е�¼:findBymh.do
	@RequestMapping("/category/findBymh.do")
	public String findByCname(@RequestParam("zha") String cname,HttpServletRequest request){
		List<Category> listcategory=baseDataManageService.selectByCnamemohu(cname);
		request.setAttribute("listCategory", listcategory);
		
		return "zcflxinxi";
	}
	//�������ͨ��URL��������������е�¼:findById.do
	@RequestMapping("/category/findById.do")
	public String findByCid(@RequestParam("cid") Integer cid,HttpServletRequest request){
		Category category=baseDataManageService.selectByCid(cid);
		request.setAttribute("category", category);
		return "updatezcfl";
	}
	//�������ͨ��URL��������������е�¼:findByIdchakan.do
	@RequestMapping("/category/findByIdchakan.do")
	public String findByCidchakan(@RequestParam("cid") Integer cid,HttpServletRequest request){
		Category category=baseDataManageService.findByCidchakan(cid);
		request.setAttribute("category", category);
		return "zcfldetails";
	}
	//�������ͨ��URL��������������е�¼:update.do
	@RequestMapping("/category/update.do")
	public String updatezcfl(Integer cid, String cname,HttpServletRequest request){
		Category record=new Category();
		record.setCid(cid);
		record.setCname(cname);
		request.setAttribute("category", record);
		baseDataManageService.updatezcfl(record);
		return "zcfldetails";
	}
	//�������ͨ��URL��������������е�¼:delete.do
	@RequestMapping("/category/delete.do")
	public String deletezcfl(@RequestParam("cid") String cid, HttpServletRequest request){
		//baseDataManageService.deletezcfl(cid);
		String[] sourcestrStrings=cid.split(":");
		int[] sourceint=new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i]=Integer.parseInt(sourcestrStrings[i]);
			baseDataManageService.deletezcfl(sourceint[i]);
		}
		List<Category> listcategory=baseDataManageService.selectAll();
		request.setAttribute("listCategory", listcategory);
		return "zcflxinxi";
	}
	//�������ͨ��URL��������������е�¼:add.do
	@RequestMapping("/category/add.do")
	public String addzcfl(String cname, HttpServletRequest request){
		Category record=new Category();
		record.setCname(cname);
		baseDataManageService.addzcfl(record);
		List<Category> listcategory=baseDataManageService.selectAll();
		request.setAttribute("listCategory", listcategory);
		return "zcflxinxi";
	}

	
	//��������
	//�������ͨ��URL��������������е�¼:findAll.do
	@RequestMapping("/department/findAll.do")
	public String departmentfindAll(HttpServletRequest request){
		List<Department> listdepartment=baseDataManageService.selectAllDepartment();
		request.setAttribute("listDepartment", listdepartment);
		return "bmxinxi";
	}
	//�������ͨ��URL��������������е�¼:findById.do
	@RequestMapping("/department/findById.do")
	public String findByDid(@RequestParam("departid") Integer departid,HttpServletRequest request){
		Department department=baseDataManageService.selectByDid(departid);
		request.setAttribute("department", department);
		return "updatebm";
	}
	//�������ͨ��URL��������������е�¼:findByIdchakan.do
	@RequestMapping("/department/findByIdchakan.do")
	public String findByDidchakan(@RequestParam("departid") Integer departid,HttpServletRequest request){
		Department department=baseDataManageService.findByDidchakan(departid);
		request.setAttribute("department", department);
		return "bmdetails";
	}
	//�������ͨ��URL��������������е�¼:findBymh.do
	@RequestMapping("/department/findBymh.do")
	public String findByDepartid(@RequestParam("zha") Integer departid,HttpServletRequest request){
		Department department=baseDataManageService.selectByDid(departid);
		List<Object> list = new ArrayList<Object>();
		list.add(department);
		request.setAttribute("listDepartment", list);
		return "bmxinxi";
	}
	//�������ͨ��URL��������������е�¼:update.do
	@RequestMapping("/department/update.do")
	public String updatebm(Integer departid, String departname,String areaname,HttpServletRequest request){
		Department record=new Department();
		record.setDepartid(departid);
		record.setAreaid(baseDataManageService.selectByDid(departid).getAreaid());
		record.setAreaname(areaname);
		record.setDepartname(departname);
		baseDataManageService.updatebm(record);
		request.setAttribute("department", record);
		return "bmdetails";
	}
	//�������ͨ��URL��������������е�¼:delete.do
	@RequestMapping("/department/delete.do")
	public String deletebm(@RequestParam("cid") String departid, HttpServletRequest request){
		//baseDataManageService.deletezcfl(cid);
		String[] sourcestrStrings=departid.split(":");
		int[] sourceint=new int[sourcestrStrings.length];
		for (int i = 0; i < sourcestrStrings.length; i++) {
			sourceint[i]=Integer.parseInt(sourcestrStrings[i]);
			baseDataManageService.deletebm(sourceint[i]);
		}
		List<Department> listdepartment=baseDataManageService.selectAllDepartment();
		request.setAttribute("listDepartment", listdepartment);
		return "bmxinxi";
	}
	//�������ͨ��URL��������������е�¼:add.do
	@RequestMapping("/department/add.do")
	public String addbm(String departname,String areaname, HttpServletRequest request){
		Department record=new Department();
		record.setDepartname(departname);
		record.setAreaname(areaname);
		baseDataManageService.addbm(record);
		List<Department> listdepartment=baseDataManageService.selectAllDepartment();
		request.setAttribute("listDepartment", listdepartment);
		return "bmxinxi";
	}
}
