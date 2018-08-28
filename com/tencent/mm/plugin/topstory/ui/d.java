package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.protocal.c.btg;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class d {
    public static void N(Context context, int i) {
        String str = "";
        if (((b) g.n(b.class)).getRedDotMgr().bHt()) {
            str = ((b) g.n(b.class)).getRedDotMgr().bHw().bWQ;
            ((b) g.n(b.class)).getRedDotMgr().bHu();
            x.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d red dot %s", new Object[]{Integer.valueOf(i), Integer.valueOf(p.zW(1)), str});
        } else {
            x.i("MicroMsg.TopStory.TopStoryUILogic", "click top story scene %d version %d ", new Object[]{Integer.valueOf(i), Integer.valueOf(p.zW(1))});
        }
        if (!bi.oW(str) && bHE()) {
            rq rqVar = new rq();
            rqVar.ccx.actionType = 2;
            a.sFg.m(rqVar);
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String string = context.getString(b$g.fts_recommend_search_keyword);
        bte bte = new bte();
        bte.sqA = bHF();
        bte.scene = i;
        bte.fuu = "";
        bte.bHt = string;
        bte.ozm = ((PluginTopStoryUI) g.n(PluginTopStoryUI.class)).getFirstLoadWebView();
        String zK = p.zK(i);
        bte.bJK = zK;
        bte.bWr = zK;
        bte.sqD = string;
        HashMap hashMap = new HashMap();
        if (!bi.oW(str)) {
            hashMap.put("redPointMsgId", str);
        }
        if (!bi.oW(zK)) {
            hashMap.put("sessionId", zK);
        }
        if (!bi.oW(string)) {
            hashMap.put("query", string);
        }
        if (!bi.oW(valueOf)) {
            hashMap.put("requestId", valueOf);
            hashMap.put("pRequestId", valueOf);
            hashMap.put("seq", valueOf);
        }
        hashMap.put("scene", String.valueOf(i));
        bte.url = com.tencent.mm.plugin.topstory.a.g.n(hashMap);
        bte.sqC = 1;
        c(bte.pKZ, str, valueOf);
        b(bte, "clickTopStory", System.currentTimeMillis());
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", bte.toByteArray());
        } catch (IOException e) {
        }
        intent.addFlags(268435456);
        p.c(context, ".ui.home.TopStoryHomeUI", intent);
        if (!bHE()) {
            ah.A(new 1(bte));
        }
        ((PluginTopStoryUI) g.n(PluginTopStoryUI.class)).setFirstLoadWebView(1);
        g.Ei().DT().a(aa.a.tad, Long.valueOf(System.currentTimeMillis()));
        ((c) g.l(c.class)).ch(com.tencent.mm.plugin.boots.a.b.hjx, 884);
    }

    public static void a(Context context, bte bte, String str) {
        c(bte.pKZ, "", str);
        b(bte, "clickTopStory", System.currentTimeMillis());
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", bte.toByteArray());
        } catch (IOException e) {
        }
        p.c(context, ".ui.home.TopStoryTabHomeUI", intent);
        ah.A(new 2(bte));
    }

    public static final String ak(String str, long j) {
        return str + "_" + j;
    }

    private static void c(List<ps> list, String str, String str2) {
        ps psVar = new ps();
        psVar.aAL = "redPointMsgId";
        psVar.rtV = String.valueOf(str);
        list.add(psVar);
        psVar = new ps();
        psVar.aAL = "currentPage";
        psVar.rtU = 1;
        list.add(psVar);
        psVar = new ps();
        psVar.aAL = "is_prefetch";
        psVar.rtU = 0;
        list.add(psVar);
        psVar = new ps();
        psVar.aAL = "seq";
        psVar.rtV = str2;
        list.add(psVar);
        psVar = new ps();
        psVar.aAL = "requestId";
        psVar.rtV = str2;
        list.add(psVar);
        psVar = new ps();
        psVar.aAL = "recType";
        psVar.rtU = 0;
        list.add(psVar);
    }

    private static boolean bHE() {
        rq rqVar = new rq();
        rqVar.ccx.actionType = 1;
        a.sFg.m(rqVar);
        return rqVar.ccy.ccz;
    }

    public static final String bHF() {
        rq rqVar = new rq();
        rqVar.ccx.actionType = 3;
        a.sFg.m(rqVar);
        String str = "";
        if (rqVar.ccy.ccA != null) {
            str = rqVar.ccy.ccA.sqA;
        }
        if (bi.oW(str)) {
            return UUID.randomUUID().toString();
        }
        return str;
    }

    private static void b(bte bte, String str, long j) {
        h.a(bte, str, j);
        if (bte.sqB.size() == 0) {
            btg btg = new btg();
            btg.name = str;
            btg.timestamp = j;
            bte.sqB.add(btg);
        }
    }

    public static final void c(bte bte, String str, long j) {
        h.a(bte, str, j);
        if (bte.sqB.size() > 0) {
            btg btg = new btg();
            btg.name = str;
            btg.timestamp = j;
            bte.sqB.add(btg);
        }
    }
}
