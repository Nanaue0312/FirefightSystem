package com.firefight.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceAlarmRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    // Getters and Setters
    /**
     * 场所唯一编号
     */
    private String insId;

    /**
     * 产生告警的设备编号
     */
    private String deviceCode;

    /**
     * 产生告警的设备类型
     */
    private String deviceType;

    /**
     * 告警唯一ID
     */
    private String alarmId;

    /**
     * 告警类型
     */
    private String alarmType;

    /**
     * 告警时间
     */
    private String alarmTime;

    /**
     * 告警位置
     */
    private String alarmLocation;

    /**
     * 告警描述
     */
    private String alarmDescription;

}
