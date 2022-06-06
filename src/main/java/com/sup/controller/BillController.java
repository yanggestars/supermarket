package com.sup.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sup.common.DataGridView;
import com.sup.common.ResultObj;
import com.sup.common.WebUtils;
import com.sup.entity.Bill;
import com.sup.service.IBillService;
import com.sup.vo.BillVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pty
 * @since 2022-06-05
 */
@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private IBillService billService;
    
    /**
     * 查询所有商品销售信息
     * @param billVo
     * @return
     */
    @RequestMapping("loadAllBill")
    public DataGridView loadAllBill(BillVo billVo){
        IPage<Bill> page = new Page<>(billVo.getPage(),billVo.getLimit());
        QueryWrapper<Bill> queryWrapper = new QueryWrapper<Bill>();
//        //根据客户进行模糊查询
//        queryWrapper.eq(billVo.getCustomerid()!=null&&billVo.getCustomerid()!=0,"customerid",billVo.getCustomerid());
//        //根据商品模糊查询
//        queryWrapper.eq(billVo.getGoodsid()!=null&&billVo.getGoodsid()!=0,"goodsid",billVo.getGoodsid());
//        //根据时间进行模糊查询
//        queryWrapper.eq(1==1,"stu",1);
        IPage<Bill> page1 = billService.page(page, queryWrapper);

        return new DataGridView(page1.getTotal(),page1.getRecords());
    }


    /**
     * 添加商品销售信息
     * @param billVo
     * @return
     */
    @RequestMapping("addBill")
    public ResultObj addBill(BillVo billVo){
        try {
            //设置操作人
            billVo.setCreatedBy((long)1);
            //设置销售时间
            billVo.setCreationDate(new Date());
            billVo.setIsPayment(2);
            billService.save(billVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 更新商品销售信息
     * @param billVo
     * @return
     */
    @RequestMapping("updateBill")
    public ResultObj updateBill(BillVo billVo){
        try {
            billService.updateById(billVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }

    }

//    /**
//     * 删除商品销售信息
//     * @param id
//     * @return
//     */
//    @RequestMapping("deletebill")
//    public ResultObj deletebill(Integer id){
//        try {
//            Bill bill= billService.getById(id);
//            bill.set(0);
//            billService.updateById(bill);
//
//            return ResultObj.DELETE_SUCCESS;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResultObj.DELETE_ERROR;
//        }
//    }
}

