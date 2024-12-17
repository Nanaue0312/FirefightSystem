package com.firefight.utils;

import org.apache.tomcat.util.codec.binary.StringUtils;

import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

public class TypeUtils {
    private static final Map<String, String> DEVICE_TYPE = Map.of(
            "WATERPRESS", "水压监测",
            "WATERLEVEL", "水位监测",
            "GAS", "用气监测",
            "SMOKE", "烟感监测",
            "ELECTRIC", "用电监测",
            "FIRE_CAMERA", "火焰监测摄像设备",
            "OCCUPY_CAMERA", "通道占用摄像设备",
            "LEAVE_CAMERA", "离岗摄像头设备"
    );

    private static final Map<Integer, String> ALARM_TYPE = Map.ofEntries(
            Map.entry(11, "水压过高告警"),
            Map.entry(12, "水压过低告警"),
            Map.entry(13, "水压波动告警"),
            Map.entry(21, "水位过高告警"),
            Map.entry(22, "水位过低告警"),
            Map.entry(23, "水位波动告警"),
            Map.entry(31, "气体浓度过高告警"),
            Map.entry(41, "烟雾浓度过高告警"),
            Map.entry(51, "电流过高告警"),
            Map.entry(52, "电流过低告警"),
            Map.entry(53, "温度过高告警"),
            Map.entry(54, "温度过高告警"),
            Map.entry(55, "剩余电流过高告警"),
            Map.entry(61, "通道占用告警"),
            Map.entry(62, "视频火焰告警"),
            Map.entry(63, "人员离岗报警"),
            Map.entry(91, "设备故障")
    );

    /**
     * 获取设备类型描述
     */
    public static String getDeviceTypeDesc(String code) {
        return DEVICE_TYPE.getOrDefault(code, "未知设备类型");
    }

    /**
     * 获取告警类型描述
     */
    public static String getAlarmTypeDesc(Integer code) {
        return ALARM_TYPE.getOrDefault(code, "未知告警类型");
    }
}
