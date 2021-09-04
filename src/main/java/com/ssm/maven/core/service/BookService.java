package com.ssm.maven.core.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ssm.maven.core.entity.Book;

public interface BookService extends Serializable
{
     List<Book> findBooks(Map<String, Object> map);

     Long getTotalBooks(Map<String, Object> map);

     int insertBook(Book book);

     Book getBookById(String id);
}
