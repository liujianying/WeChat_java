package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap$OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnErrorListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class qn implements TencentMap {
    private ac a;
    private HashMap<Integer, qj> b = new HashMap();
    private List<pa> c = new ArrayList();
    private boolean d = false;

    public qn(ac acVar) {
        this.a = acVar;
    }

    public void setCenter(LatLng latLng) {
        if (this.a != null && latLng != null) {
            this.a.a(y.a(new ox(latLng.getLatitude(), latLng.getLongitude())));
        }
    }

    public void setZoom(int i) {
        if (this.a != null) {
            this.a.a(y.a((float) (i - qo.a)));
        }
    }

    public Circle addCircle(CircleOptions circleOptions) {
        if (this.a == null || circleOptions == null) {
            return null;
        }
        return new qh(this.a.a(qo.a(circleOptions)));
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        if (this.a == null || markerOptions == null) {
            return null;
        }
        Marker qjVar = new qj(this, this.a.a(qo.a(markerOptions)));
        this.b.put(Integer.valueOf(qjVar.getId().hashCode()), qjVar);
        return qjVar;
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) {
        if (this.a == null || polylineOptions == null) {
            return null;
        }
        return new qk(this.a.a(qo.a(polylineOptions)));
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        if (this.a == null || polygonOptions == null) {
            return null;
        }
        return new ql(this.a.a(qo.a(polygonOptions)));
    }

    public void animateTo(LatLng latLng) {
        if (this.a != null && latLng != null) {
            this.a.b(y.a(qo.a(latLng)));
        }
    }

    @Deprecated
    public void animateTo(LatLng latLng, final Runnable runnable) {
        if (this.a != null && latLng != null) {
            this.a.a(y.a(qo.a(latLng)), new ac$a() {
                public void a() {
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                public void b() {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    public void animateTo(LatLng latLng, long j, CancelableCallback cancelableCallback) {
        if (this.a != null) {
            this.a.a(y.a(qo.a(latLng)), j, new 7(this, cancelableCallback));
        }
    }

    public void clearAllOverlays() {
        if (this.a != null) {
            this.a.h();
        }
    }

    public boolean clearCache() {
        return false;
    }

    public LatLng getMapCenter() {
        if (this.a == null) {
            return null;
        }
        this.a.d();
        return qo.a(this.a.d().a);
    }

    public int getZoomLevel() {
        if (this.a == null) {
            return -1;
        }
        return ((int) this.a.d().b) + qo.a;
    }

    public int getMaxZoomLevel() {
        if (this.a == null) {
            return 19;
        }
        return (int) this.a.e();
    }

    public int getMinZoomLevel() {
        if (this.a == null) {
            return 4;
        }
        return (int) this.a.f();
    }

    public String getVersion() {
        if (this.a == null) {
            return null;
        }
        return this.a.u();
    }

    public boolean isAppKeyAvailable() {
        return true;
    }

    public boolean isSatelliteEnabled() {
        return this.d;
    }

    public void setSatelliteEnabled(boolean z) {
        if (this.a != null) {
            this.d = z;
            this.a.b(z);
        }
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        if (this.a != null && cameraUpdate != null) {
            this.a.a(qo.a(cameraUpdate, this.a.t()));
        }
    }

    public void animateCamera(CameraUpdate cameraUpdate) {
        if (this.a != null && cameraUpdate != null) {
            this.a.b(qo.a(cameraUpdate, this.a.t()));
        }
    }

    public void animateCamera(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback) {
        if (this.a != null && cameraUpdate != null) {
            this.a.a(qo.a(cameraUpdate, this.a.t()), j, new 8(this, cancelableCallback));
        }
    }

    public void scrollBy(float f, float f2) {
        if (this.a != null) {
            this.a.b(y.a(f, f2));
        }
    }

    public void scrollBy(float f, float f2, long j, CancelableCallback cancelableCallback) {
        if (this.a != null) {
            this.a.a(y.a(f, f2), new 9(this, cancelableCallback));
        }
    }

    public void zoomIn() {
        if (this.a != null) {
            this.a.b(y.a());
        }
    }

    public void zoomInFixing(int i, int i2) {
        if (this.a != null) {
            this.a.a(y.a(1.0f, new Point(i, i2)));
        }
    }

    public void zoomOut() {
        if (this.a != null) {
            this.a.b(y.b());
        }
    }

    public void zoomOutFixing(int i, int i2) {
        if (this.a != null) {
            this.a.a(y.a(-1.0f, new Point(i, i2)));
        }
    }

    public void zoomToSpan(LatLng latLng, LatLng latLng2) {
        if (this.a != null) {
            this.a.a(y.a(new oy(qo.a(latLng), qo.a(latLng2)), 0));
        }
    }

    public void zoomToSpan(double d, double d2) {
        zoomToSpan(new LatLng(getMapCenter().getLatitude() - (d / 2.0d), getMapCenter().getLongitude() + (d2 / 2.0d)), new LatLng(getMapCenter().getLatitude() + (d / 2.0d), getMapCenter().getLongitude() - (d2 / 2.0d)));
    }

    public void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        if (this.a != null) {
            this.a.a(new 10(this, infoWindowAdapter));
        }
    }

    private qj a(pa paVar) {
        if (paVar == null) {
            return null;
        }
        return (qj) this.b.get(Integer.valueOf(paVar.g().hashCode()));
    }

    public void setOnMarkerDraggedListener(OnMarkerDraggedListener onMarkerDraggedListener) {
        if (this.a != null) {
            this.a.a(new 11(this, onMarkerDraggedListener));
        }
    }

    public void setOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        if (this.a != null) {
            this.a.a(new 12(this, onMapLoadedListener));
        }
    }

    public void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (this.a != null) {
            this.a.a(new 13(this, onInfoWindowClickListener));
        }
    }

    public void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (this.a != null) {
            this.a.a(new 14(this, onMarkerClickListener));
        }
    }

    public void setOnMapCameraChangeListener(OnMapCameraChangeListener onMapCameraChangeListener) {
        if (this.a != null) {
            this.a.a(new 2(this, onMapCameraChangeListener));
        }
    }

    public void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        if (this.a != null) {
            this.a.a(new 3(this, onMapClickListener));
        }
    }

    public void setOnMapLongClickListener(TencentMap$OnMapLongClickListener tencentMap$OnMapLongClickListener) {
        if (this.a != null) {
            this.a.a(new 4(this, tencentMap$OnMapLongClickListener));
        }
    }

    public void stopAnimation() {
        if (this.a != null) {
            this.a.g();
        }
    }

    public void getScreenShot(OnScreenShotListener onScreenShotListener) {
        if (this.a != null) {
            this.a.a(new 5(this, onScreenShotListener));
        }
    }

    @Deprecated
    public void getScreenShot(OnScreenShotListener onScreenShotListener, Rect rect) {
        if (this.a != null) {
            this.a.a(new 6(this, onScreenShotListener));
        }
    }

    public void setTrafficEnabled(boolean z) {
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public boolean isTrafficEnabled() {
        if (this.a == null) {
            return false;
        }
        return this.a.i();
    }

    @Deprecated
    public void setErrorListener(OnErrorListener onErrorListener) {
        if (this.a != null) {
        }
    }

    public void set3DEnable(boolean z) {
        if (this.a != null) {
            this.a.e(z);
        }
    }

    public void setMapAnchor(float f, float f2) {
        if (this.a != null) {
            this.a.a(f, f2, false);
        }
    }

    public void setHandDrawMapEnable(boolean z) {
        if (this.a != null) {
            this.a.f(z);
        }
    }

    public boolean isHandDrawMapEnable() {
        if (this.a == null) {
            return false;
        }
        return this.a.v();
    }

    protected List<pa> a() {
        return this.c;
    }
}
