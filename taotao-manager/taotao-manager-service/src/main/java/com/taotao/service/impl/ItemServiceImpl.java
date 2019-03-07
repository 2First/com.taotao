package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p>
 * @author	键盘手
 * @date
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService{
@Autowired
private TbItemMapper itemMapper;

    @Override
    public TbItem getItenById(long itemId) {
        //根据主键查询
//        TbItem item = itemMapper.selectByPrimaryKey(itemId);
        TbItemExample example = new TbItemExample();
        //添加查询条件
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list = itemMapper.selectByExample(example);
        if (list != null && list.size() >0) {
            TbItem item = list.get(0);
            System.out.println("111"+item);
            return item ;

        }

        return null;
    }
}
