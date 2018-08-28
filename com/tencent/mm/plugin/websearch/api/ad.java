package com.tencent.mm.plugin.websearch.api;

import android.net.Uri;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ad {
    private static a pMq = new a();

    public static class a {
        long lrE;
        long ltv;
        boolean mGh = true;
        int pLn;
        long pMr;
        long pMs;
        int scene;
    }

    public static void aQ(int i, String str) {
        f.mDy.k(i, str);
    }

    public static void a(int i, String str, boolean z, boolean z2, int i2) {
        int i3;
        if (z) {
            i3 = 3;
        } else if (z2) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        f.mDy.h(12042, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i2), bi.aG(str, "").replace(",", " ")});
    }

    public static void Ab(int i) {
        pMq.scene = i;
        pMq.pLn = 1;
        pMq.pMr = System.currentTimeMillis();
        pMq.pMs = 0;
        pMq.ltv = System.currentTimeMillis();
        pMq.lrE = 0;
        pMq.mGh = false;
        x.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(1)});
    }

    public static void bTj() {
        pMq.pMr = System.currentTimeMillis();
        x.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", new Object[]{Long.valueOf(pMq.pMr)});
    }

    public static void bTk() {
        a aVar = pMq;
        aVar.pMs += System.currentTimeMillis() - pMq.pMr;
        x.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", new Object[]{Long.valueOf(pMq.pMs)});
    }

    public static void bTl() {
        a aVar = pMq;
        aVar.lrE += System.currentTimeMillis() - pMq.ltv;
        x.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", new Object[]{Long.valueOf(pMq.lrE)});
    }

    public static void bTm() {
        a aVar = pMq;
        if (!aVar.mGh) {
            f.mDy.h(12044, new Object[]{Integer.valueOf(aVar.scene), Integer.valueOf(aVar.pLn), Long.valueOf(aVar.pMs / 1000), Long.valueOf(aVar.lrE / 1000)});
            aVar.mGh = true;
        }
        x.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
    }

    public static void Ac(int i) {
        x.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", new Object[]{Integer.valueOf(i)});
        f.mDy.h(12041, new Object[]{Integer.valueOf(i), Integer.valueOf(p.zP(0))});
    }

    public static void a(int i, int i2, String str, int i3, int i4, String str2, int i5) {
        x.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5)});
        f.mDy.h(12098, new Object[]{Integer.valueOf(i), Integer.valueOf(p.zP(0)), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5)});
    }

    public static void h(String str, int i, int i2, int i3) {
        f.mDy.h(12639, new Object[]{bi.aG(str, "").replace(",", " "), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3)});
    }

    public static void q(int i, int i2, String str) {
        c(i, i2, str, false);
    }

    public static void c(int i, int i2, String str, boolean z) {
        int i3 = 1;
        f fVar = f.mDy;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(0);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        if (!z) {
            i3 = 0;
        }
        objArr[4] = Integer.valueOf(i3);
        fVar.h(12845, objArr);
    }

    public static void aR(int i, String str) {
        f.mDy.h(12070, new Object[]{Integer.valueOf(i), Integer.valueOf(p.zP(0)), str, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0)});
    }

    public static void v(int i, String str, String str2) {
        f.mDy.h(13809, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(0)});
    }

    public static void h(String str, String str2, int i, String str3) {
        x.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchLocalPageClick %s %s %d %s", new Object[]{str, str2, Integer.valueOf(i), str3});
        f.mDy.h(14657, new Object[]{Uri.encode(str), str2, Integer.valueOf(i), str3, Integer.valueOf(3)});
    }

    public static void a(String str, String str2, long j, String str3) {
        x.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchLocalPageExposure:");
        f.mDy.h(14663, new Object[]{Uri.encode(str), str2, Long.valueOf(j), str3, Integer.valueOf(3)});
    }

    public static void b(int i, String str, String str2, int i2, int i3) {
        f.mDy.h(13810, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0)});
    }

    public static final void Qa(String str) {
        x.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportWebSuggestClick %s", new Object[]{str});
        f.mDy.k(12721, str);
    }

    public static final void Ad(int i) {
        x.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", new Object[]{Integer.valueOf(i)});
        f.mDy.a(649, (long) i, 1, true);
    }

    public static final void reportIdKey649ForLook(int i, int i2) {
        if (i == 21) {
            f.mDy.a(649, (long) i2, 1, true);
        }
    }

    public static void ef(int i, int i2) {
        r(i, i2, "");
    }

    public static void r(int i, int i2, String str) {
        a(i, i2, 0, 0, str);
    }

    public static void aa(int i, int i2, int i3) {
        a(i, 3, i2, i3, "");
    }

    public static void a(int i, int i2, int i3, int i4, String str) {
        int zP;
        if (i == 21) {
            zP = p.zP(1);
        } else {
            zP = p.zP(0);
        }
        f.mDy.h(14457, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(zP), Integer.valueOf(i3), Integer.valueOf(i4), str});
    }

    public static void ai(String str, String str2, String str3) {
        f.mDy.h(14752, new Object[]{Integer.valueOf(1), str, str2, str3});
    }

    public static void aS(int i, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("recnondocreport=1");
        stringBuffer.append("&type=");
        stringBuffer.append(i);
        stringBuffer.append("&content=");
        stringBuffer.append(str);
        x.i("MicroMsg.TopStory", "reportTopStoryRedDot 14791 %s", new Object[]{stringBuffer.toString()});
        bgx bgx = new bgx();
        bgx.shQ = stringBuffer.toString();
        g.DF().a(new n(bgx), 0);
    }
}
