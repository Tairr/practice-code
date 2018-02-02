package com.kf.practice.domain.jianshu;

import javax.xml.transform.Source;
import java.util.Date;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/29
 */
public class News  {

    private String title;
    private String author;
    private String info;
    private String link;

    private Source source;
    private int typeId;
    private int sort;
    private int status;
    private boolean explicitLink;
    private Date createTime;
    private Date modifyDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isExplicitLink() {
        return explicitLink;
    }

    public void setExplicitLink(boolean explicitLink) {
        this.explicitLink = explicitLink;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
