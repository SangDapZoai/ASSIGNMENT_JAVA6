package com.java6ASM.dto;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Serializable groupKey; // Renamed to groupKey

    private Double sum;
    private Long count;

    public Report() {
        super();
    }

    public Report(Serializable groupKey, Double sum, Long count) {
        this.groupKey = groupKey;
        this.sum = sum;
        this.count = count;
    }

    // Getters and setters
    public Serializable getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(Serializable groupKey) {
        this.groupKey = groupKey;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
