package com.sup.service.impl;

import com.sup.entity.Bill;
import com.sup.mapper.BillMapper;
import com.sup.service.IBillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pty
 * @since 2022-06-05
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements IBillService {

}
