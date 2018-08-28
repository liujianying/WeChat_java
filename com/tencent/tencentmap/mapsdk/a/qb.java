package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.a.tz.a;
import com.tencent.tencentmap.mapsdk.a.tz.i;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnErrorListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import java.util.HashMap;

public class qb implements TencentMap {
    private tz a;
    private HashMap<Integer, px> b = new HashMap();

    public qb(tz tzVar) {
        this.a = tzVar;
    }

    public void setCenter(LatLng latLng) {
        if (latLng != null) {
            this.a.b(new qw(latLng.getLatitude(), latLng.getLongitude()));
        }
    }

    public void setZoom(int i) {
        this.a.a(i);
    }

    public Circle addCircle(CircleOptions circleOptions) {
        if (circleOptions == null) {
            return null;
        }
        return new pv(this.a.a(qc.a(circleOptions)));
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        if (markerOptions == null) {
            return null;
        }
        Marker pxVar = new px(this.a.a(qc.a(markerOptions)));
        this.b.put(Integer.valueOf(pxVar.getId().hashCode()), pxVar);
        return pxVar;
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        if (polygonOptions == null) {
            return null;
        }
        rb a = qc.a(polygonOptions);
        if (a != null) {
            return new pz(this.a.a(a));
        }
        return null;
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            return null;
        }
        return new py(this.a.a(qc.a(polylineOptions)));
    }

    public void animateTo(LatLng latLng) {
        this.a.a(qc.a(latLng));
    }

    public void animateTo(LatLng latLng, Runnable runnable) {
        this.a.a(qc.a(latLng), runnable);
    }

    public void animateTo(LatLng latLng, long j, CancelableCallback cancelableCallback) {
        this.a.a(qc.a(latLng), j, new 1(this, cancelableCallback));
    }

    public void clearAllOverlays() {
        this.a.a();
    }

    public boolean clearCache() {
        return this.a.b();
    }

    public LatLng getMapCenter() {
        return qc.a(this.a.c());
    }

    public int getZoomLevel() {
        return this.a.d();
    }

    public int getMaxZoomLevel() {
        return this.a.e();
    }

    public int getMinZoomLevel() {
        return this.a.f();
    }

    public String getVersion() {
        return this.a.g();
    }

    public boolean isAppKeyAvailable() {
        return this.a.h();
    }

    public boolean isSatelliteEnabled() {
        return this.a.i();
    }

    public void setSatelliteEnabled(boolean z) {
        this.a.a(z);
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        this.a.a(qc.a(cameraUpdate));
    }

    public void animateCamera(CameraUpdate cameraUpdate) {
        this.a.b(qc.a(cameraUpdate));
    }

    public void animateCamera(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback) {
        this.a.a(qc.a(cameraUpdate), j, new 7(this, cancelableCallback));
    }

    public void scrollBy(float f, float f2) {
        this.a.a(f, f2);
    }

    public void scrollBy(float f, float f2, long j, CancelableCallback cancelableCallback) {
        this.a.a(f, f2, j, new 8(this, cancelableCallback));
    }

    public void zoomIn() {
        this.a.j();
    }

    public void zoomInFixing(int i, int i2) {
        this.a.a(i, i2);
    }

    public void zoomOut() {
        this.a.k();
    }

    public void zoomOutFixing(int i, int i2) {
        this.a.b(i, i2);
    }

    public void zoomToSpan(LatLng latLng, LatLng latLng2) {
        this.a.a(qc.a(latLng), qc.a(latLng2));
    }

    public void zoomToSpan(double d, double d2) {
        this.a.a(d, d2);
    }

    public void setInfoWindowAdapter(final InfoWindowAdapter infoWindowAdapter) {
        this.a.a(new a() {
            public View a(qy qyVar) {
                if (infoWindowAdapter != null) {
                    return infoWindowAdapter.getInfoWindow(qb.this.a(qyVar));
                }
                return null;
            }

            public void a(qy qyVar, View view) {
                if (infoWindowAdapter != null) {
                    infoWindowAdapter.onInfoWindowDettached(qb.this.a(qyVar), view);
                }
            }
        });
    }

    private px a(qy qyVar) {
        if (qyVar == null) {
            return null;
        }
        return (px) this.b.get(Integer.valueOf(qyVar.b().hashCode()));
    }

    public void setOnMarkerDraggedListener(final OnMarkerDraggedListener onMarkerDraggedListener) {
        this.a.a(new i() {
            public void a(qy qyVar) {
                if (onMarkerDraggedListener != null) {
                    onMarkerDraggedListener.onMarkerDrag(qb.this.a(qyVar));
                }
            }

            public void b(qy qyVar) {
                if (onMarkerDraggedListener != null) {
                    onMarkerDraggedListener.onMarkerDragEnd(qb.this.a(qyVar));
                }
            }

            public void c(qy qyVar) {
                if (onMarkerDraggedListener != null) {
                    onMarkerDraggedListener.onMarkerDragStart(qb.this.a(qyVar));
                }
            }
        });
    }

    public void setOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        this.a.a(new 11(this, onMapLoadedListener));
    }

    public void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        this.a.a(new 12(this, onInfoWindowClickListener));
    }

    public void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        this.a.a(new 13(this, onMarkerClickListener));
    }

    public void setOnMapCameraChangeListener(OnMapCameraChangeListener onMapCameraChangeListener) {
        this.a.a(new 14(this, onMapCameraChangeListener));
    }

    public void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.a.a(new 2(this, onMapClickListener));
    }

    public void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.a.a(new 3(this, onMapLongClickListener));
    }

    public void stopAnimation() {
        this.a.l();
    }

    public void getScreenShot(OnScreenShotListener onScreenShotListener) {
        this.a.a(new 4(this, onScreenShotListener));
    }

    public void getScreenShot(OnScreenShotListener onScreenShotListener, Rect rect) {
        this.a.a(new 5(this, onScreenShotListener), rect);
    }

    public void setTrafficEnabled(boolean z) {
        this.a.b(z);
    }

    public boolean isTrafficEnabled() {
        return this.a.m();
    }

    public void setErrorListener(OnErrorListener onErrorListener) {
        tz.a(new 6(this, onErrorListener));
    }

    public void set3DEnable(boolean z) {
    }

    public void setMapAnchor(float f, float f2) {
    }

    public void setHandDrawMapEnable(boolean z) {
        if (this.a != null) {
            this.a.c(z);
        }
    }

    public boolean isHandDrawMapEnable() {
        if (this.a == null) {
            return false;
        }
        return this.a.o();
    }
}
