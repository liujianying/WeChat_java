package com.tencent.mm.model.a;

import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    private static void iR(String str) {
        x.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", new Object[]{str});
        if (g.IW().IU()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
            intent.putExtra("content", str);
            ad.getContext().sendBroadcast(intent, "com.tencent.mm.permission.MM_MESSAGE");
            return;
        }
        x.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
    }

    private static void a(e eVar, boolean z) {
        if (eVar == null || !g.IW().IU()) {
            x.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(z ? stringBuilder.append("TestPointStart:") : stringBuilder.append("TestPointEnd:"));
        stringBuilder.append(g.IW().dDN.dDJ);
        stringBuilder.append("_");
        stringBuilder.append(eVar.id);
        stringBuilder.append("_");
        stringBuilder.append(eVar.dDP);
        stringBuilder.append("_");
        stringBuilder.append(eVar.dDP);
        stringBuilder.append("_");
        stringBuilder.append(eVar.dDQ);
        stringBuilder.append("_");
        stringBuilder.append(eVar.result);
        stringBuilder.append("_");
        stringBuilder.append(eVar.dDS);
        iR(stringBuilder.toString());
    }

    public static void a(e eVar) {
        if (eVar != null && g.IW().IU()) {
            String str = g.IW().dDN.dDJ;
            String str2 = eVar.id;
            String str3 = eVar.id;
            String str4 = (eVar.endTime - eVar.startTime);
            String str5 = eVar.result;
            String str6 = eVar.dDP;
            long j = eVar.dDS;
            x.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", new Object[]{str, str2, str6, str3, str4, str5, Long.valueOf(j)});
            h.mEJ.h(11394, new Object[]{str, str2, str6, str3, str4, str5, Long.valueOf(j)});
        }
    }

    public static void iS(String str) {
        x.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
        iR("TestCaseID:" + str);
    }

    public static void iT(String str) {
        if (g.IW().iP(str) != null) {
            x.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", new Object[]{str});
            g.IW().iP(str).dDQ = System.currentTimeMillis();
            g.IW().iP(str).startTime = System.currentTimeMillis();
            g.IW().iP(str).dDR = false;
            g.IW().iP(str).result = "0";
            a(g.IW().iP(str), true);
        }
    }

    public static void iU(String str) {
        if (g.IW().iP(str) != null && !g.IW().iP(str).dDR) {
            x.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", new Object[]{str});
            g.IW().iP(str).dDQ = System.currentTimeMillis();
            g.IW().iP(str).endTime = System.currentTimeMillis();
            g.IW().iP(str).dDR = true;
            a(g.IW().iP(str));
            a(g.IW().iP(str), false);
        }
    }
}
