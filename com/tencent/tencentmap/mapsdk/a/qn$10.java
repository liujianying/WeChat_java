package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import com.tencent.tencentmap.mapsdk.a.ac.b;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

class qn$10 implements b {
    final /* synthetic */ InfoWindowAdapter a;
    final /* synthetic */ qn b;

    qn$10(qn qnVar, InfoWindowAdapter infoWindowAdapter) {
        this.b = qnVar;
        this.a = infoWindowAdapter;
    }

    public View a(pa paVar) {
        if (this.a != null) {
            return this.a.getInfoWindow(qn.a(this.b, paVar));
        }
        return null;
    }

    public View b(pa paVar) {
        return null;
    }
}
