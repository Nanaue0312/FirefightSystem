package com.firefight.model.request;

import lombok.Data;

import java.io.Serializable;
@Data
public class TransmissionAlarmRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 场所唯一编号
     */
    private String insId;

    /**
     * 用户传输装置设备编号
     */
    private String transmissionCode;

    /**
     * 告警唯一ID
     */
    private String alarmId;

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

    /**
     * 处理状态：0-未处理；1-已处理
     */
    private Integer dealState;

    /**
     * 处理类型：1-火情；2-误报；3-测试
     */
    private Integer dealType;

    /**
     * 处理人
     */
    private String dealPerson;

    /**
     * 处理时间
     */
    private String dealTime;

    /**
     * 告警处理描述
     */
    private String dealDescription;
}
