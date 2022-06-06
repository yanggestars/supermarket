package com.sup.vo;

import com.sup.entity.Bill;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BillVo extends Bill {
    /**
     * 分页参数，当前是第一页，每页10条数据
     */
    private Integer page=1;
    private Integer limit=10;

    /**
     * 批量删除订单，存放订单ID的数组
     */
    private Integer[] ids;
}
