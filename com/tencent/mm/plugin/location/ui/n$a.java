package com.tencent.mm.plugin.location.ui;

import android.view.View;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

class n$a implements InfoWindowAdapter {
    final /* synthetic */ n kHJ;

    private n$a(n nVar) {
        this.kHJ = nVar;
    }

    public /* synthetic */ n$a(n nVar, byte b) {
        this(nVar);
    }

    public final View getInfoWindow(Marker marker) {
        x.i("ZItemOverlay", "get info window: %s", new Object[]{Integer.valueOf(this.kHJ.kHG.getVisibility())});
        if ("info_window_tag".equals(marker.getTag())) {
            return this.kHJ.kHG;
        }
        return null;
    }

    public final void onInfoWindowDettached(Marker marker, View view) {
    }
}
