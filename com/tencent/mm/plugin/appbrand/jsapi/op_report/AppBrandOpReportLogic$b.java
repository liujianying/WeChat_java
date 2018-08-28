package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.util.SparseIntArray;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.ReportTask;
import com.tencent.mm.protocal.c.asi;
import com.tencent.mm.protocal.c.bhb;
import com.tencent.mm.protocal.c.bhc;
import com.tencent.mm.sdk.platformtools.bi;

public final class AppBrandOpReportLogic$b {
    private static final SparseIntArray fWE = new SparseIntArray();

    public static int tW(String str) {
        int i = 0;
        if (!bi.oW(str)) {
            synchronized (fWE) {
                i = fWE.get(str.hashCode(), 0);
            }
        }
        return i;
    }

    static void aE(String str, int i) {
        if (!bi.oW(str)) {
            synchronized (fWE) {
                fWE.put(str.hashCode(), i);
            }
        }
    }

    static void a(ReportTask reportTask) {
        if (reportTask != null) {
            a aVar = new a();
            aVar.dIF = 1345;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose";
            aVar.dIH = new bhc();
            String str = reportTask.appId;
            bhb bhb = new bhb();
            bhb.shV = new asi();
            bhb.shV.bPS = str;
            bhb.shV.username = reportTask.username;
            bhb.shV.rRb = reportTask.fmv;
            bhb.shV.riv = reportTask.cbu;
            bhb.shV.otY = reportTask.scene;
            bhb.shV.rUA = reportTask.cbB;
            bhb.shV.rUB = 1;
            bhb.shV.rUC = reportTask.bGH;
            bhb.shV.rUD = reportTask.fKP;
            bhb.rDK = reportTask.fWF;
            aVar.dIG = bhb;
            v.a(aVar.KT(), new 1(str), true);
        }
    }
}
