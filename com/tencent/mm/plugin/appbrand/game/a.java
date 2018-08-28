package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class a {
    static String a(g gVar, String str, boolean z) {
        String vM;
        x.i("MicroMsg.GameFileUtils", "Ready to getJsString js! filePath: %s,isAsset:%s", new Object[]{str, Boolean.valueOf(z)});
        if (z) {
            vM = c.vM(str);
        } else {
            vM = ao.a(gVar, str);
        }
        if (bi.oW(vM)) {
            x.e("MicroMsg.GameFileUtils", "js code is null, filePath : " + str);
        }
        return vM;
    }
}
