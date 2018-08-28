package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.a.a;
import com.tencent.mm.plugin.appbrand.g;

public enum n$a implements a {
    ;

    private n$a(String str) {
    }

    public final int rj(String str) {
        g pY = com.tencent.mm.plugin.appbrand.a.pY(str);
        return (pY == null || pY.fcu == null) ? 0 : pY.fcu.uin;
    }
}
