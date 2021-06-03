package com.xiao.dao.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EmpDO {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private BigDecimal sal;
    private BigDecimal comm;
    private Integer deptno;

}