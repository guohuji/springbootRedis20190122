package com.boot.redis.springbootredis.mapper;

import com.boot.redis.springbootredis.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDeptById(Department department);

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    public int updateDeptById(Department department);
}
