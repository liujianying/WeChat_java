package com.tencent.mm.plugin.appbrand.compat;

import android.content.Context;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.a;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.c;

final class k implements c {
    k() {
    }

    static f b(LatLng latLng) {
        return new 1(latLng);
    }

    static a b(final CameraPosition cameraPosition) {
        return new a() {
        };
    }

    public final b l(Context context, boolean z) {
        return new d(context, z);
    }

    public final f g(double d, double d2) {
        return new f(d, d2);
    }
}
