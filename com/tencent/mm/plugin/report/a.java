package com.tencent.mm.plugin.report;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a {
    private static boolean mDt = false;
    private StringBuffer mDu = new StringBuffer();

    public abstract int getId();

    public abstract String wE();

    public abstract String wF();

    public static void hr(boolean z) {
        mDt = z;
    }

    public final boolean RD() {
        int id = getId();
        String wE = wE();
        x.v("MicroMsg.AbsReportStruct", "report %d %s", new Object[]{Integer.valueOf(getId()), wE()});
        if (id <= 0 || bi.oW(wE)) {
            return false;
        }
        h.mEJ.k(getId(), wE());
        if (!mDt) {
            return true;
        }
        j brV = j.brV();
        wE = wE();
        String wF = wF();
        String str = "\r\n\r\n error:\r\n" + this.mDu.toString();
        if (!brV.mDt || brV.mFc == null) {
            return true;
        }
        x.v("MicroMsg.SubCoreReport", "put kv info [%s %s %s]", new Object[]{wE, wF, str});
        brV.mFc.put(ac.ce(wE), wF + str);
        return true;
    }

    public final void eo(String str, String str2) {
        x.w("MicroMsg.AbsReportStruct", "error report [%d] msg[%s %s]", new Object[]{Integer.valueOf(getId()), str, str2});
        this.mDu.append(str).append(":").append(str2).append("\r\n");
    }

    public final boolean ae(String str, long j) {
        if (j > 151473600) {
            return true;
        }
        eo(str, String.valueOf(j));
        return false;
    }

    public final boolean KD(String str) {
        if (bi.oW(str)) {
            eo("", "check rpt value is null.");
            return false;
        } else if (str.length() < 7168) {
            return true;
        } else {
            eo("", "check rpt value more than 7k.");
            return false;
        }
    }
}
