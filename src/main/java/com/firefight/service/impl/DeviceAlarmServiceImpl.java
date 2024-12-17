package com.firefight.service.impl;

import com.firefight.model.request.DeviceAlarmRequest;
import com.firefight.service.DeviceAlarmService;
import com.firefight.utils.CommonUtils;

public class DeviceAlarmServiceImpl implements DeviceAlarmService {
    @Override
    public String postAlarm(DeviceAlarmRequest request) {
        try {
            if (CommonUtils.isAnyFieldNull(request)) {
                throw new RuntimeException("参数为空");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
