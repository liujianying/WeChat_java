package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.ub;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class v$1 implements Runnable {
    final /* synthetic */ String fhM;
    final /* synthetic */ v jNx;

    public v$1(v vVar, String str) {
        this.jNx = vVar;
        this.fhM = str;
    }

    public final void run() {
        if (bi.oW(this.fhM)) {
            x.e("MicroMsg.GameMessageService", "msg content is null");
            return;
        }
        Map z = bl.z(this.fhM, "sysmsg");
        if (z == null || z.size() == 0) {
            x.e("MicroMsg.GameMessageService", "Parse failed");
            return;
        }
        String aG = bi.aG((String) z.get(".sysmsg.wepkg.$pkg_id"), "");
        x.i("MicroMsg.GameMessageService", "MicroMsg.Wepkg message pkgid:%s, downloadTriggerType:%d", new Object[]{aG, Integer.valueOf(bi.getInt((String) z.get(".sysmsg.wepkg.download_trigger_type"), 0))});
        if (!bi.oW(aG)) {
            ub ubVar = new ub();
            ubVar.cfW.bIH = 1;
            ubVar.cfW.cfX = aG;
            ubVar.cfW.cga = r0;
            a.sFg.m(ubVar);
            h.mEJ.a(858, 15, 1, false);
        }
    }
}
