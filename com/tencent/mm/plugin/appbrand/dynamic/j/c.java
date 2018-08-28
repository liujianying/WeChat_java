package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.k;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.Closeable;
import java.io.InputStream;

public final class c {
    private static final String[] fgM = af.fgM;

    private static m bi(String str, String str2) {
        Throwable e;
        Closeable agVar;
        Closeable qN;
        try {
            agVar = new ag(str);
            try {
                agVar.abW();
                qN = agVar.qN(str2);
                try {
                    bi.d(agVar);
                    return new m(s.Ui(str2), "UTF-8", qN);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                qN = null;
            }
        } catch (Exception e4) {
            e = e4;
            qN = null;
            agVar = null;
            x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", new Object[]{str, bi.i(e)});
            bi.d(agVar);
            bi.d(qN);
            return null;
        }
    }

    public static String bj(String str, String str2) {
        if (bi.oW(str2)) {
            return "";
        }
        m bk = bk(str, str2);
        if (bk != null) {
            try {
                x.d("MicroMsg.ResPkgReader", "getCacheContent, dataStream available = %d, url = %s", new Object[]{Integer.valueOf(bk.mInputStream.available()), str2});
            } catch (Exception e) {
                x.e("MicroMsg.ResPkgReader", "getCacheContent exp = %s, id = %s, url = %s", new Object[]{e, str, str2});
            }
            return com.tencent.mm.plugin.appbrand.q.c.convertStreamToString(bk.mInputStream);
        }
        x.e("MicroMsg.ResPkgReader", "get cache content for id : %s from url : %s, failed", new Object[]{str, str2});
        return "";
    }

    public static m bk(String str, String str2) {
        x.i("MicroMsg.ResPkgReader", "getCacheResource called, id = %s, reqURL = %s", new Object[]{str, str2});
        if (bi.oW(str2) || s.fj(str2, "about:blank") || com.tencent.mm.plugin.appbrand.q.c.vN(str2)) {
            return null;
        }
        String qC = a.qC(str2);
        WxaWidgetContext sA;
        WxaPkgWrappingInfo aeX;
        if (com.tencent.mm.compatible.loader.a.a(fgM, qC)) {
            sA = k.sA(str);
            aeX = sA != null ? sA.aeX() : null;
            if (aeX == null) {
                return null;
            }
            if (aeX.fik) {
                InputStream openRead = af.openRead(qC);
                if (openRead != null) {
                    return new m(s.Ui(qC), "UTF-8", openRead);
                }
                return null;
            } else if (bi.oW(aeX.ffK)) {
                x.e("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, pkgPath[%s] is Null Or Nil", new Object[]{aeX.ffK});
                return null;
            } else {
                x.d("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, id(%s), fileName(%s)", new Object[]{str, qC});
                return bi(aeX.ffK, qC);
            }
        }
        m mVar;
        sA = k.sA(str);
        aeX = sA != null ? sA.aeW() : null;
        if (aeX == null) {
            x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null appInfo by id %s", new Object[]{str});
            mVar = null;
        } else if (bi.oW(aeX.ffK)) {
            x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get Null Or Nil pkgPath[%s] by appId %s", new Object[]{aeX.ffK, str});
            mVar = null;
        } else {
            String str3 = aeX.ffK;
            if (bi.oW(str3)) {
                x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null or nil pkgLocalPath");
                mVar = null;
            } else {
                x.d("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, id(%s), fileName(%s)", new Object[]{str, qC});
                mVar = bi(str3, qC);
            }
        }
        if (mVar == null) {
            Parcelable bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putInt("widgetState", 2102);
            f.a(i.aeT().sz(str), bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
        }
        return mVar;
    }
}
