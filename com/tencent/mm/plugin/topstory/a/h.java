package com.tencent.mm.plugin.topstory.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.protocal.c.cfn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class h {
    public static void a(bth bth, bti bti, String str, String str2, String str3) {
        com.tencent.mm.plugin.report.service.h.mEJ.h(15035, new Object[]{Integer.valueOf(bth.scene), bth.fuu, bti.sqZ, bti.sqS, Integer.valueOf(0), str2, str3, Long.valueOf(bth.sqL), str});
    }

    public static void a(bte bte, String str, long j) {
        int zP = p.zP(1);
        x.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", new Object[]{String.format("%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(bte.scene), bte.sqA, bte.bJK, Integer.valueOf(zP), str, Long.valueOf(j), Integer.valueOf(bte.ozm), Integer.valueOf(bte.sqC)})});
        com.tencent.mm.plugin.report.service.h.mEJ.k(15466, r0);
    }

    public static void a(cfn cfn, bd bdVar) {
        String GF;
        String str;
        int i;
        if (s.fq(bdVar.field_talker)) {
            if (bdVar.field_isSend == 1) {
                GF = q.GF();
            } else {
                GF = com.tencent.mm.model.bd.iB(bdVar.field_content);
            }
            str = bdVar.field_talker;
            i = 2;
        } else {
            String str2;
            if (bdVar.field_isSend == 1) {
                GF = q.GF();
                str2 = bdVar.field_talker;
            } else {
                GF = bdVar.field_talker;
                str2 = q.GF();
            }
            i = 1;
            str = str2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("isShareClick=1");
        stringBuffer.append("&relevant_vid=");
        stringBuffer.append(cfn.pLr);
        stringBuffer.append("&relevant_pre_searchid=");
        stringBuffer.append(cfn.pLt);
        stringBuffer.append("&relevant_shared_openid=");
        stringBuffer.append(cfn.pLu);
        stringBuffer.append("&rec_category=");
        stringBuffer.append(cfn.pLv);
        stringBuffer.append("&source=");
        stringBuffer.append(cfn.bhd);
        stringBuffer.append("&fromUser=");
        stringBuffer.append(GF);
        stringBuffer.append("&fromScene=");
        stringBuffer.append(i);
        stringBuffer.append("&targetInfo=");
        stringBuffer.append(str);
        x.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[]{stringBuffer.toString()});
        bgx bgx = new bgx();
        bgx.shQ = stringBuffer.toString();
        g.DF().a(new n(bgx), 0);
    }
}
