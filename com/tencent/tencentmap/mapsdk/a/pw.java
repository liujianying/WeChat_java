package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.tencentmap.mapsdk.a.tw.a;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;

public class pw implements IMapView {
    private tw a;
    private Context b;
    private TencentMap c;
    private Projection d;
    private UiSettings e;

    public pw(Context context, TencentMapOptions tencentMapOptions) {
        this.b = context;
        ua uaVar = null;
        if (tencentMapOptions != null) {
            uaVar = new ua();
            if (tencentMapOptions.getExtSurface() != null) {
                uaVar.a(tencentMapOptions.getExtSurface());
            }
            uaVar.a(tencentMapOptions.isHandDrawMapEnable());
        }
        this.a = new tw(context, uaVar);
        this.c = new qb(this.a.getMap());
        this.d = new qa(this.a.getProjection());
        this.e = new qd(this.a.getUiSettings());
    }

    public View getMapView() {
        return this.a;
    }

    public TencentMap getMap() {
        return this.c;
    }

    public UiSettings getUiSettings() {
        return this.e;
    }

    public Projection getProjection() {
        return this.d;
    }

    public MapController getMapController() {
        return this.c;
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (layoutParams != null) {
            this.a.addView(view, new a(layoutParams.width, layoutParams.height, qc.a(layoutParams.point), layoutParams.alignment));
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
    }

    public void onResume() {
        this.a.a();
    }

    public void onPause() {
        this.a.b();
    }

    public void onStop() {
        this.a.c();
    }

    public void onRestart() {
        this.a.d();
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
        this.a.e();
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
        return this.a.dispatchTouchEvent(motionEvent);
    }
}
