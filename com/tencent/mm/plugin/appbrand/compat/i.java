package com.tencent.mm.plugin.appbrand.compat;

import android.graphics.Bitmap;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.b.p;
import java.util.LinkedList;

final class i implements p {
    final PolylineOptions foG = new PolylineOptions();

    i() {
    }

    public final void c(Iterable<f> iterable) {
        Iterable linkedList = new LinkedList();
        for (f fVar : iterable) {
            if (fVar instanceof f) {
                linkedList.add(((f) fVar).foC);
            } else {
                linkedList.add(new LatLng(fVar.adG(), fVar.adH()));
            }
        }
        this.foG.addAll(linkedList);
    }

    public final void jT(int i) {
        this.foG.color(i);
    }

    public final void jU(int i) {
        this.foG.width((float) i);
    }

    public final void setDottedLine(boolean z) {
        this.foG.setDottedLine(z);
    }

    public final void jV(int i) {
        this.foG.edgeColor(i);
    }

    public final void jW(int i) {
        this.foG.edgeWidth((float) i);
    }

    public final void u(Bitmap bitmap) {
        this.foG.arrowTexture(new BitmapDescriptor(bitmap));
    }
}
