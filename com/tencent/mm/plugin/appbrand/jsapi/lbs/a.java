package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.plugin.appbrand.l;

abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    a() {
    }

    static boolean i(l lVar) {
        return com.tencent.mm.pluginsdk.permission.a.bj(lVar.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
    }
}
