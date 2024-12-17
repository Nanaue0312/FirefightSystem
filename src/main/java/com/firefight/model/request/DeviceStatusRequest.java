package com.firefight.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceStatusRequest implements Serializable {
    private static final long serialVersionUID = 1L;

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
     * 设备状态：1-在线；0-离线
     */
    private Integer deviceStatus;

    /**
     * 电流值（用电设备）
     */
    private Double electricCurrent;

    /**
     * 电压值（用电设备）
     */
    private Double electricVoltage;

    /**
     * 温度值（用电设备）
     */
    private Double temperature;

    /**
     * 剩余电流值（用电设备）
     */
    private Double residualCurrent;

    /**
     * 水压（水压监测设备）
     */
    private Double waterPressure;

    /**
     * 水位百分比（水位监测设备）
     */
    private Double waterLevelPercent;

    /**
     * 水位高度（水位监测设备）
     */
    private Double waterLevelHeight;

    /**
     * 水位立方米（水位监测设备）
     */
    private Double waterLevelStere;

    /**
     * 气体浓度（用气设备）
     */
    private Double gasConcentration;

    /**
     * 烟感浓度（烟感监测设备）
     */
    private Double smokeConcentration;
}
