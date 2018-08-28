package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.appusage.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;

public final class e {
    private static final LinkedList<f> gtK;
    private static final LinkedList<f> gtL;
    private static final f gtM = new c();
    private static final f gtN = new b();

    static {
        LinkedList linkedList = new LinkedList();
        gtK = linkedList;
        linkedList.add(new f(AppBrandUI.class, AppBrandTaskPreloadReceiver.class));
        gtK.add(new f(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class));
        gtK.add(new f(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class));
        gtK.add(new f(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class));
        gtK.add(new f(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class));
        linkedList = new LinkedList();
        gtL = linkedList;
        linkedList.addAll(gtK);
        gtL.add(gtM);
        gtL.add(gtN);
    }

    public static int b(Context context, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        f fVar;
        int i;
        Context context2;
        if (appBrandInitConfig.fqr) {
            fVar = gtM;
            i = 1;
        } else {
            f vB = vB(appBrandInitConfig.appId);
            if (vB == null || vB == gtM || (vB instanceof a)) {
                if (appBrandInitConfig.fqs) {
                    vB = gtN;
                } else {
                    vB = anh();
                }
                b(vB);
                fVar = vB;
                i = 1;
            } else {
                fVar = vB;
                i = 2;
            }
        }
        fVar.a(appBrandInitConfig.appId, appBrandInitConfig.fig, null);
        if (context == null) {
            context2 = ad.getContext();
        } else {
            context2 = context;
        }
        Intent intent = new Intent(context2, fVar.gtQ);
        intent.putExtra("key_appbrand_init_config", appBrandInitConfig);
        intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
        intent.addFlags(268435456);
        if (context2 instanceof Activity) {
            RunningTaskInfo am = bi.am(context2, ((Activity) context2).getTaskId());
            if (!(am == null || am.baseActivity == null || !bi.oV(am.baseActivity.getClassName()).equals(fVar.gtP))) {
                intent.putExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", true);
                intent.addFlags(603979776);
            }
        }
        context2.startActivity(intent);
        if (i == 1) {
            vz(appBrandInitConfig.appId);
        }
        return i;
    }

    public static void aN(String str, int i) {
        f vB = vB(str);
        if (vB != null && ((Integer) vB.gtS.get(str)).intValue() == i && vB.vE(str) != null) {
            vB.vE(str).vy(str);
        }
    }

    public static void lE(int i) {
        Iterator it;
        if (2 == i) {
            it = ani().iterator();
            while (it.hasNext()) {
                ((f) it.next()).amU();
            }
            ang();
            return;
        }
        it = ani().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            fVar.amU();
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : fVar.gtT.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.gts = a.gtC;
                    appBrandRemoteTaskController.gtt = i;
                    appBrandRemoteTaskController.ahH();
                }
            }
        }
    }

    public static void vz(String str) {
        f vB = vB(str);
        if (vB != null && vB.vE(str) != null) {
            vB.vE(str).vy(str);
        }
    }

    public static void ang() {
        if (b.acE()) {
            anh().Fo();
        }
    }

    public static void vA(String str) {
        f vC = vC(str);
        if (vC != null) {
            ah.i(new 1(vC), 500);
        }
    }

    public static void onNetworkChange() {
        Iterator it = ani().iterator();
        while (it.hasNext()) {
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : ((f) it.next()).gtT.values()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.gts = a.gtG;
                    appBrandRemoteTaskController.ahH();
                }
            }
        }
    }

    private static f anh() {
        f fVar;
        synchronized (gtK) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= gtK.size()) {
                    fVar = null;
                    break;
                } else if (((f) gtK.get(i2)).gtS.keySet().isEmpty()) {
                    fVar = (f) gtK.get(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (fVar != null) {
            } else {
                fVar = (f) gtK.getFirst();
            }
        }
        return fVar;
    }

    private static f vB(String str) {
        Iterator it = ani().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.gtS.keySet().contains(str)) {
                return fVar;
            }
        }
        return null;
    }

    static f vC(String str) {
        Iterator it = ani().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.gtP.equals(str)) {
                return fVar;
            }
        }
        Assert.assertTrue(true);
        return null;
    }

    static f a(a aVar) {
        Iterator it = ani().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (aVar.a(fVar)) {
                return fVar;
            }
        }
        return null;
    }

    static f bK(String str, String str2) {
        Iterator it = ani().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.gtS.keySet().contains(str) && fVar.gtP.equals(str2)) {
                return fVar;
            }
        }
        return null;
    }

    public static boolean vD(String str) {
        f vB = vB(str);
        if (!(vB == null || vB.vE(str) == null)) {
            AppBrandRemoteTaskController vE = vB.vE(str);
            vE.gts = a.gtF;
            if (vE.ahH()) {
                return true;
            }
        }
        return false;
    }

    private static LinkedList<f> ani() {
        LinkedList<f> linkedList;
        synchronized (gtL) {
            linkedList = new LinkedList(gtL);
        }
        return linkedList;
    }

    static void vu(String str) {
        f vB = vB(str);
        if (vB != null) {
            vB.vu(str);
            if (!vB.gtS.keySet().isEmpty()) {
                return;
            }
            if (vB instanceof a) {
                synchronized (gtL) {
                    gtL.remove(vB);
                }
                return;
            }
            synchronized (gtL) {
                gtL.remove(vB);
                gtL.addFirst(vB);
            }
            synchronized (gtK) {
                if (gtK.contains(vB)) {
                    gtK.remove(vB);
                    gtK.addFirst(vB);
                }
            }
        }
    }

    static void b(f fVar) {
        synchronized (gtL) {
            gtL.remove(fVar);
            gtL.addLast(fVar);
        }
        synchronized (gtK) {
            if (gtK.contains(fVar)) {
                gtK.remove(fVar);
                gtK.addLast(fVar);
            }
        }
    }
}
