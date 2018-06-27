package com.neuedu.mapper;

import com.neuedu.model.Category;
import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Category record);

    Category selectByPrimaryKey(Integer cid);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
    List<Category> selectByCnamemohu(String cname);

	//void updateByPrimaryKey(Integer cid, String cname);
}