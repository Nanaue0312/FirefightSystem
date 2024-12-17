package com.firefight.service;

import com.firefight.model.request.DeviceAlarmRequest;

public interface DeviceAlarmService {
    /**
     * 上传设备告警信息
     * @param request 告警请求
     * @return 告警ID
     */
    String postAlarm(DeviceAlarmRequest request);
}
