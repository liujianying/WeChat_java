package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.t;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.console.Shell;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;

public final class PusherProfile extends e {
    public static final String byu = (ad.getPackageName() + ":push");
    private Shell bzd = new Shell();

    public final void onCreate() {
        t tVar = new t(c.bj(ad.getContext()));
        tVar.ez("PUSH");
        af.ewA = bi.a(tVar.eA(".com.tencent.mm.debug.test.display_errcode"), false);
        af.ewB = bi.a(tVar.eA(".com.tencent.mm.debug.test.display_msgstate"), false);
        af.ewC = bi.a(tVar.eA(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        af.ewD = bi.a(tVar.eA(".com.tencent.mm.debug.test.network.force_touch"), false);
        af.ewE = bi.a(tVar.eA(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        af.ewF = bi.a(tVar.eA(".com.tencent.mm.debug.test.crashIsExit"), false);
        af.ewJ = bi.a(tVar.eA(".com.tencent.mm.debug.test.album_show_info"), false);
        af.ewK = bi.a(tVar.eA(".com.tencent.mm.debug.test.location_help"), false);
        af.ewN = bi.a(tVar.eA(".com.tencent.mm.debug.test.force_soso"), false);
        af.ewO = bi.a(tVar.eA(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        af.ewP = bi.a(tVar.eA(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        af.ewQ = bi.a(tVar.eA(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        af.ewT = bi.a(tVar.eA(".com.tencent.mm.debug.test.filterfpnp"), false);
        af.ewU = bi.a(tVar.eA(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bi.a(tVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        af.ewR = a;
        if (a != 4 && af.ewR > 0) {
            z.sOq = af.ewR;
            x.e("MicroMsg.PushDebugger", "cdn thread num " + af.ewR);
        }
        af.ewS = bi.a(tVar.eA(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        af.ewX = bi.a(tVar.eA(".com.tencent.mm.debug.test.skip_getdns"), false);
        try {
            a = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CA(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            String string = tVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bi.oW(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.qVJ = "android-" + string;
                d.qVL = string;
                b.VW(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.chq());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.qVM).append(" new: ").append(a);
            d.qVM = (long) a;
        } catch (Exception e3) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            tVar.cXF.cWO = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bi.a(tVar.eA(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bi.a(tVar.eA(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bi.a(tVar.eA(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bi.a(tVar.eA(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        a.cI(byu);
        o.onCreate(false);
        com.tencent.mm.bg.d.a("gcm", null, null);
        com.tencent.mm.bg.d.Uo("gcm");
        a.sFg.b(new 1(this));
        w.initLanguage(ad.getContext());
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return byu;
    }
}
