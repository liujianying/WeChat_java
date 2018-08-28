package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.mm.by.g;
import com.tencent.mm.plugin.appbrand.appcache.a.b.c;
import com.tencent.mm.plugin.appbrand.appcache.a.b.d;
import com.tencent.mm.plugin.appbrand.appcache.a.b.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.f;
import com.tencent.mm.plugin.appbrand.appcache.a.b.h;
import com.tencent.mm.protocal.c.bsd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class b {
    static void aj(List<bsd> list) {
        if (!bi.cX(list)) {
            for (bsd bsd : list) {
                if (bsd.spM == null) {
                    x.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", new Object[]{bsd.spJ, bsd.rbW});
                } else {
                    boolean z;
                    String str = "MicroMsg.AppBrand.PredownloadCmdProcessor";
                    String str2 = "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b)";
                    Object[] objArr = new Object[8];
                    objArr[0] = bsd.spJ;
                    objArr[1] = bsd.rbW;
                    objArr[2] = Boolean.valueOf(bsd.spM.sBy != null);
                    if (bsd.spM.sBz != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[3] = Boolean.valueOf(z);
                    if (bsd.spM.sBA != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[4] = Boolean.valueOf(z);
                    if (bsd.spM.sBB != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[5] = Boolean.valueOf(z);
                    if (bsd.spM.sBC != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[6] = Boolean.valueOf(z);
                    if (bsd.spM.sBD != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[7] = Boolean.valueOf(z);
                    x.i(str, str2, objArr);
                    if (bsd.spM.sBy != null) {
                        g.b(bsd.spJ, bsd.rbW, bsd.spM.sBy).j(new d());
                    }
                    if (bsd.spM.sBz != null) {
                        g.b(bsd.spJ, bsd.rbW, bsd.spM.sBz).j(new c()).g(new 1());
                    }
                    if (bsd.spM.sBA != null) {
                        g.b(bsd.spJ, bsd.rbW, bsd.spM.sBA).j(new e());
                    }
                    if (bsd.spM.sBB != null) {
                        g.b(bsd.spJ, bsd.rbW, bsd.spM.sBB).j(new com.tencent.mm.plugin.appbrand.appcache.a.b.g());
                    }
                    if (bsd.spM.sBC != null) {
                        g.b(bsd.spJ, bsd.rbW, bsd.spM.sBC).j(new f());
                    }
                    if (bsd.spM.sBD != null) {
                        g.b(bsd.spJ, bsd.rbW, bsd.spM.sBD).j(new h());
                    }
                    if (bsd.spM.sBE != null) {
                        g.b(bsd.spJ, bsd.rbW, bsd.spM.sBE).j(new com.tencent.mm.plugin.appbrand.appcache.a.b.b());
                    }
                }
            }
        }
    }
}
