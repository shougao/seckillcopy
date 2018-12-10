package com.example.secondkill.miaosha.dao;


import com.example.secondkill.miaosha.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    /**
     * 使用注解的方式，使用mybatis
     * @param id
     * @return
     */
    @Select("select * from miaoshaUser where id = #{id}")
    public MiaoshaUser getById(@Param("id")int id);

    @Insert("insert into miaoshaUser(id, name)values(#{id}, #{name})")
    public int insert(MiaoshaUser miaoshaUser);

}
