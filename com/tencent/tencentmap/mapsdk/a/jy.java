package com.tencent.tencentmap.mapsdk.a;

public class jy {
    public static String a() {
        String d = d();
        if (d.equals("didi")) {
            if (ac.a() == 1) {
                return "ddsdk.vectors.map.qq.com";
            }
            return "ddsdk.vectors2.map.qq.com";
        } else if (d.equals("tencentmap")) {
            return "mapvectors.map.qq.com";
        } else {
            return "vectorsdk.map.qq.com";
        }
    }

    public static String b() {
        if (d().equals("didi")) {
            return "/mobile_newmap";
        }
        return "/mvd_map";
    }

    public static String a(String str) {
        String d = d();
        if (d.equals("didi") || d.equals("tencentmap") || !str.contains("indoor_map")) {
            return str;
        }
        return str.replace("http://vectorsdk.map.qq.com/indoor_map?", "http://mapvectors.map.qq.com/indoormap2?") + "&apiKey=" + kh.a;
    }

    public static String c() {
        if (d().equals("didi")) {
            return "1HV13IK65T1XH392";
        }
        return "0M3009PNO62FLOQC";
    }

    private static String d() {
        return "sdk";
    }
}
