package com.firefight.controller;

import com.firefight.common.BaseResponse;
import com.firefight.model.request.DeviceAlarmRequest;
import com.firefight.service.DeviceAlarmService;
import com.firefight.utils.ResponseUtils;
import com.firefight.utils.SignUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController("/device")
public class DeviceController {
    @Resource
    private DeviceAlarmService deviceAlarmService;
    private static final String appSecret = "";

    @PostMapping("/alarm")
    BaseResponse addAlarm(@RequestHeader("X-AppId") String appId,
                          @RequestHeader("X-Sign") String sign,
                          @RequestHeader("X-Timestamp") String timestamp, @RequestBody DeviceAlarmRequest deviceAlarmRequest) {
        if (appId == null || sign == null || timestamp == null) {
            return ResponseUtils.paramError();
        }

        if (!SignUtils.verifySign(appId, timestamp, appSecret, sign)) {
            return ResponseUtils.authFailed();
        }

        String alarmId = deviceAlarmService.postAlarm(deviceAlarmRequest);
        return ResponseUtils.success("ok");
    }
}
