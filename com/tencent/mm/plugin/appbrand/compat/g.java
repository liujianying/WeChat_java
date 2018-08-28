package com.tencent.mm.plugin.appbrand.compat;

import android.view.View;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;

final class g extends m<Marker> implements h {
    final Marker foD;

    g(Marker marker) {
        super(marker);
        this.foD = marker;
    }

    public final boolean isInfoWindowShown() {
        return this.foD != null && this.foD.isInfoWindowShown();
    }

    public final void showInfoWindow() {
        if (this.foD != null) {
            this.foD.showInfoWindow();
        }
    }

    public final void hideInfoWindow() {
        if (this.foD != null) {
            this.foD.hideInfoWindow();
        }
    }

    public final f adI() {
        return this.foD == null ? new 1(this) : new f(this.foD.getPosition());
    }

    public final void b(f fVar) {
        if (this.foD == null) {
            return;
        }
        if (fVar instanceof f) {
            this.foD.setPosition(((f) fVar).foC);
        } else {
            this.foD.setPosition(new LatLng(fVar.adG(), fVar.adH()));
        }
    }

    public final float getRotation() {
        return this.foD == null ? 0.0f : this.foD.getRotation();
    }

    public final void setRotation(float f) {
        if (this.foD != null) {
            this.foD.setRotation(f);
        }
    }

    public final Object getTag() {
        return this.foD == null ? null : this.foD.getTag();
    }

    public final View getMarkerView() {
        return this.foD == null ? null : this.foD.getMarkerView();
    }

    public final void set2Top() {
        if (this.foD != null) {
            this.foD.set2Top();
        }
    }
}
