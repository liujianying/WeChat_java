package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.ak.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.bcn;
import com.tencent.mm.protocal.c.cgl;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public enum ac {
    ;

    public static void cv(boolean z) {
        e.post(new 1(z), "WxaCommLibVersionChecker");
    }

    private static void a(int i, cgl cgl, int i2) {
        if (com.tencent.mm.plugin.appbrand.app.e.abi() != null) {
            PInt pInt = new PInt();
            com.tencent.mm.plugin.appbrand.app.e.abi().a(cgl, pInt);
            boolean z = com.tencent.mm.plugin.appbrand.app.e.abi().aj("@LibraryAppId", 0) == cgl.version ? ak.p(true, true).first == a.fhF : false;
            x.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(cgl.version), Integer.valueOf(cgl.seJ), cgl.bKg, cgl.url});
            if (z) {
                if (i <= 0 || bi.oW(cgl.bRK)) {
                    m.fgc.A(-1, null);
                } else {
                    m.fgc.A(i, cgl.bRK);
                }
                m.fgc.cs(true);
                t tVar = new t();
                tVar.field_key = "@LibraryAppId";
                tVar.field_version = cgl.version;
                if (!com.tencent.mm.plugin.appbrand.app.e.abn().b(tVar, new String[]{"key", "version"})) {
                    tVar.field_updateTime = bi.VE();
                    tVar.field_scene = (i2 - 1) + 1;
                    com.tencent.mm.plugin.appbrand.app.e.abn().b(tVar);
                }
            }
            if (cgl.seJ > 0 && pInt.value > 0) {
                int i3 = cgl.version;
                com.tencent.mm.plugin.appbrand.task.e.lE(2);
                return;
            }
            return;
        }
        x.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
    }

    public static void a(int i, bcn bcn) {
        if (bcn != null) {
            cgl cgl = new cgl();
            cgl.url = bcn.url;
            cgl.bKg = bcn.bKg;
            cgl.version = bcn.version;
            cgl.seJ = bcn.seJ;
            cgl.sAH = bcn.seI ? 1 : 0;
            cgl.bRK = bcn.bRK;
            a(i, cgl, a.fgH);
        }
    }

    public static void a(cgl cgl) {
        a(-1, cgl, a.fgG);
    }
}
