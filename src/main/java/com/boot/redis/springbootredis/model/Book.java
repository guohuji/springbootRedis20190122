package com.boot.redis.springbootredis.model;

/*
    @authuor 郭胡记
    @date 2019/2/17 16:22
*/

import java.util.List;

public class Book {
    private Integer bookid;
    private String bookname;
    private Double price;
    private String author;
    private String pic;
    private String publish;
    public List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Book() {
    }

    public Book(Integer bookid, String bookname, Double price, String author, String pic, String publish, List<User> users) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.price = price;
        this.author = author;
        this.pic = pic;
        this.publish = publish;
        this.users = users;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", pic='" + pic + '\'' +
                ", publish='" + publish + '\'' +
                ", users=" + users +
                '}';
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

}
