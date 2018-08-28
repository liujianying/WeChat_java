package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.sdk.platformtools.bi;

final class ac {
    static String aI(String str, int i) {
        al a = e.abi().a(str, i, new String[]{"versionMd5", "pkgPath"});
        if (a == null || bi.oW(a.field_pkgPath) || !com.tencent.mm.a.e.cn(a.field_pkgPath) || bi.oW(a.field_versionMd5) || !a.field_pkgPath.equals(g.cu(a.field_pkgPath))) {
            return null;
        }
        return a.field_versionMd5;
    }
}
