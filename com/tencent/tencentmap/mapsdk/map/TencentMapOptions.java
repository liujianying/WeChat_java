package com.tencent.tencentmap.mapsdk.map;

import android.view.Surface;

public class TencentMapOptions {
    public static final int MAPTYPE_RASTER = 0;
    public static final int MAPTYPE_VECTOR = 1;
    private boolean enableHandDrawMap = false;
    private Surface mExtSurface;
    private int mMapType = 1;

    public void setMapType(int i) {
        if (i < 0 || i > 1) {
            i = 1;
        }
        this.mMapType = i;
    }

    public int getMapType() {
        return this.mMapType;
    }

    public Surface getExtSurface() {
        return this.mExtSurface;
    }

    public void setExtSurface(Surface surface) {
        this.mExtSurface = surface;
    }

    public TencentMapOptions enableHandDrawMap(boolean z) {
        this.enableHandDrawMap = z;
        return this;
    }

    public boolean isHandDrawMapEnable() {
        return this.enableHandDrawMap;
    }
}
