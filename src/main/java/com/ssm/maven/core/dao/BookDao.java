package com.ssm.maven.core.dao;

import com.ssm.maven.core.entity.Book;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public interface BookDao extends Serializable
{
     List<Book> findBooks(Map<String, Object> map);

     Long getTotalBooks(Map<String, Object> map);

     int insertBook(Book book);

     Book getBookById(String id);
}
