package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;

public final class CameraUpdateFactory {
    public static CameraUpdate zoomIn() {
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 0;
        return new CameraUpdate(cameraParameter);
    }

    public static CameraUpdate zoomOut() {
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 1;
        return new CameraUpdate(cameraParameter);
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 2;
        cameraParameter.scrollBy_xPixel = f;
        cameraParameter.scrollBy_yPixel = f2;
        return new CameraUpdate(cameraParameter);
    }

    public static CameraUpdate zoomTo(float f) {
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 3;
        cameraParameter.zoomTo_zoom = f;
        return new CameraUpdate(cameraParameter);
    }

    public static CameraUpdate zoomBy(float f) {
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 4;
        cameraParameter.zoomBy_amount = f;
        return new CameraUpdate(cameraParameter);
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 5;
        cameraParameter.zoomBy_Point_amount = f;
        cameraParameter.zoomBy_Point_focus = point;
        return new CameraUpdate(cameraParameter);
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 6;
        cameraParameter.newCameraPosition = cameraPosition;
        return new CameraUpdate(cameraParameter);
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 7;
        cameraParameter.newLatLng = latLng;
        return new CameraUpdate(cameraParameter);
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 8;
        cameraParameter.newLatLngZoom_latlng = latLng;
        cameraParameter.newLatLngZoom_zoom = f;
        return new CameraUpdate(cameraParameter);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 9;
        cameraParameter.newLatLngBounds_bounds = latLngBounds;
        cameraParameter.newLatLngBounds_padding = i;
        return new CameraUpdate(cameraParameter);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        CameraParameter cameraParameter = new CameraParameter();
        cameraParameter.cameraUpdate_type = 10;
        cameraParameter.newLatLngBounds_dimension_bounds = latLngBounds;
        cameraParameter.newLatLngBounds_dimension_width = i;
        cameraParameter.newLatLngBounds_dimension_height = i2;
        cameraParameter.newLatLngBounds_dimension_padding = i3;
        return new CameraUpdate(cameraParameter);
    }
}
