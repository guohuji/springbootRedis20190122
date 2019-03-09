package com.boot.redis.springbootredis.dao;

import com.boot.redis.springbootredis.model.Book;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.security.access.method.P;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {

    public Book selectBook(Integer id);

    public List<Book> selectList(String name);

    @MapKey("bookid")
    public Map<Integer,Book> selectMap(String bookname);

    public Book selectBookResultMap(Integer id);

    public Book selectCollection(Integer id);

    public Book selectCollectionStep(Integer id);

    public Book selectIf(Book book);

    public Book selectChoose(Book book);

    public void selectUpdateSet(Book book);

    public List<Book> selectForeach(@Param("ids") List<Integer> list);

    public void insertForeach(@Param("books") List<Book> book);

    public Book selectParam(@Param("id") Integer id, @Param("bookname") String bookname);

    public Book selectMapMybatis(Map<String,Object> map);
}