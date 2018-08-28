package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.mm.ab.w;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.ak.a;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.protocal.c.cgw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b implements Callable<WxaPkgWrappingInfo> {
    public static int fwX = 0;
    public static int fwY = 1;
    final String appId;
    final int bPh;
    volatile int fii;
    String fuu;
    int fwV;
    volatile String fwZ;
    final String id;

    public b(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        this.id = str;
        this.appId = str2;
        this.bPh = i;
        this.fii = i2;
        this.fwZ = str4;
        this.fwV = i3;
        this.fuu = str3;
    }

    /* renamed from: afp */
    public final WxaPkgWrappingInfo call() {
        int i = 1;
        Pair t = ak.t(this.appId, this.bPh, this.fii);
        if (t.second != null) {
            return (WxaPkgWrappingInfo) t.second;
        }
        int i2;
        if (a.fhF.equals(t.first)) {
            if (this.bPh == 10002 || this.bPh == 10102) {
                al a = ((c) g.l(c.class)).aaN().a(this.appId, this.bPh, new String[]{"version", "versionMd5", "versionState"});
                if (a == null) {
                    a((a) t.first);
                    return null;
                }
                com.tencent.mm.ab.a.a b = w.b(new com.tencent.mm.plugin.appbrand.appcache.b(this.appId, a.field_version, a.field_versionMd5, this.bPh == 10102 ? 2 : 1).diG);
                if (b == null || b.errType != 0 || b.errCode != 0) {
                    if (this.fwV == 1) {
                        if (this.id != null && this.id.length() > 0) {
                            Parcelable bundle = new Bundle();
                            bundle.putString("id", this.id);
                            bundle.putInt("widgetState", 2105);
                            f.a(i.aeT().sz(this.id), bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                        }
                        h.mEJ.h(14452, new Object[]{this.fuu + "-" + this.appId, Integer.valueOf(6), Long.valueOf(System.currentTimeMillis())});
                    }
                    return null;
                } else if (bi.oW(((akm) b.dIv).url)) {
                    if (this.fwV == 1) {
                        h.mEJ.h(14452, new Object[]{this.fuu + "-" + this.appId, Integer.valueOf(6), Long.valueOf(System.currentTimeMillis())});
                    }
                    return null;
                } else {
                    if (this.fwV == 1) {
                        h.mEJ.h(14452, new Object[]{this.fuu + "-" + this.appId, Integer.valueOf(5), Long.valueOf(System.currentTimeMillis())});
                    }
                    cgw cgw = new cgw();
                    String str = ((akm) b.dIv).url;
                    this.fwZ = str;
                    cgw.sBd = str;
                    i2 = a.field_version;
                    this.fii = i2;
                    cgw.riv = i2;
                    cgw.sBb = a.field_versionState;
                    cgw.sBc = a.field_versionMd5;
                    ((c) g.l(c.class)).aaN().a(this.appId, cgw, this.bPh);
                }
            }
            WxaPkgWrappingInfo afq = afq();
            if (afq != null) {
                if (this.fwV != 1) {
                    return afq;
                }
                h.mEJ.h(14452, new Object[]{this.fuu + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis())});
                return afq;
            } else if (this.fwV == 1) {
                h.mEJ.h(14452, new Object[]{this.fuu + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis())});
            }
        } else if (!a.fhB.equals(t.first)) {
            x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", new Object[]{this.appId, Integer.valueOf(this.bPh), Integer.valueOf(this.fii), Integer.valueOf(((a) t.first).acj())});
        }
        if (this.bPh == 10002 || this.bPh == 10102) {
            int[] qS = ((c) g.l(c.class)).aaN().qS(this.appId);
            if (qS != null && qS.length > 1) {
                while (true) {
                    i2 = i + 1;
                    Pair t2 = ak.t(this.appId, this.bPh, qS[i]);
                    if (t2 != null && t2.first == a.fhB && t2.second != null) {
                        return (WxaPkgWrappingInfo) t2.second;
                    }
                    if (i2 >= qS.length) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        a((a) t.first);
        return null;
    }

    private WxaPkgWrappingInfo afq() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        com.tencent.mm.plugin.appbrand.q.h hVar = new com.tencent.mm.plugin.appbrand.q.h();
        1 1 = new 1(this, hVar, countDownLatch);
        if (this.bPh == 10002 || this.bPh == 10102) {
            x.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[]{this.appId, Integer.valueOf(this.fii)});
            if (!aq.b(this.appId, this.bPh, this.fii, this.fwZ, 1)) {
                a(a.fhG);
                return null;
            }
        }
        x.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[]{this.appId, Integer.valueOf(this.bPh)});
        if (((c) g.l(c.class)).aaN() == null) {
            x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
            a(a.fhG);
            return null;
        }
        String ai = ((c) g.l(c.class)).aaN().ai(this.appId, this.bPh);
        if (bi.oW(ai)) {
            x.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil");
            a(a.fhC);
            return null;
        }
        aq.a(this.appId, this.bPh, ai, 1);
        try {
            countDownLatch.await();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", e, "tryDownload semaphore exp ", new Object[0]);
        }
        return (WxaPkgWrappingInfo) hVar.value;
    }

    private static void a(a aVar) {
        if (!a.fhC.equals(aVar) && !a.fhE.equals(aVar) && a.fhD.equals(aVar)) {
        }
    }
}
