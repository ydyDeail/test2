package org.ydy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ydy.domain.RestCode;
import org.ydy.domain.Restrespones;
import org.ydy.entity.LianXi;
import org.ydy.service.LianXiService;

import java.util.List;

/**
 * @author 姚端阳
 * @date 2018/10/15 10:05
 */
@RestController
public class LianXiController {
    @Autowired
    private LianXiService lianXiService;

    public LianXiService getLianXiService() {
        return lianXiService;
    }

    public void setLianXiService(LianXiService lianXiService) {
        this.lianXiService = lianXiService;
    }
    @GetMapping(value = "/findLianXi/{lkm_cust_no}",produces = "application/json;charset=utf-8")
    public Restrespones<List<LianXi>> findAll(@PathVariable("lkm_cust_no") String lkm_cust_no){
        return Restrespones.success(lianXiService.findAll(lkm_cust_no));
    }

    @GetMapping(value = "/findInfo/{lkm_id}",produces = "application/json;charset=utf-8")
    public Restrespones<LianXi> findInfo(@PathVariable("lkm_id") int lkm_id){
        return Restrespones.success(lianXiService.findInfo(lkm_id));
    }

    @PostMapping(value = "/updateLianXi",produces = "application/json;charset=utf-8")
    public Restrespones updateLianXi(@RequestBody LianXi lx){
        int num=lianXiService.updateLianXi(lx);
        if(num>0){
            return Restrespones.success(num);
        }else{
            return Restrespones.error(RestCode.UPDATE_DEFETE);
        }
    }
    @PostMapping(value = "/addLianXi",produces = "application/json;charset=utf-8")
    public Restrespones addLianXi(@RequestBody LianXi lx){
        int num=lianXiService.addLianXi(lx);
        if(num>0){
            return Restrespones.success(num);
        }else{
            return Restrespones.error(RestCode.UPDATE_DEFETE);
        }
    }
}
