package org.ydy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.ydy.entity.LianXi;
import org.ydy.mapper.LianXiMapper;
import org.ydy.service.LianXiService;

import java.util.List;

/**
 * @author 姚端阳
 * @date 2018/10/15 10:03
 */
@Service
public class LianXiServiceImpl implements LianXiService
{
    @Autowired
    private LianXiMapper lianXiMapper;

    public LianXiMapper getLianXiMapper() {
        return lianXiMapper;
    }

    public void setLianXiMapper(LianXiMapper lianXiMapper) {
        this.lianXiMapper = lianXiMapper;
    }

    @Override
    public List<LianXi> findAll(String lkm_cust_no) {
        return lianXiMapper.findAll(lkm_cust_no);
    }

    @Override
    public LianXi findInfo(int lkm_id) {
        return lianXiMapper.findInfo(lkm_id);
    }

    @Override
    public int updateLianXi(LianXi lx) {
        return lianXiMapper.updateLianXi(lx);
    }

    @Override
    public int addLianXi(LianXi lx) {
        return lianXiMapper.addLianXi(lx);
    }
}
