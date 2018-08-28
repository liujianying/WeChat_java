package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.plugin.webview.modeltools.e.15;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class e$15$1 implements Runnable {
    final /* synthetic */ String fhM;
    final /* synthetic */ h pUm;
    final /* synthetic */ 15 pUn;

    e$15$1(15 15, String str, h hVar) {
        this.pUn = 15;
        this.fhM = str;
        this.pUm = hVar;
    }

    public final void run() {
        x.d("MicroMsg.SubCoreTools", "webview hijack sysMsgListener");
        Map z = bl.z(this.fhM, "sysmsg");
        long j = bi.getLong((String) z.get(".sysmsg.hijackconfig.expiretime"), Long.MAX_VALUE);
        String str = ".sysmsg.hijackconfig.domainlist.domain";
        String str2 = str;
        int i = 0;
        while (true) {
            String str3;
            if (i > 0) {
                str3 = str + i;
            } else {
                str3 = str2;
            }
            i++;
            str2 = (String) z.get(str3);
            if (!bi.oW(str2)) {
                g gVar = new g();
                gVar.field_expireTime = j;
                gVar.field_host = str2;
                this.pUm.b(gVar);
                str2 = str3;
            } else {
                return;
            }
        }
    }
}
