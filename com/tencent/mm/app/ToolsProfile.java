package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.w;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;

public final class ToolsProfile extends e {
    public static final String byu = (ad.getPackageName() + ":tools");
    private static Locale locale;

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = ToolsProfile.class.getClassLoader();
        a.bh(ad.getContext());
        k.a(new 1(this));
        k.cN(byu);
        k.setupBrokenLibraryHandler();
        AppLogic.setCallBack(new AppCallBack(ad.getContext()));
        w wVar = new w(c.bj(this.app.getBaseContext()));
        wVar.ez("TOOL");
        af.ewA = bi.a(wVar.eA(".com.tencent.mm.debug.test.display_errcode"), false);
        af.ewB = bi.a(wVar.eA(".com.tencent.mm.debug.test.display_msgstate"), false);
        af.ewC = bi.a(wVar.eA(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        af.ewD = bi.a(wVar.eA(".com.tencent.mm.debug.test.network.force_touch"), false);
        af.ewE = bi.a(wVar.eA(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        af.ewF = bi.a(wVar.eA(".com.tencent.mm.debug.test.crashIsExit"), false);
        af.ewJ = bi.a(wVar.eA(".com.tencent.mm.debug.test.album_show_info"), false);
        af.ewK = bi.a(wVar.eA(".com.tencent.mm.debug.test.location_help"), false);
        af.ewN = bi.a(wVar.eA(".com.tencent.mm.debug.test.force_soso"), false);
        af.ewO = bi.a(wVar.eA(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        af.ewP = bi.a(wVar.eA(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        af.ewQ = bi.a(wVar.eA(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        af.ewT = bi.a(wVar.eA(".com.tencent.mm.debug.test.filterfpnp"), false);
        af.ewU = bi.a(wVar.eA(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bi.a(wVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        af.ewR = a;
        if (a != 4 && af.ewR > 0) {
            z.sOq = af.ewR;
            x.e("MicroMsg.ToolDebugger", "cdn thread num " + af.ewR);
        }
        af.ewS = bi.a(wVar.eA(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CA(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            String string = wVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bi.oW(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.qVJ = "android-" + string;
                d.qVL = string;
                b.VW(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.chq());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.qVM).append(" new: ").append(a);
            d.qVM = (long) a;
        } catch (Exception e3) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            wVar.cXF.cWO = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bi.a(wVar.eA(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bi.a(wVar.eA(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bi.a(wVar.eA(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bi.a(wVar.eA(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        af.exh = bi.aG(wVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        x.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + af.exh);
        af.exi = bi.aG(wVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        x.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + af.exi);
        af.exj = bi.a(wVar.eA(".com.tencent.mm.debug.skiploadurlcheck"), false);
        x.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + af.exj);
        af.exk = bi.a(wVar.eA(".com.tencent.mm.debug.forcex5webview"), false);
        x.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + af.exk);
        a.cI(byu);
        k.b("wcdb", classLoader);
        k.b("wechatcommon", classLoader);
        k.b(com.tencent.mm.sdk.a.sFa, classLoader);
        k.b("wechatImgTools", classLoader);
        k.b("FFmpeg", classLoader);
        k.b("wechatpack", classLoader);
        int zj = m.zj();
        if ((zj & 1024) != 0) {
            x.i("MicroMsg.ToolsProfile", "load wechatsight_v7a, core number: %d ", Integer.valueOf(zj >> 12));
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
            x.i("MicroMsg.ToolsProfile", "load wechatsight");
            k.b("wechatsight", classLoader);
            com.tencent.mm.plugin.sight.base.b.nbT = 1;
            com.tencent.mm.plugin.sight.base.b.nbV = 1;
            com.tencent.mm.plugin.sight.base.b.nbW = 640000;
        }
        SightVideoJNI.registerALL();
        locale = MMActivity.initLanguage(this.app.getBaseContext());
        o.ve();
        if (com.tencent.mm.compatible.util.d.fR(14) && b.applicationLike != null) {
            b.applicationLike.getApplication().registerActivityLifecycleCallbacks(new 6(this));
        }
        FileOp.init(false);
        MMBitmapFactory.init();
        x.i("MicroMsg.ToolsProfile", "start time check toolsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
        u.a.eP(ad.getContext());
        2 2 = new 2(this);
        3 3 = new 3(this);
        4 4 = new 4(this);
        XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.uHo);
        r.a(ad.getContext(), 2, 3, 4);
        com.tencent.xweb.b.d.a(com.tencent.mm.plugin.cdndownloader.e.a.aAr());
        WebView.initWebviewCore(ad.getContext(), MMWebView.uHn, "tools", new 5(this));
        com.tencent.mm.sdk.b.a.sFg.b(new l(22, 32));
        u.a.cbB();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        Locale initLanguage = MMActivity.initLanguage(this.app.getBaseContext());
        x.d("MicroMsg.ToolsProfile", "onConfigurationChanged, locale = " + locale.toString() + ", n = " + initLanguage.toString());
        if (!initLanguage.equals(locale)) {
            x.w("MicroMsg.ToolsProfile", "language changed, restart process");
            System.exit(-1);
        }
    }

    public final String toString() {
        return byu;
    }
}
