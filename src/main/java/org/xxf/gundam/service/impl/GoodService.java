package org.xxf.gundam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xxf.gundam.config.LogicEnum;
import org.xxf.gundam.domain.GoodsTbl;
import org.xxf.gundam.domain.PlaceTbl;
import org.xxf.gundam.exception.CustomerException;
import org.xxf.gundam.form.good.GoodAddForm;
import org.xxf.gundam.repository.GoodsRepository;
import org.xxf.gundam.repository.PlaceRepository;
import org.xxf.gundam.service.IGoodService;

import java.util.Date;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 下午 4:03
 */
@Service
public class GoodService extends BaseService implements IGoodService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private PlaceRepository placeRepository;

    /**
     * 添加物品
     *
     * @param form
     * @throws Exception
     */
    @Override
    public void addGoods(GoodAddForm form) throws Exception{
        PlaceTbl placeTbl = placeRepository.findById(form.getPlaceId()).orElse(null);
        if(placeTbl == null){
            throw new CustomerException("场所不存在");
        }

        GoodsTbl goodsTbl = new GoodsTbl();
        goodsTbl.setIsApproximate(form.getIsApproximate());
        goodsTbl.setIsDelete(LogicEnum.NO.getValue());
        goodsTbl.setPlaceId(form.getPlaceId());
        goodsTbl.setName(form.getName());
        goodsTbl.setNum(form.getNum());
        goodsTbl.setCreateTime(new Date());
        goodsTbl.setLastMoveTime(new Date());
        goodsRepository.saveAndFlush(goodsTbl);
    }

}
