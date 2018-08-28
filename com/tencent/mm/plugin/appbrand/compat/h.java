package com.tencent.mm.plugin.appbrand.compat;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.plugin.appbrand.compat.a.b.i;

final class h implements i {
    final MarkerOptions foF = new MarkerOptions();

    h() {
    }

    public final void h(double d, double d2) {
        this.foF.position(new LatLng(d, d2));
    }

    public final void t(Bitmap bitmap) {
        this.foF.icon(new BitmapDescriptor(bitmap));
    }

    public final void Y(float f) {
        this.foF.rotation(f);
    }

    public final void rF(String str) {
        this.foF.title(str);
    }

    public final void bF(View view) {
        this.foF.markerView(view);
    }

    public final void Z(float f) {
        this.foF.alpha(f);
    }

    public final void A(float f, float f2) {
        this.foF.anchor(f, f2);
    }

    public final void g(Animation animation) {
        this.foF.infoWindowShowAnimation(animation);
    }

    public final void h(Animation animation) {
        this.foF.infoWindowHideAnimation(animation);
    }

    public final void adJ() {
        this.foF.visible(true);
    }

    public final void bg(Object obj) {
        this.foF.tag(obj);
    }
}
