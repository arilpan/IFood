package com.ydxiaoyuan.ifood.entity;

/**
 * Created by aril_pan@qq.com on 16-8-18.
 */
public class News {
  private int id;
  private String title;
  private String time;
  private String content;
  //    private String author;

  public News() {

  }

  public News(int id, String title, String time, String content) {
    this.id = id;
    this.title = title;
    this.time = time;
    this.content = content;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
