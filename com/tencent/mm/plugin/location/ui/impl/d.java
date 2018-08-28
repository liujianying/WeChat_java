package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.plugin.location_soso.SoSoProxyUI;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.plugin.r.c;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements c {
    public static Intent t(Activity activity) {
        return new Intent(activity, SoSoProxyUI.class);
    }

    public static View dL(Context context) {
        SoSoMapView soSoMapView = new SoSoMapView(context);
        soSoMapView.setId(e.g_mapView);
        return soSoMapView;
    }

    public final a d(Activity activity, int i) {
        switch (i) {
            case 2:
                return new c(activity);
            case 4:
                return new h(activity);
            case 5:
                x.i("MicroMsg.MapFactoryImp", "share map");
                return new g(activity);
            default:
                return null;
        }
    }
}
