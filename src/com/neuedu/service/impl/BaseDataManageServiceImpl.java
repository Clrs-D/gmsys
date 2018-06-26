package com.neuedu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.mapper.CategoryMapper;
import com.neuedu.mapper.UserAccountMapper;
import com.neuedu.model.Category;
import com.neuedu.model.UserAccount;
import com.neuedu.service.BaseDataManageService;

@Service     //ע��service��ʵ����
@Transactional  //�˴����ٽ��д���SqlSession���ύ���񣬶��ѽ���springȥ�����ˡ�
public class BaseDataManageServiceImpl implements BaseDataManageService{

	@Resource  //ע��ע��
	private CategoryMapper mapper;
	
	
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
}
