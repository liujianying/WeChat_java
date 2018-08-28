package com.tencent.mm.plugin.location_soso.api;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.plugin.r.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;

class SoSoMapView$1 implements b {
    final /* synthetic */ SoSoMapView this$0;

    SoSoMapView$1(SoSoMapView soSoMapView) {
        this.this$0 = soSoMapView;
    }

    public void setZoom(int i) {
        x.d("MicroMsg.SoSoMapView", "set Zoom %d", Integer.valueOf(i));
        this.this$0.getMap().moveCamera(CameraUpdateFactory.zoomTo((float) i));
    }

    public void animateTo(double d, double d2, int i) {
        x.d("MicroMsg.SoSoMapView", "animteTo slat:" + d + " slong:" + d2 + " zoom:" + i);
        if (SoSoMapView.access$000(this.this$0)) {
            this.this$0.getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d, d2), (float) i));
        } else {
            this.this$0.getMap().animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d, d2), (float) i));
        }
        SoSoMapView.access$002(this.this$0, false);
    }

    public void animateTo(double d, double d2) {
        x.d("MicroMsg.SoSoMapView", "animteTo slat:" + d + " slong:" + d2);
        if (SoSoMapView.access$000(this.this$0)) {
            this.this$0.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d, d2)));
        } else {
            this.this$0.getMap().animateCamera(CameraUpdateFactory.newLatLng(new LatLng(d, d2)));
        }
        SoSoMapView.access$002(this.this$0, false);
    }

    public void setCenter(double d, double d2) {
        this.this$0.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d, d2)));
    }

    public void offsetCenter(double d, double d2) {
        setCenter((((double) this.this$0.getMapCenterX()) / 1000000.0d) + d, (((double) this.this$0.getMapCenterY()) / 1000000.0d) + d2);
    }
}
