package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.tencentmap.mapsdk.dynamic.c;

public class MapView extends FrameLayout implements IMapView {
    private c mMapProvider;
    private int mMapType;
    private Projection mProjection;
    private UiSettings mUiSettings;
    private IMapView mapView;

    public MapView(Context context) {
        this(context, null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMapType = 1;
        init(null);
    }

    public MapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context);
        this.mMapType = 1;
        init(tencentMapOptions);
    }

    private void init(TencentMapOptions tencentMapOptions) {
        Context context = getContext();
        this.mMapProvider = new c();
        if (tencentMapOptions != null) {
            this.mMapProvider.a(tencentMapOptions.getMapType());
        }
        this.mapView = this.mMapProvider.a(context.getApplicationContext(), tencentMapOptions);
        if (this.mapView != null) {
            addView(this.mapView.getMapView(), new LayoutParams(-1, -1));
        }
        if (context instanceof MapActivity) {
            ((MapActivity) context).setMapView(this);
        }
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (this.mapView != null && layoutParams != null) {
            this.mapView.addView(view, layoutParams);
        }
    }

    public TencentMap getMap() {
        if (this.mapView == null) {
            return null;
        }
        return this.mapView.getMap();
    }

    public View getMapView() {
        return this;
    }

    public void onCreate(Bundle bundle) {
        if (this.mapView != null) {
            this.mapView.onCreate(bundle);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mapView != null) {
            return this.mapView.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mapView.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onStart() {
        if (this.mapView != null) {
            this.mapView.onStart();
        }
    }

    public void onResume() {
        if (this.mapView != null) {
            this.mapView.onResume();
        }
    }

    public void onPause() {
        if (this.mapView != null) {
            this.mapView.onPause();
        }
    }

    public void onStop() {
        if (this.mapView != null) {
            this.mapView.onStop();
        }
    }

    public void onRestart() {
        if (this.mapView != null) {
            this.mapView.onRestart();
        }
    }

    public void onDestroyView() {
        if (this.mapView != null) {
            this.mapView.onDestroyView();
        }
    }

    public void onDestroy() {
        if (this.mapView != null) {
            this.mapView.onDestroy();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.mapView != null) {
            this.mapView.onSaveInstanceState(bundle);
        }
    }

    public void onLowMemory() {
        if (this.mapView != null) {
            this.mapView.onLowMemory();
        }
    }

    public Projection getProjection() {
        if (this.mapView == null) {
            return null;
        }
        return this.mapView.getProjection();
    }

    public MapController getMapController() {
        if (this.mapView == null) {
            return null;
        }
        return this.mapView.getMapController();
    }

    @Deprecated
    public LatLng getMapCenter() {
        if (this.mapView == null || this.mapView.getMap() == null) {
            return null;
        }
        return this.mapView.getMap().getMapCenter();
    }

    public UiSettings getUiSettings() {
        if (this.mapView == null) {
            return null;
        }
        return this.mapView.getUiSettings();
    }

    public void updateViewLayout(View view, LayoutParams layoutParams) {
        if (this.mapView != null) {
            this.mapView.updateViewLayout(view, layoutParams);
        }
    }
}
