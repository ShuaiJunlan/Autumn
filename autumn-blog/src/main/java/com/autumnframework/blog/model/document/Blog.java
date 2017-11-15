package com.autumnframework.blog.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 9:52 2017/11/15.
 */
@Document(collection = "blog")
public class Blog implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String content;

    public Blog(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
