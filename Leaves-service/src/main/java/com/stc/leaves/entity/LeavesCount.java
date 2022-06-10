package com.stc.leaves.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeavesCount {
    private Employee employee;
    private long leavesCount;
}