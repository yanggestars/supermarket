package com.sup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 业务管理的路由器
 * @Author: admin-
 * @Date: 2021/10/13 9:33
 */
@Controller
@RequestMapping("bus")
public class BusinessController {

    /**
     * 跳转到供应商管理页面
     * @return
     */
    @RequestMapping("toProviderManager")
    public String toProviderManager(){
        return "business/provider/providerManager";
    }

    /**
     * 跳转到商品管理页面
     * @return
     */
    @RequestMapping("toGoodsManager")
    public String toGoodsManager(){
        return "business/goods/goodsManager";
    }


    /**
     * 跳转到商品账单管理页面
     * @return
     */
    @RequestMapping("toBillManager")
    public String toSalesManager(){
        return "business/bill/billManager";
    }

    /**
     * 跳转到商品账单管理页面
     * @return
     */
    @RequestMapping("toMailManager")
    public String toMailManager(){
        return "business/mail/mailManager";
    }


}
