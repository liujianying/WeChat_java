package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;

public interface TencentMap extends MapController {
    public static final String VERSION = "1.0.1";

    public interface InfoWindowAdapter {
        View getInfoWindow(Marker marker);

        void onInfoWindowDettached(Marker marker, View view);
    }

    public interface OnErrorListener {
        void collectErrorInfo(String str);
    }

    public interface OnMapCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinish(CameraPosition cameraPosition);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    Circle addCircle(CircleOptions circleOptions);

    Marker addMarker(MarkerOptions markerOptions);

    Polygon addPolygon(PolygonOptions polygonOptions);

    Polyline addPolyline(PolylineOptions polylineOptions);

    void animateCamera(CameraUpdate cameraUpdate);

    void animateCamera(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback);

    void clearAllOverlays();

    boolean clearCache();

    LatLng getMapCenter();

    int getMaxZoomLevel();

    int getMinZoomLevel();

    void getScreenShot(OnScreenShotListener onScreenShotListener);

    void getScreenShot(OnScreenShotListener onScreenShotListener, Rect rect);

    String getVersion();

    int getZoomLevel();

    boolean isAppKeyAvailable();

    boolean isHandDrawMapEnable();

    boolean isSatelliteEnabled();

    boolean isTrafficEnabled();

    void moveCamera(CameraUpdate cameraUpdate);

    void scrollBy(float f, float f2);

    void scrollBy(float f, float f2, long j, CancelableCallback cancelableCallback);

    void set3DEnable(boolean z);

    void setErrorListener(OnErrorListener onErrorListener);

    void setHandDrawMapEnable(boolean z);

    void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter);

    void setMapAnchor(float f, float f2);

    void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener);

    void setOnMapCameraChangeListener(OnMapCameraChangeListener onMapCameraChangeListener);

    void setOnMapClickListener(OnMapClickListener onMapClickListener);

    void setOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener);

    void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener);

    void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener);

    void setOnMarkerDraggedListener(OnMarkerDraggedListener onMarkerDraggedListener);

    void setSatelliteEnabled(boolean z);

    void setTrafficEnabled(boolean z);

    void stopAnimation();

    void zoomIn();

    void zoomInFixing(int i, int i2);

    void zoomOut();

    void zoomOutFixing(int i, int i2);

    void zoomToSpan(double d, double d2);

    void zoomToSpan(LatLng latLng, LatLng latLng2);
}
