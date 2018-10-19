package org.ydy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ydy.domain.RestCode;
import org.ydy.domain.Restrespones;
import org.ydy.entity.Activity;
import org.ydy.service.ActivityService;

import java.util.List;

/**
 * @author 姚端阳
 * @date 2018/10/15 16:17
 */
@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    public ActivityService getActivityService() {
        return activityService;
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }
    @GetMapping(value = "/findActivity/{Atv_cust_no}",produces = "application/json;charset=utf-8")
    public Restrespones<List<Activity>> findAll(@PathVariable("Atv_cust_no") String Atv_cust_no){
        return Restrespones.success(activityService.findAll(Atv_cust_no));
    }
    @GetMapping(value = "/findAInfo/{Atv_id}",produces = "application/json;charset=utf-8")
    public Restrespones<Activity> findAInfo(@PathVariable("Atv_id") int Atv_id){
        return Restrespones.success(activityService.findAInfo(Atv_id));
    }

    @PostMapping(value = "/updateActivity",produces = "application/json;charset=utf-8")
    public Restrespones updateLianXi(@RequestBody Activity activity){
        int num=activityService.updateActivity(activity);
        if(num>0){
            return Restrespones.success(num);
        }else{
            return Restrespones.error(RestCode.UPDATE_DEFETE);
        }
    }
}
