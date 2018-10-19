package org.ydy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ydy.entity.Activity;
import org.ydy.mapper.ActivityMapper;
import org.ydy.service.ActivityService;

import java.util.List;

/**
 * @author 姚端阳
 * @date 2018/10/15 16:16
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    public ActivityMapper getActivityMapper() {
        return activityMapper;
    }

    public void setActivityMapper(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public List<Activity> findAll(String Atv_cust_no) {
        return activityMapper.findAll(Atv_cust_no);
    }

    @Override
    public Activity findAInfo(int Atv_id) {
        return activityMapper.findAInfo(Atv_id);
    }

    @Override
    public int updateActivity(Activity activity) {
        return activityMapper.updateActivity(activity);
    }
}
