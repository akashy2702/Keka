package com.example.demo.model;

import java.util.List;

public enum JobPriority {
    HIGH(1),
    MEDIUM(2),
    LOW(3);

    private final int value;

    JobPriority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static JobPriority from(String value) {
        List<JobPriority> values = List.of(JobPriority.values());
        for (int i = 0; i < values.size() ; i++) {
            if(values.get(i).name().equals(value)) {
                return values.get(i);
            }
        }
        return null;
    }
}
