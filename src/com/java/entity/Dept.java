package com.java.entity;

/**
 * 作者:丁鹏
 * QQ:2431475266
 * 描述:与dept表对应
 * Dept类满足JavaBean规范
 */
public class Dept {
    private Long deptno;//部门编号
    private String dname;//部门名称
    private String loc;//部门地址

    public Dept() {
    }

    public Dept(Long deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }


}
