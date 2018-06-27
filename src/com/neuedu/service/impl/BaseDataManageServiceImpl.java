package com.neuedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.CategoryMapper;
import com.neuedu.mapper.DepartmentMapper;
import com.neuedu.mapper.UserAccountMapper;
import com.neuedu.model.Category;
import com.neuedu.model.Department;
import com.neuedu.model.UserAccount;
import com.neuedu.service.BaseDataManageService;

@Service     //ע��service��ʵ����
@Transactional  //�˴����ٽ��д���SqlSession���ύ���񣬶��ѽ���springȥ�����ˡ�
public class BaseDataManageServiceImpl implements BaseDataManageService{

	@Resource  //ע��ע��
	private CategoryMapper mapper;
	
	@Resource
	private DepartmentMapper DepartmentMapper;
	
	@Override//���½ӿ��ж���ķ���
	public List<Category> selectAll(){
		return mapper.selectAll();
	}
	
	@Override
	public List<Category> selectByCnamemohu(String cname) {
		// TODO Auto-generated method stub
		List<Category> categories = mapper.selectByCnamemohu(cname);
		return categories;
	}
	@Override
	public Category selectByCid(Integer cid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(cid);
	}
	@Override
	public Category findByCidchakan(Integer cid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(cid);
	}
	public void updatezcfl(Category record) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKey(record);
	}
	@Override
	public void deletezcfl(Integer cid) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(cid);
	}
	@Override
	public void addzcfl(Category record) {
		// TODO Auto-generated method stub
		mapper.insert(record);
	}
	
	@Override
	public List<Department> selectAllDepartment() {
		// TODO Auto-generated method stub
		return DepartmentMapper.selectAll();
	}
	@Override
	public Department selectByDid(Integer departid) {
		// TODO Auto-generated method stub
		return DepartmentMapper.selectByPrimaryKey(departid);
	}
	@Override
	public Department findByDidchakan(Integer departid) {
		// TODO Auto-generated method stub
		return DepartmentMapper.selectByPrimaryKey(departid);
	}
	@Override
	public void updatebm(Department record) {
		// TODO Auto-generated method stub
		DepartmentMapper.updateByPrimaryKey(record);
	}
	@Override
	public void deletebm(Integer departid) {
		// TODO Auto-generated method stub
		DepartmentMapper.deleteByPrimaryKey(departid);
	}
	@Override
	public void addbm(Department record) {
		// TODO Auto-generated method stub
		DepartmentMapper.insert(record);
	}
}
