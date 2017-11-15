package com.autumnframework.blog.dao.mongo;


import com.autumnframework.blog.model.document.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:15 2017/11/15.
 */
public interface CommonRepository extends MongoRepository<Blog, String> {
}
