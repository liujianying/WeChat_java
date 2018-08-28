package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.a.d.d;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.launching.e;
import com.tencent.mm.protocal.c.chl;
import com.tencent.mm.protocal.c.cho;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class c extends a<Boolean, cho> {
    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        boolean z = true;
        cho cho = (cho) obj;
        if (bi.oW(str2)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdGetCode", "getCode nil appId");
            return Boolean.FALSE;
        } else if (bi.oW(cho.rwk)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdGetCode", "getCode(%s | %s), nil md5", new Object[]{str, str2});
            return Boolean.FALSE;
        } else {
            WxaPkgWrappingInfo aG = e.aG(str2, 0);
            int i;
            if (aG != null && aG.fii >= cho.riv) {
                x.i("MicroMsg.AppBrand.Predownload.CmdGetCode", "call, localUsage(%d) ok, cmd_appId(%s), cmd_version(%d)", new Object[]{Integer.valueOf(aG.fii), str2, Integer.valueOf(cho.riv)});
                i = a.fiY;
                a.n((long) cho.sBu.sBs, 44);
                return Boolean.FALSE;
            } else if (!cho.sBG || ((y) com.tencent.mm.plugin.appbrand.app.e.x(y.class)).q(str2, 1, cho.riv) == null) {
                com.tencent.mm.plugin.appbrand.appcache.a.d.c cVar;
                d dVar = (d) com.tencent.mm.plugin.appbrand.app.e.x(d.class);
                if (bi.oW(str2) || cho == null) {
                    cVar = null;
                } else {
                    com.tencent.mm.plugin.appbrand.appcache.a.d.c cVar2 = new com.tencent.mm.plugin.appbrand.appcache.a.d.c();
                    cVar2.field_appId = str2;
                    cVar2.field_version = cho.riv;
                    cVar2.field_type = cho.sBG ? 1 : 0;
                    boolean b = dVar.b(cVar2, new String[0]);
                    cVar2.field_firstTimeTried = false;
                    cVar2.field_lastRetryTime = 0;
                    cVar2.field_retriedCount = 0;
                    cVar2.field_retryTimes = cho.sil;
                    cVar2.field_retryInterval = (long) cho.sin;
                    cVar2.field_networkType = cho.sBF;
                    cVar2.field_pkgMd5 = cho.rwk;
                    cVar2.field_reportId = cho.sBu.sBs;
                    cVar = b ? dVar.c(cVar2, new String[0]) : dVar.b(cVar2) ? cVar2 : null;
                }
                String str3 = "MicroMsg.AppBrand.Predownload.CmdGetCode";
                String str4 = "getCode, writeCmd %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(cVar != null);
                x.i(str3, str4, objArr);
                if (cVar == null) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } else {
                x.i("MicroMsg.AppBrand.Predownload.CmdGetCode", "call IsEncrypt=true, encryptPkg ok, cmd_appId(%s), cmd_version(%d)", new Object[]{str2, Integer.valueOf(cho.riv)});
                i = a.fiY;
                a.n((long) cho.sBu.sBs, 45);
                return Boolean.FALSE;
            }
        }
    }

    final /* bridge */ /* synthetic */ chl bf(Object obj) {
        return ((cho) obj).sBu;
    }

    final String acp() {
        return "CmdGetCode";
    }
}
