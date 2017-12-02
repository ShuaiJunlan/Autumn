package com.autumnframework.blog.dao.mongo;

import com.autumnframework.blog.model.document.BlogDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:54 2017/12/2.
 */
public interface BlogRepository extends MongoRepository<BlogDetail, String> {
}
