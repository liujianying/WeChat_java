package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.ag;

class MyLocationButton$1 implements a {
    final /* synthetic */ MyLocationButton kEJ;

    MyLocationButton$1(MyLocationButton myLocationButton) {
        this.kEJ = myLocationButton;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        MyLocationButton.a(this.kEJ).setVisibility(8);
        MyLocationButton.b(this.kEJ).setVisibility(0);
        if (MyLocationButton.c(this.kEJ) != null && MyLocationButton.d(this.kEJ)) {
            MyLocationButton.c(this.kEJ).getIController().setCenter((double) f2, (double) f);
            if (MyLocationButton.c(this.kEJ).getZoomLevel() < 16) {
                MyLocationButton.c(this.kEJ).getIController().setZoom(16);
            }
        }
        new ag(Looper.getMainLooper()).post(new 1(this));
        return false;
    }
}
