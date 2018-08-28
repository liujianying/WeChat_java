package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.Marker;

public interface TencentMap$OnMarkerDraggedListener {
    void onMarkerDrag(Marker marker);

    void onMarkerDragEnd(Marker marker);

    void onMarkerDragStart(Marker marker);
}
