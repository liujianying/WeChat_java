package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;

public class qi implements IMapView {
    private static float c = 1.0f;
    private aa a;
    private TencentMap b;

    public qi(Context context, TencentMapOptions tencentMapOptions) {
        qf.a("vector MapView construct function start");
        float f = context.getResources().getDisplayMetrics().density;
        c = f;
        qo.a(f);
        ad adVar = null;
        if (tencentMapOptions != null) {
            adVar = new ad();
            if (tencentMapOptions.getExtSurface() != null) {
                adVar.a(tencentMapOptions.getExtSurface());
            }
            adVar.a(tencentMapOptions.isHandDrawMapEnable());
        }
        this.a = new aa(context, adVar);
        this.b = new qn(this.a.getMap());
        this.a.getMap().l().a(false);
    }

    public static float a() {
        return c;
    }

    public View getMapView() {
        return this.a;
    }

    public TencentMap getMap() {
        return this.b;
    }

    public UiSettings getUiSettings() {
        if (this.a.getMap() != null) {
            return new qp(this.a.getMap().l());
        }
        return null;
    }

    public Projection getProjection() {
        if (this.a.getMap() != null) {
            return new qm(this.a.getMap());
        }
        return null;
    }

    public MapController getMapController() {
        return this.b;
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (this.a.getMap() != null) {
            this.a.getMap().a(new pb().a(oo.a(view)).a(qo.a(layoutParams.point)));
        }
    }

    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.a != null) {
            this.a.updateViewLayout(view, layoutParams);
        }
    }

    public void onCreate(Bundle bundle) {
    }

    public void onStart() {
        this.a.a();
    }

    public void onResume() {
        this.a.d();
    }

    public void onPause() {
        this.a.e();
    }

    public void onStop() {
        this.a.b();
    }

    public void onRestart() {
        this.a.f();
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
        this.a.c();
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onLowMemory() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            return true;
        }
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a == null) {
            return false;
        }
        if (this.a.dispatchTouchEvent(motionEvent) || this.a.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }
}
