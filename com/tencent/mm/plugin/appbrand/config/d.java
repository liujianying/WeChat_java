package com.tencent.mm.plugin.appbrand.config;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.SparseArray;
import android.view.WindowManager;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class d {
    public static final SparseArray<d> fpr = new SparseArray();
    public d fpt;
    public d fpu;
    public boolean mFinished = false;

    public static d b(MMActivity mMActivity) {
        d dVar;
        synchronized (fpr) {
            dVar = (d) fpr.get(mMActivity.hashCode());
            if (dVar == null) {
                dVar = new d();
                fpr.put(mMActivity.hashCode(), dVar);
            }
        }
        return dVar;
    }

    private d() {
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.app.Activity r8, com.tencent.mm.plugin.appbrand.config.d.b r9, com.tencent.mm.plugin.appbrand.config.d.a r10) {
        /*
        r7 = this;
        r6 = 1;
        r5 = 0;
        r1 = cu(r8);
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r2 = "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s]";
        r3 = 3;
        r3 = new java.lang.Object[r3];
        r3[r5] = r9;
        r3[r6] = r10;
        r4 = 2;
        r3[r4] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        if (r8 != 0) goto L_0x002f;
    L_0x001b:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r2 = new java.lang.RuntimeException;
        r2.<init>();
        r3 = "No Activity found when request device orientation";
        r4 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r0, r2, r3, r4);
        a(r10, r1, r5);
    L_0x002e:
        return;
    L_0x002f:
        if (r9 != 0) goto L_0x0035;
    L_0x0031:
        a(r10, r1, r5);
        goto L_0x002e;
    L_0x0035:
        if (r9 != r1) goto L_0x0048;
    L_0x0037:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "requestDeviceOrientation currentOrientation hit. [%s]";
        r2 = new java.lang.Object[r6];
        r2[r5] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        a(r10, r9, r6);
        goto L_0x002e;
    L_0x0048:
        r0 = 0;
        monitor-enter(r7);
        r2 = r7.mFinished;	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x005c;
    L_0x004e:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "requestDeviceOrientation mFinished = true";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x0059 }
        monitor-exit(r7);	 Catch:{ all -> 0x0059 }
        goto L_0x002e;
    L_0x0059:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0059 }
        throw r0;
    L_0x005c:
        r2 = r7.fpt;	 Catch:{ all -> 0x0059 }
        if (r2 != 0) goto L_0x0076;
    L_0x0060:
        r2 = new com.tencent.mm.plugin.appbrand.config.d$d;	 Catch:{ all -> 0x0059 }
        r3 = 0;
        r2.<init>(r7, r9, r10, r3);	 Catch:{ all -> 0x0059 }
        r7.fpt = r2;	 Catch:{ all -> 0x0059 }
        r2 = r7.fpt;	 Catch:{ all -> 0x0059 }
        a(r8, r2);	 Catch:{ all -> 0x0059 }
    L_0x006d:
        monitor-exit(r7);	 Catch:{ all -> 0x0059 }
        if (r0 == 0) goto L_0x002e;
    L_0x0070:
        r0 = r0.fpz;
        a(r0, r1, r5);
        goto L_0x002e;
    L_0x0076:
        r2 = r7.fpu;	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x007c;
    L_0x007a:
        r0 = r7.fpu;	 Catch:{ all -> 0x0059 }
    L_0x007c:
        r2 = new com.tencent.mm.plugin.appbrand.config.d$d;	 Catch:{ all -> 0x0059 }
        r3 = 0;
        r2.<init>(r7, r9, r10, r3);	 Catch:{ all -> 0x0059 }
        r7.fpu = r2;	 Catch:{ all -> 0x0059 }
        goto L_0x006d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.d.a(android.app.Activity, com.tencent.mm.plugin.appbrand.config.d$b, com.tencent.mm.plugin.appbrand.config.d$a):void");
    }

    public static void a(Activity activity, d dVar) {
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", dVar);
        activity.setRequestedOrientation(dVar.fpA.fpx);
    }

    public static b cu(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return null;
        }
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
        return b(context.getResources().getConfiguration());
    }

    private static void a(a aVar, b bVar, boolean z) {
        if (aVar != null) {
            aVar.a(bVar, z);
        }
    }

    public static b rJ(String str) {
        if ("landscape".equals(str)) {
            return b.fpw;
        }
        if ("portrait".equals(str)) {
            return b.fpv;
        }
        return null;
    }

    public static b a(AppBrandInitConfig appBrandInitConfig, a aVar) {
        b bVar = null;
        if (!(aVar == null || aVar.foR == null)) {
            x.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex]AppBrandAppConfig has deviceOrientation field [%s]", aVar.adT());
            bVar = rJ(aVar.adT());
        }
        if (bVar == null) {
            if (!appBrandInitConfig.aaq()) {
                return b.fpv;
            }
            x.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex]AppBrandInitConfig has orientation field [%s]", appBrandInitConfig.fqt);
            bVar = rJ(appBrandInitConfig.fqt);
        }
        if (bVar == null) {
            return b.fpv;
        }
        return bVar;
    }

    public static boolean p(g gVar) {
        boolean z;
        boolean z2;
        switch (((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                z = true;
                break;
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                z = false;
                break;
            default:
                z = true;
                break;
        }
        if (a(gVar.fct, gVar.fcv) == b.fpv) {
            z2 = true;
        } else {
            z2 = false;
        }
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex] isCurrentPortrait %b, isGameShouldPortrait %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z == z2) {
            return true;
        }
        return false;
    }

    public static b b(Configuration configuration) {
        if (configuration == null) {
            x.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == null ");
            return null;
        } else if (configuration.orientation == 2) {
            x.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
            return b.fpw;
        } else if (configuration.orientation == 1) {
            x.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
            return b.fpv;
        } else {
            x.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", Integer.valueOf(configuration.orientation));
            return null;
        }
    }
}
