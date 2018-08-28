package com.tencent.map.lib.mapstructure;

import com.tencent.tencentmap.mapsdk.a.jm;

public class MapRouteSectionWithName {
    public static final int kMaxRoadNameLength = 128;
    public int color;
    public int endNum;
    public String roadName;
    public int startNum;

    public static int byteLength() {
        return 140;
    }

    public byte[] toBytes() {
        Object obj = new byte[byteLength()];
        System.arraycopy(jm.a(this.startNum), 0, obj, 0, 4);
        System.arraycopy(jm.a(this.endNum), 0, obj, 4, 4);
        System.arraycopy(jm.a(this.color), 0, obj, 8, 4);
        Object a = jm.a(this.roadName);
        if (a.length < kMaxRoadNameLength) {
            System.arraycopy(a, 0, obj, 12, a.length);
        } else {
            System.arraycopy(a, 0, obj, 12, kMaxRoadNameLength);
        }
        return obj;
    }
}
