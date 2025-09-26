package com.example.demo.Entities;

import java.io.Serializable;
import java.util.Objects;

public class WorksOnId implements Serializable {
    private Integer employeeSsn;
    private Integer projectNo;

    public WorksOnId() {
    }

    public WorksOnId(Integer employeeSsn, Integer projectNo) {
        this.employeeSsn = employeeSsn;
        this.projectNo = projectNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof WorksOnId))
            return false;
        WorksOnId that = (WorksOnId) o;
        return Objects.equals(employeeSsn, that.employeeSsn) &&
                Objects.equals(projectNo, that.projectNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeSsn, projectNo);
    }
}
