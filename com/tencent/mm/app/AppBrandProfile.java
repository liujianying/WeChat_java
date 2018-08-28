package com.tencent.mm.app;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.mm.booter.p;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import java.util.Map;
import org.xwalk.core.WebViewExtensionListener;

public class AppBrandProfile extends e {
    protected static String bqA = "";

    public final void onCreate() {
        bqA = ad.getProcessName();
        ClassLoader classLoader = AppBrandProfile.class.getClassLoader();
        a.bh(ad.getContext());
        k.a(new c() {
            public final void c(String str, Throwable th) {
                h.mEJ.a(365, 3, 1, false);
                KVCommCrossProcessReceiver.brP();
            }
        });
        p pVar = new p(com.tencent.mm.booter.c.bj(this.app.getBaseContext()));
        pVar.ez("APPBRAND" + bqA.replace(ad.getPackageName() + ":appbrand", ""));
        af.ewA = bi.a(pVar.eA(".com.tencent.mm.debug.test.display_errcode"), false);
        af.ewB = bi.a(pVar.eA(".com.tencent.mm.debug.test.display_msgstate"), false);
        af.ewC = bi.a(pVar.eA(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        af.ewD = bi.a(pVar.eA(".com.tencent.mm.debug.test.network.force_touch"), false);
        af.ewE = bi.a(pVar.eA(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        af.ewF = bi.a(pVar.eA(".com.tencent.mm.debug.test.crashIsExit"), false);
        af.ewJ = bi.a(pVar.eA(".com.tencent.mm.debug.test.album_show_info"), false);
        af.ewK = bi.a(pVar.eA(".com.tencent.mm.debug.test.location_help"), false);
        af.ewN = bi.a(pVar.eA(".com.tencent.mm.debug.test.force_soso"), false);
        af.ewO = bi.a(pVar.eA(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        af.ewP = bi.a(pVar.eA(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        af.ewQ = bi.a(pVar.eA(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        af.ewT = bi.a(pVar.eA(".com.tencent.mm.debug.test.filterfpnp"), false);
        af.ewU = bi.a(pVar.eA(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bi.a(pVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        af.ewR = a;
        if (a != 4 && af.ewR > 0) {
            z.sOq = af.ewR;
            x.e("MicroMsg.AppBDebugger", "cdn thread num " + af.ewR);
        }
        af.ewS = bi.a(pVar.eA(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        af.exk = bi.a(pVar.eA(".com.tencent.mm.debug.forcex5webview"), false);
        af.exh = bi.aG(pVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        x.d("MicroMsg.AppBDebugger", "Test.jsapiPermission = " + af.exh);
        try {
            a = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CA(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            x.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            String string = pVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bi.oW(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.qVJ = "android-" + string;
                d.qVL = string;
                b.VW(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.chq());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.qVM).append(" new: ").append(a);
            d.qVM = (long) a;
        } catch (Exception e3) {
            x.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            pVar.cXF.cWO = Integer.decode(pVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            x.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bi.a(pVar.eA(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bi.a(pVar.eA(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bi.a(pVar.eA(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bi.a(pVar.eA(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            x.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        k.cN(bqA);
        a.cI(bqA);
        k.b("wcdb", classLoader);
        k.b("wechatcommon", classLoader);
        k.b(com.tencent.mm.sdk.a.sFa, classLoader);
        k.b("FFmpeg", classLoader);
        k.b("wechatpack", classLoader);
        int zj = m.zj();
        if ((zj & 1024) != 0) {
            x.i("MicroMsg.AppBrandProfile", "load wechatsight_v7a, core number: %d", new Object[]{Integer.valueOf(zj >> 12)});
            k.b("wechatsight_v7a", classLoader);
            if ((zj >> 12) >= 4) {
                com.tencent.mm.plugin.sight.base.b.nbT = 3;
                com.tencent.mm.plugin.sight.base.b.nbV = 3;
                com.tencent.mm.plugin.sight.base.b.nbW = 544000;
            } else {
                com.tencent.mm.plugin.sight.base.b.nbT = 1;
                com.tencent.mm.plugin.sight.base.b.nbV = 1;
                com.tencent.mm.plugin.sight.base.b.nbW = 640000;
            }
        } else {
            x.i("MicroMsg.AppBrandProfile", "load wechatsight");
            k.b("wechatsight", classLoader);
            com.tencent.mm.plugin.sight.base.b.nbT = 1;
            com.tencent.mm.plugin.sight.base.b.nbV = 1;
            com.tencent.mm.plugin.sight.base.b.nbW = 640000;
        }
        a.bh(ad.getContext());
        o.ve();
        MMActivity.initLanguage(this.app.getBaseContext());
        FileOp.init(false);
        MMBitmapFactory.init();
        r.a(ad.getContext(), new 2(this), new 3(this), new WebViewExtensionListener() {
            public final Object onMiscCallBack(String str, Object... objArr) {
                if ("AddFilterResources".equals(str)) {
                    com.tencent.mm.svg.a.e.a((Resources) objArr[0], (Map) objArr[1]);
                }
                return null;
            }
        });
        com.tencent.xweb.b.d.a(com.tencent.mm.plugin.cdndownloader.e.a.aAr());
        if (com.tencent.mm.sdk.platformtools.e.chv()) {
            com.tencent.xweb.x5.sdk.d.forceSysWebView();
        }
        WebView.initWebviewCore(ad.getContext(), MMWebView.uHn, "appbrand", new WebView.c() {
            public final void onCoreInitFinished() {
                x.i("MicroMsg.AppBrandProfile", "onCoreInitFinished");
            }

            public final void uL() {
                x.i("MicroMsg.AppBrandProfile", "onCoreInitFailed");
            }
        });
        com.tencent.mm.sdk.b.a.sFg.b(new l(42, 52));
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        x.v("MicroMsg.AppBrandProfile", "onTrimMemory(l : %d)", new Object[]{Integer.valueOf(i)});
    }
}
