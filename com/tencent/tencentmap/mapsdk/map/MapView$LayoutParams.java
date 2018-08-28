package com.tencent.tencentmap.mapsdk.map;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mapsdk.raster.model.LatLng;

public class MapView$LayoutParams extends LayoutParams {
    public static final int BOTTOM_CENTER = 81;
    public static final int CENTER = 17;
    public int alignment = 17;
    public int height = 0;
    public LatLng point = null;
    public int width = 0;

    public MapView$LayoutParams(int i, int i2, LatLng latLng, int i3) {
        super(i, i2);
        this.width = i;
        this.height = i2;
        this.point = latLng;
        this.alignment = i3;
    }
}
