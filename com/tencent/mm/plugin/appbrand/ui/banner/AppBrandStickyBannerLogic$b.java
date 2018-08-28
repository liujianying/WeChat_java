package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.OperateTask;
import java.util.HashSet;
import java.util.Set;

public final class AppBrandStickyBannerLogic$b {
    static final Set<f> dba = new HashSet();

    public static void z(Intent intent) {
        if (intent != null && g.Eg().Dx()) {
            g.Em().H(new 1(intent));
        }
    }

    static void b(OperateTask operateTask) {
        if (b.a(operateTask)) {
            anW();
        }
    }

    static void anO() {
        AppBrandStickyBannerLogic.access$200();
    }

    private static void anW() {
        BannerModel anY = BannerModel.anY();
        String str = anY == null ? null : anY.appId;
        int i = anY == null ? -1 : anY.fmv;
        synchronized (dba) {
            for (f an : dba) {
                an.an(str, i);
            }
        }
    }

    public static void d(f fVar) {
        if (fVar != null) {
            synchronized (dba) {
                dba.add(fVar);
            }
        }
    }

    public static void c(f fVar) {
        if (fVar != null) {
            synchronized (dba) {
                dba.remove(fVar);
            }
        }
    }

    public static boolean anT() {
        AppBrandStickyBannerLogic.access$200();
        return false;
    }

    public static void anX() {
        AppBrandStickyBannerLogic.access$200();
    }
}
