package com.tencent.map.lib.util;

import com.tencent.map.lib.basemap.data.GeoPoint;

public class d {
    public static GeoPoint a(int i, int i2) {
        return new GeoPoint((int) Math.ceil(((Math.atan(Math.exp((180.0d - ((double) ((((float) i2) * 360.0f) / 2.68435456E8f))) * 0.017453292519943295d)) / 0.008726646259971648d) - 90.0d) * 1000000.0d), (int) Math.ceil((((double) ((((float) i) * 360.0f) / 2.68435456E8f)) - 180.0d) * 1000000.0d));
    }
}
