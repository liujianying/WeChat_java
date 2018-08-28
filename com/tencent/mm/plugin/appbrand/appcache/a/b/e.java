package com.tencent.mm.plugin.appbrand.appcache.a.b;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.appcache.a.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.protocal.c.cgy;
import com.tencent.mm.protocal.c.cgz;
import com.tencent.mm.protocal.c.chl;
import com.tencent.mm.protocal.c.chq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public class e extends a<Boolean, chq> {
    final /* bridge */ /* synthetic */ chl bf(Object obj) {
        return ((chq) obj).sBu;
    }

    private static Boolean a(String str, String str2, chq chq) {
        d dVar = null;
        String str3 = chq.sBH;
        if (bi.oW(str3)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], empty base64", new Object[]{str, str2});
            return Boolean.FALSE;
        }
        try {
            byte[] decode = Base64.decode(str3, 0);
            cgz cgz = new cgz();
            cgz.aG(decode);
            WxaAttributes e = com.tencent.mm.plugin.appbrand.app.e.aba().e(str, "versionInfo");
            d ael = e == null ? null : e.ael();
            Iterator it = cgz.riC.iterator();
            while (it.hasNext()) {
                d si;
                cgy cgy = (cgy) it.next();
                if ("WxaAppVersionInfo".equals(cgy.riD)) {
                    si = d.si(cgy.mEl);
                } else {
                    si = dVar;
                }
                dVar = si;
            }
            int i;
            if (dVar == null) {
                i = a.fiY;
                a.n((long) chq.sBu.sBs, 87);
                return Boolean.FALSE;
            }
            boolean z;
            i = a.fiY;
            a.n((long) chq.sBu.sBs, 88);
            boolean z2 = ael == null || dVar == null || ael.cbu < dVar.cbu;
            if (z2) {
                boolean z3;
                com.tencent.mm.plugin.appbrand.app.e.aba().a(str, cgz.riB, cgz.riC);
                if (com.tencent.mm.plugin.appbrand.app.e.aba().e(str, new String[0]) != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                int i2 = a.fiY;
                a.n((long) chq.sBu.sBs, z3 ? 85 : 86);
                z = z3;
            } else {
                i = a.fiY;
                a.n((long) chq.sBu.sBs, 84);
                z = false;
            }
            String str4 = "MicroMsg.AppBrand.Predownload.CmdIssueContact";
            String str5 = "call[%s | %s], record.ver %d, issue.ver %d, doIssue %b, issueRet %b";
            Object[] objArr = new Object[6];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(ael == null ? -1 : ael.cbu);
            objArr[3] = Integer.valueOf(dVar == null ? -1 : dVar.cbu);
            objArr[4] = Boolean.valueOf(z2);
            objArr[5] = Boolean.valueOf(z);
            x.i(str4, str5, objArr);
            return Boolean.valueOf(z);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueContact", e2, "call[%s | %s], decode base64", new Object[]{str, str2});
            return Boolean.FALSE;
        }
    }

    final String acp() {
        return "CmdIssueContact";
    }
}
