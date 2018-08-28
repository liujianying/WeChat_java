package com.tencent.map.lib.mapstructure;

import com.tencent.tencentmap.mapsdk.a.jm;

public class LineInfo {
    private static final int ROAD_NAME_BYTE_LEN = 64;
    public int color;
    public int endNum;
    public String roadName;
    public int speed;
    public int startNum;

    public byte[] fromBytes() {
        Object obj = new byte[80];
        System.arraycopy(jm.a(this.startNum), 0, obj, 0, 4);
        System.arraycopy(jm.a(this.endNum), 0, obj, 4, 4);
        System.arraycopy(jm.a(this.color), 0, obj, 8, 4);
        System.arraycopy(jm.a(this.speed), 0, obj, 12, 4);
        Object a = jm.a(this.roadName);
        System.arraycopy(a, 0, obj, 16, a.length);
        return obj;
    }
}
