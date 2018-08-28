package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.ak$a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.g;
import java.io.Closeable;
import java.io.File;
import org.json.JSONArray;

public final class e {
    public static WxaPkgWrappingInfo aG(String str, int i) {
        int[] qS = com.tencent.mm.plugin.appbrand.app.e.abi().qS(str);
        if (qS != null && qS.length > i) {
            while (true) {
                int i2 = i + 1;
                Pair t = ak.t(str, 0, qS[i]);
                if (t.first == ak$a.APP_READY && t.second != null) {
                    return (WxaPkgWrappingInfo) t.second;
                }
                if (i2 >= qS.length) {
                    break;
                }
                i = i2;
            }
        }
        return null;
    }

    static boolean bA(String str, String str2) {
        boolean z = true;
        if (bi.oW(str) || !com.tencent.mm.a.e.cn(str)) {
            return false;
        }
        ag agVar = new ag(new File(str));
        if (!agVar.abW()) {
            agVar.close();
            return false;
        } else if (bi.oW(str2)) {
            agVar.close();
            return false;
        } else {
            String qB = a.qB(l.vP(str2));
            Closeable qN = agVar.qN(qB);
            if (qN != null) {
                bi.d(qN);
            } else {
                String convertStreamToString = c.convertStreamToString(agVar.qN("app-config.json"));
                if (!bi.oW(convertStreamToString)) {
                    try {
                        JSONArray jSONArray = g.fU(convertStreamToString).getJSONArray("pages");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            if (!bi.oW(string) && qB.startsWith(a.qB(string))) {
                                return true;
                            }
                        }
                        z = false;
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrand.Launching.CheckPkgLogic", "isFilePathExistsInPkg, parse app-config.json, pkgPath(%s), queryPath(%s), e = %s", new Object[]{str, qB, e});
                    }
                }
                z = false;
            }
            agVar.close();
            return z;
        }
    }
}
