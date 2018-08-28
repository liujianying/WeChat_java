package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.protocal.c.cgu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.h;

public final class AppBrandIDKeyBatchReport {
    private static volatile IDKeyBatchReportTask gqw;

    private static final class a {
        private static final byte[] gqx = new byte[0];

        static /* synthetic */ void b(cgu cgu) {
            synchronized (gqx) {
                AppBrandIDKeyBatchReport.amv().gqC = cgu;
                AppBrandIDKeyBatchReport.amv().gqy = 3;
                AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.amv());
            }
        }
    }

    public static IDKeyBatchReportTask amv() {
        if (gqw == null) {
            gqw = new IDKeyBatchReportTask();
        }
        return gqw;
    }

    static String amw() {
        if (g.Eg().Dx()) {
            String str = g.Ei().cachePath;
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            str = str + "appbrand/report/";
            h.Ey(str);
            return str;
        }
        throw new b();
    }

    public static void a(cgu cgu) {
        if (ad.cic()) {
            b.c(cgu);
        } else {
            a.b(cgu);
        }
    }
}
