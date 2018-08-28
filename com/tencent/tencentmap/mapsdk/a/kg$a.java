package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;

class kg$a extends GeoPoint {
    float a = 0.0f;
    int b = 0;

    public kg$a(GeoPoint geoPoint) {
        super(geoPoint);
    }

    public String toString() {
        return super.toString() + "," + this.a;
    }
}
