package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Deprecated
public enum AppBrandStickyBannerLogic {
    ;

    public static final class a {
        private static final Watcher gya = null;
        private static final Set<f> gyb = null;
        private static final HashMap<String, Boolean> gyc = null;
        private static final HashMap<String, f> gyd = null;
        private static final c gye = null;
        private static final Map<String, String> gyf = null;

        static {
            gya = new Watcher();
            gyb = new HashSet();
            gyc = new HashMap();
            gyd = new HashMap();
            gye = new c();
            gyf = new HashMap();
        }

        static void aP(String str, int i) {
            synchronized (gyb) {
                for (f an : gyb) {
                    an.an(str, i);
                }
            }
        }

        public static void a(Context context, String str, int i, String str2, String str3) {
            if (!bi.oW(str)) {
                Context context2;
                String str4;
                if (context == null) {
                    context2 = ad.getContext();
                } else {
                    context2 = context;
                }
                Intent addFlags = new Intent().setClassName(context2, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
                synchronized (gyf) {
                    str4 = (String) gyf.get(str);
                }
                b.a(addFlags, str, i, str2, str3, bi.oV(str4));
                context2.startActivity(addFlags);
                if (context2 instanceof Activity) {
                    try {
                        ((Activity) context2).moveTaskToBack(false);
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrandStickyBannerLogic.ClientLogic", "stickOnChatting e = %s", new Object[]{e.getMessage()});
                    }
                }
            }
        }

        public static boolean anT() {
            AppBrandStickyBannerLogic.access$200();
            return false;
        }

        public static void c(f fVar) {
            if (fVar != null) {
                synchronized (gyb) {
                    gyb.remove(fVar);
                }
            }
        }

        public static void d(f fVar) {
            gya.gyj = ad.getProcessName();
            AppBrandMainProcessService.a(gya);
            if (fVar != null) {
                synchronized (gyb) {
                    gyb.add(fVar);
                }
            }
        }

        public static void ac(String str, boolean z) {
            gyc.put(str, Boolean.valueOf(z));
            1 1 = new 1(str);
            d(1);
            gyd.put(str, 1);
        }

        public static void vK(String str) {
            gyc.remove(str);
            x.i("MicroMsg.AppBrandStickyBannerLogic", "release(%s)", new Object[]{str});
        }

        public static void bO(String str, String str2) {
            if (!bi.oW(str)) {
                synchronized (gyf) {
                    gyf.put(str, bi.oV(str2));
                }
                AppBrandSysConfig qa = com.tencent.mm.plugin.appbrand.a.qa(str);
                if (qa != null) {
                    AppBrandMainProcessService.a(OperateTask.q(str, qa.frm.fih, str2));
                }
            }
        }
    }
}
