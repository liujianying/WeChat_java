package com.tencent.mm.modelvideo;

import com.tencent.mm.g.a.jk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.n.2;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class n$3 extends c<jk> {
    final /* synthetic */ n ene;

    n$3(n nVar) {
        this.ene = nVar;
        this.sFo = jk.class.getName().hashCode();
    }

    private boolean a(jk jkVar) {
        x.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
        if (jkVar == null) {
            return false;
        }
        String str;
        String str2 = jkVar.bSR.path;
        try {
            if (str2.endsWith(".tmp")) {
                str2 = str2.substring(0, str2.lastIndexOf(".tmp"));
                x.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", new Object[]{str2, jkVar.bSR.path});
            }
            str = str2;
        } catch (Exception e) {
            str = str2;
        }
        n nVar = this.ene;
        String str3 = jkVar.bSR.bSS;
        String str4 = jkVar.bSR.bST;
        int i = jkVar.bSR.bSU;
        String str5 = jkVar.bSR.fileId;
        String str6 = jkVar.bSR.bSW;
        long j = jkVar.bSR.startTime;
        long j2 = jkVar.bSR.endTime;
        g.Em().H(new 2(nVar, str, jkVar.bSR.bSV, str3, str4, i, str5, str6, j, j2, jkVar.bSR.bSX, jkVar.bSR.bSY, jkVar.bSR.bSZ));
        return false;
    }
}
