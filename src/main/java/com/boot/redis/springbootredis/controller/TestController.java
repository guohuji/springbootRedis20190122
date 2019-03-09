package com.boot.redis.springbootredis.controller;

import com.boot.redis.springbootredis.dao.TestMapper;
import com.boot.redis.springbootredis.dao.UserMapper;
import com.boot.redis.springbootredis.model.Book;
import com.boot.redis.springbootredis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/*
    @authuor 郭胡记
    @date 2019/2/17 16:30
*/
@RestController
public class TestController {

    @Autowired
    public TestMapper testMapper;
    @Autowired
    public UserMapper userMapper;

    @RequestMapping("/book/{id}")
    public Book selectBook(@PathVariable("id") Integer id){
        Book book = testMapper.selectBook(id);
        return book;
    }

    @RequestMapping("/book/list")
    public List<Book> selectList(){
        List<Book> books = testMapper.selectList("11");
        return books;
    }

    @RequestMapping("/book/map")
    public Map<Integer,Book> selectMap(){
        Map<Integer, Book> map = testMapper.selectMap("%java%");
        System.out.println(map);
        return map;
    }

    @RequestMapping("/book/resultMap/{id}")
    public Book selectResultMap(@PathVariable("id") Integer id){
        Book book = testMapper.selectBookResultMap(id);
        return book;
    }


    @RequestMapping("/book/user/{id}")
    public User selectResultMap1(@PathVariable("id") Integer id){
        User user = userMapper.selectUser(id);
        return user;
    }


    @RequestMapping("/book/userStep/{id}")
    public User selectResultStep(@PathVariable("id") Integer id){
        User user = userMapper.selectUserStep(id);
        System.out.println(user+"11111111111***************");
        return user;
    }

    @RequestMapping("/book/userCollection/{id}")
    public Book userCollection(@PathVariable("id") Integer id){
        Book book = testMapper.selectCollection(id);
        System.out.println(book+"-------------------***************");
        return book;
    }


    @RequestMapping("/book/userCollectionStep/{id}")
    public Book userCollectionStep(@PathVariable("id") Integer id){
        Book book = testMapper.selectCollectionStep(id);
        System.out.println(book+"1111111112222222222233333333333333");
        System.out.println(book.users+"==================**************");
        return book;
    }

    @RequestMapping("/book/userCollectionStep111/{id}")
    public List<User> userCollectionStep111(@PathVariable("id") Integer id){
        Book book = testMapper.selectCollectionStep(id);
//        System.out.println(book+"1111111112222222222233333333333333");
        System.out.println(book.users);
        return book.users;
    }

    @RequestMapping("/book/user1/{id}")
    public List<User> selectResult1(@PathVariable("id") Integer id){
        List<User> users = userMapper.selectUserCollectionStep(id);
        return users;
    }

    @RequestMapping("/book/if")
    public Book selectIf(){
        Book book = new Book(null,"%婷婷%",null,null,null,null,null);
        Book selectBook = testMapper.selectIf(book);
        return selectBook;
    }

    @RequestMapping("/book/choose")
    public Book selectChoose(){
        Book book = new Book(5,"%郭胡记%",null,null,"11",null,null);
        Book selectBook = testMapper.selectChoose(book);
        return selectBook;
    }

    @RequestMapping("/book/update")
    public void update(){
        Book book = new Book(6,"郭胡记哈哈666",null,null,"11haha",null,null);
        testMapper.selectUpdateSet(book);
    }

    @RequestMapping("/book/selectForeach")
    public List<Book> selectForeach(){
        List<Book> books = testMapper.selectForeach(Arrays.asList(1, 2, 3));
        return books;
    }

    @RequestMapping("/book/insertForeach")
    public void insertForeach(){
        List<Book> list = new ArrayList<>();
        list.add(new Book(103,"100书",99.9,"专业","222","哈哈去",null));
        list.add(new Book(104,"101书",109.9,"专业100","333","哈哈去33",null));
        list.add(new Book(105,"102书",119.9,"专业110","555","哈哈555",null));
        testMapper.insertForeach(list);
    }

    @RequestMapping("/book/resultParam")
    public Book resultParam(){
        Book book = testMapper.selectParam(99, "书");
        return book;
    }

    @RequestMapping("/book/resultMap")
    public Book resultMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",2);
        map.put("pic",2);
        Book book = testMapper.selectMapMybatis(map);
        return book;
    }
}
