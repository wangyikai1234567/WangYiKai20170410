package wangyikai.bwie.com.wangyikai20170410;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * date: 2017/4/11.
 * author: 王艺凯 (lenovo )
 * function:
 */

@Table(name = "title", onCreated = "")
public class ChildInfo {
    /**
     * name = "id"：数据库表中的一个字段
     * isId = true：是否是主键
     * autoGen = true：是否自动增长
     * property = "NOT NULL"：添加约束
     */
    @Column(name = "id", isId = true, autoGen = true, property = "NOT NULL")
    private int id;
    @Column(name = "t_id")
    private int t_id;
    @Column(name = "uri")
    private String uri;
    @Column(name = "title_name")
    private String title_name;


    public ChildInfo() {
    }

    public ChildInfo(int id, int t_id, String uri, String title_name) {
        this.id = id;
        this.t_id = t_id;
        this.uri = uri;
        this.title_name = title_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    @Override
    public String toString() {
        return "ChildInfo{" +
                "id=" + id +
                ", t_id=" + t_id +
                ", uri='" + uri + '\'' +
                ", title_name='" + title_name + '\'' +
                '}';
    }
}