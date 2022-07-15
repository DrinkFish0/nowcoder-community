package com.drinkfish.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装分页相关的信息
 * @author DrinkFish
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    /** 当前页码 */
    private int current = 1;
    /** 每页显示条数 */
    private int limit = 10;
    /** 总页数 */
    private int rows;
    /** 查询路径(用于复用分页链接) */
    private String path;

    /**
     * 获取当前页的起始行
     */
    public int getOffset() {
        // current * limit - limit
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     */
    public int getTotal() {
        // rows / limit [+1]
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取起始页码
     */
    public int getFrom() {
        int from = current - 2;
        return Math.max(from, 1);
    }

    /**
     * 获取结束页码
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return Math.min(to, total);
    }

}
