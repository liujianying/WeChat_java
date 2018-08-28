package com.tencent.mm.plugin.location_soso.api;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.r.b;
import com.tencent.mm.plugin.r.d;
import com.tencent.mm.plugin.r.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class SoSoMapView extends MapView implements d {
    public static final String TAG = "MicroMsg.SoSoMapView";
    private boolean firstanim = true;
    private b iController;
    private ViewManager mViewManager;
    private HashMap<String, Object> tagsView = new HashMap();

    public SoSoMapView(Context context) {
        super(context);
        init();
    }

    public SoSoMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SoSoMapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
        init();
    }

    public MapController getController() {
        return getMapController();
    }

    private void setEnableForeignMap(boolean z) {
        try {
            Method declaredMethod = MapView.class.getDeclaredMethod("setForeignEnabled", new Class[]{Boolean.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
        }
    }

    private void init() {
        this.mViewManager = new ViewManager(getMap());
        getMap().set3DEnable(true);
        this.iController = new 1(this);
    }

    public void addView(View view, double d, double d2) {
        this.mViewManager.addView(view, d, d2);
    }

    public void addPinView(View view, double d, double d2) {
        this.mViewManager.addPinView(view, d, d2);
    }

    public b getIController() {
        return this.iController;
    }

    public int getZoomLevel() {
        return getMap() == null ? 16 : getMap().getZoomLevel();
    }

    public void setBuiltInZoomControls(boolean z) {
    }

    public void addNullView(View view) {
        x.d(TAG, "addNullView ");
        addView(view);
    }

    public int getMapCenterX() {
        if (getMapCenter() != null) {
            return (int) (getMapCenter().getLatitude() * 1000000.0d);
        }
        return 0;
    }

    public int getMapCenterY() {
        if (getMapCenter() != null) {
            return (int) (getMapCenter().getLongitude() * 1000000.0d);
        }
        return 0;
    }

    public void updateViewLayout(View view, double d, double d2) {
        this.mViewManager.updateViewLayout(view, d, d2, false);
    }

    public void addOverlay(Object obj) {
    }

    public void requestMapFocus() {
        requestFocus();
    }

    public void addView(Object obj, double d, double d2, String str) {
        this.tagsView.put(str, obj);
    }

    public Object getViewByItag(String str) {
        if (this.tagsView.containsKey(str)) {
            return this.tagsView.get(str);
        }
        return null;
    }

    public Collection<Object> getChilds() {
        return this.tagsView.values();
    }

    public void removeView(View view) {
        this.mViewManager.removeView(view);
        for (String str : this.tagsView.keySet()) {
            if (this.tagsView.get(str).equals(view)) {
                this.tagsView.remove(str);
                return;
            }
        }
    }

    public Set<String> getTags() {
        return this.tagsView.keySet();
    }

    public Object removeViewByTag(String str) {
        Object obj = this.tagsView.get(str);
        if (obj instanceof View) {
            removeView((View) obj);
        }
        return obj;
    }

    public void clean() {
        this.tagsView.clear();
        this.mViewManager.destroy();
    }

    public void addLocationPin(View view) {
        addView(view, 0.0d, 0.0d);
    }

    public void zoomToSpan(double d, double d2, double d3, double d4) {
        getIController().setCenter(d, d2);
        x.d(TAG, "zoomToSpan " + ((int) (1000000.0d * d3)) + " " + ((int) (1000000.0d * d4)) + "  " + (1000000.0d * d) + " " + (1000000.0d * d2));
        if (d3 != 0.0d && d4 != 0.0d && getController() != null) {
            getController().zoomToSpan(d3, d4);
        }
    }

    public void updateLocaitonPinLayout(View view, double d, double d2) {
        x.d(TAG, "updateLocationPinLayout");
        updateLocaitonPinLayout(view, d, d2, false);
    }

    public void updateLocaitonPinLayout(View view, double d, double d2, boolean z) {
        this.mViewManager.updateLocaitonPinLayout(view, d, d2, z);
    }

    public int getZoom() {
        return getZoomLevel();
    }

    public void setMapViewOnTouchListener(OnTouchListener onTouchListener) {
        setOnTouchListener(onTouchListener);
    }

    public Point getPointByGeoPoint(double d, double d2) {
        Point point = new Point();
        getProjection().toPixels(new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d)), point);
        return point;
    }

    public void addAnimTrackView(View view, double d, double d2, String str) {
        this.tagsView.put(str, view);
        GeoPoint geoPoint = new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d));
    }

    public void updateAnimViewLayout(View view, double d, double d2) {
        GeoPoint geoPoint = new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d));
    }

    public float metersToEquatorPixels(double d) {
        return getProjection().metersToEquatorPixels((float) d);
    }

    public e getViewManager() {
        return this.mViewManager;
    }

    public void destroy() {
        this.mViewManager.destroy();
    }

    public void addView(View view, double d, double d2, int i) {
        GeoPoint geoPoint = new GeoPoint((int) (1000000.0d * d), (int) (1000000.0d * d2));
        if (i == -2) {
            addView(view, new LayoutParams(-2, -2, new LatLng(d, d2), 17));
        } else if (i == -1) {
            addView(view, new LayoutParams(-1, -1, new LatLng(d, d2), 17));
        } else {
            addView(view, new LayoutParams(i, i, new LatLng(d, d2), 17));
        }
    }

    public void updateViewLayout(View view, double d, double d2, int i) {
        GeoPoint geoPoint = new GeoPoint((int) (d * 1000000.0d), (int) (d2 * 1000000.0d));
    }
}
