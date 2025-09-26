package com.example.demo.Entities;

import java.io.Serializable;
import java.util.Objects;

public class ReportingStructureId implements Serializable {
    private Integer managerSsn;
    private Integer employeeSsn;

    public ReportingStructureId() {
    }

    public ReportingStructureId(Integer managerSsn, Integer employeeSsn) {
        this.managerSsn = managerSsn;
        this.employeeSsn = employeeSsn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ReportingStructureId))
            return false;
        ReportingStructureId that = (ReportingStructureId) o;
        return Objects.equals(managerSsn, that.managerSsn) &&
                Objects.equals(employeeSsn, that.employeeSsn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerSsn, employeeSsn);
    }
}
