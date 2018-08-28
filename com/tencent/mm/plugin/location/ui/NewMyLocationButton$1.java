package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.ag;

class NewMyLocationButton$1 implements a {
    final /* synthetic */ NewMyLocationButton kFe;

    NewMyLocationButton$1(NewMyLocationButton newMyLocationButton) {
        this.kFe = newMyLocationButton;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        NewMyLocationButton.a(this.kFe).setVisibility(8);
        NewMyLocationButton.b(this.kFe).setVisibility(0);
        if (NewMyLocationButton.c(this.kFe) != null && NewMyLocationButton.d(this.kFe)) {
            NewMyLocationButton.c(this.kFe).getIController().setCenter((double) f2, (double) f);
            if (NewMyLocationButton.c(this.kFe).getZoomLevel() < 16) {
                NewMyLocationButton.c(this.kFe).getIController().setZoom(16);
            }
        }
        new ag(Looper.getMainLooper()).post(new 1(this));
        return false;
    }
}
