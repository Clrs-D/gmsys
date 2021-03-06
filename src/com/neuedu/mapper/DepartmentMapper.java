package com.neuedu.mapper;

import com.neuedu.model.Category;
import com.neuedu.model.Department;
import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer departid);

    int insert(Department record);

    Department selectByPrimaryKey(Integer departid);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);
    
    Long findNewCont();
    
    List<Department> findNewsPage(int i, int j);
}