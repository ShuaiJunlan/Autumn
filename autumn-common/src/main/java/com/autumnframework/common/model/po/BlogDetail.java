package com.autumnframework.common.model.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:20 2017/11/17.
 */
@Document(collection = "BlogDetail")
public class BlogDetail {

    @Id
    private String id;
    private String username;
    private Date time;
    private String title;
    private String content_md;
    private String content_html;
    private long byte_count;
    private long visit_times;
    private long comment_times;
    private int state;

    public BlogDetail() {
    }

    public BlogDetail(String id, String username, Date time, String title, String content_md, String content_html, long byte_count, long visit_times, long comment_times, int state) {
        this.id = id;
        this.username = username;
        this.time = time;
        this.title = title;
        this.content_md = content_md;
        this.content_html = content_html;
        this.byte_count = byte_count;
        this.visit_times = visit_times;
        this.comment_times = comment_times;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent_md() {
        return content_md;
    }

    public void setContent_md(String content_md) {
        this.content_md = content_md;
    }

    public String getContent_html() {
        return content_html;
    }

    public void setContent_html(String content_html) {
        this.content_html = content_html;
    }

    public long getByte_count() {
        return byte_count;
    }

    public void setByte_count(long byte_count) {
        this.byte_count = byte_count;
    }

    public long getVisit_times() {
        return visit_times;
    }

    public void setVisit_times(long visit_times) {
        this.visit_times = visit_times;
    }

    public long getComment_times() {
        return comment_times;
    }

    public void setComment_times(long comment_times) {
        this.comment_times = comment_times;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BlogDetail{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", content_md='" + content_md + '\'' +
                ", content_html='" + content_html + '\'' +
                ", byte_count=" + byte_count +
                ", visit_times=" + visit_times +
                ", comment_times=" + comment_times +
                ", state=" + state +
                '}';
    }
}
