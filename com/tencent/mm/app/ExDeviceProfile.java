package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.r;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;

public class ExDeviceProfile extends e {
    public static final String byu = (ad.getPackageName() + ":exdevice");

    public final void onCreate() {
        x.i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
        c bj = c.bj(this.app.getBaseContext());
        a.bh(ad.getContext());
        k.cN(byu);
        k.setupBrokenLibraryHandler();
        r rVar = new r(bj);
        rVar.ez("EXDEVICE");
        af.ewA = bi.a(rVar.eA(".com.tencent.mm.debug.test.display_errcode"), false);
        af.ewB = bi.a(rVar.eA(".com.tencent.mm.debug.test.display_msgstate"), false);
        af.ewC = bi.a(rVar.eA(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        af.ewD = bi.a(rVar.eA(".com.tencent.mm.debug.test.network.force_touch"), false);
        af.ewE = bi.a(rVar.eA(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        af.ewF = bi.a(rVar.eA(".com.tencent.mm.debug.test.crashIsExit"), false);
        af.ewJ = bi.a(rVar.eA(".com.tencent.mm.debug.test.album_show_info"), false);
        af.ewK = bi.a(rVar.eA(".com.tencent.mm.debug.test.location_help"), false);
        af.ewN = bi.a(rVar.eA(".com.tencent.mm.debug.test.force_soso"), false);
        af.ewO = bi.a(rVar.eA(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        af.ewP = bi.a(rVar.eA(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        af.ewQ = bi.a(rVar.eA(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        af.ewT = bi.a(rVar.eA(".com.tencent.mm.debug.test.filterfpnp"), false);
        af.ewU = bi.a(rVar.eA(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bi.a(rVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        af.ewR = a;
        if (a != 4 && af.ewR > 0) {
            z.sOq = af.ewR;
            x.e("MicroMsg.ExdDebugger", "cdn thread num " + af.ewR);
        }
        af.ewS = bi.a(rVar.eA(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(rVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CA(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            x.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            String string = rVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bi.oW(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.qVJ = "android-" + string;
                d.qVL = string;
                b.VW(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.chq());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(rVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.qVM).append(" new: ").append(a);
            d.qVM = (long) a;
        } catch (Exception e3) {
            x.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bi.a(rVar.eA(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bi.a(rVar.eA(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bi.a(rVar.eA(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bi.a(rVar.eA(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e4) {
            x.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        af.exh = bi.aG(rVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        x.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + af.exh);
        af.exi = bi.aG(rVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        x.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + af.exi);
        af.exj = bi.a(rVar.eA(".com.tencent.mm.debug.skiploadurlcheck"), false);
        x.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + af.exj);
        o.ve();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        x.d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
    }

    public String toString() {
        return byu;
    }
}
