package org.example;

import lombok.Getter;
import lombok.Setter;

/**
 * StatisticsItem class represents a statistics item.
 */
@Getter
@Setter
class StatisticsItem {
    private String value;
    private Integer count;

    /**
     * StatisticsItem class constructor.
     *
     * @param value Value of the statistics item.
     * @param count Number of items.
     */
    public StatisticsItem(String value, Integer count) {
        this.value = value;
        this.count = count;
    }
}