package com.bjsxt.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Integer pid;

    @Column(name = "pname")
    private String pname;

    @Column(name = "minsal")
    private double minsal;

    @Column(name = "maxsal")
    private double maxsal;

    @Column(name = "releasedate")
    private Date releasedate;

    /**
     * 多对一关联
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id")
    private Company company;

    public Position() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getMinsal() {
        return minsal;
    }

    public void setMinsal(double minsal) {
        this.minsal = minsal;
    }

    public double getMaxsal() {
        return maxsal;
    }

    public void setMaxsal(double maxsal) {
        this.maxsal = maxsal;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Position{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", minsal=" + minsal +
                ", maxsal=" + maxsal +
                ", releasedate=" + releasedate +
                '}';
    }
}
