package com.tencent.mapsdk.raster.model;

import java.util.List;

public interface Polyline extends IOverlay {
    boolean equals(Object obj);

    int getColor();

    String getId();

    List<LatLng> getPoints();

    float getWidth();

    float getZIndex();

    int hashCode();

    boolean isDottedLine();

    boolean isGeodesic();

    boolean isVisible();

    void remove();

    void setColor(int i);

    void setDottedLine(boolean z);

    void setGeodesic(boolean z);

    void setPoints(List<LatLng> list);

    void setVisible(boolean z);

    void setWidth(float f);

    void setZIndex(float f);
}
