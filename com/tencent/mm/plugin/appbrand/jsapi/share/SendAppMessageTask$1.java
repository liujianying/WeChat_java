package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.cgn;
import com.tencent.mm.protocal.c.cgv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class SendAppMessageTask$1 implements a {
    final /* synthetic */ int eeg;
    final /* synthetic */ LinkedList fZf;
    final /* synthetic */ g.a fZg;
    final /* synthetic */ byte[] fZh;
    final /* synthetic */ StringBuilder fZi;
    final /* synthetic */ SendAppMessageTask fZj;

    SendAppMessageTask$1(SendAppMessageTask sendAppMessageTask, LinkedList linkedList, g.a aVar, byte[] bArr, StringBuilder stringBuilder, int i) {
        this.fZj = sendAppMessageTask;
        this.fZf = linkedList;
        this.fZg = aVar;
        this.fZh = bArr;
        this.fZi = stringBuilder;
        this.eeg = i;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        cgn cgn = (cgn) bVar.dIE.dIL;
        if (i != 0 || i2 != 0 || cgn == null || bi.cX(cgn.sAL)) {
            if (this.fZg.dyU == 3) {
                this.fZg.dyU = 2;
            }
            Iterator it = this.fZf.iterator();
            while (it.hasNext()) {
                SendAppMessageTask.a(this.fZj, this.fZg, this.fZh, (String) it.next(), this.fZi, this.eeg);
            }
        } else {
            LinkedList linkedList = cgn.sAL;
            this.fZj.fZe = new ArrayList();
            for (int i3 = 0; i3 < this.fZf.size(); i3++) {
                cgv cgv;
                if (i3 < linkedList.size()) {
                    cgv = (cgv) linkedList.get(i3);
                } else {
                    cgv = new cgv();
                }
                this.fZg.dyY = cgv.slo;
                this.fZj.fZe.add(new ShareInfo(cgv.slo, cgv.sAZ));
                if (cgv.sAJ && cgv.sBa != null) {
                    com.tencent.mm.y.a aVar = (com.tencent.mm.y.a) this.fZg.u(com.tencent.mm.y.a.class);
                    aVar.dvG = cgv.sBa.content;
                    aVar.dvH = cgv.sBa.slj;
                    aVar.dvI = cgv.sBa.slk;
                    aVar.dvJ = cgv.sBa.sll;
                    aVar.dvK = cgv.sBa.slm;
                    aVar.dvM = cgv.sBa.state;
                    aVar.dvL = cgv.sBa.sln;
                }
                SendAppMessageTask.a(this.fZj, this.fZg, this.fZh, (String) this.fZf.get(i3), this.fZi, this.eeg);
            }
        }
        SendAppMessageTask.a(this.fZj);
        return 0;
    }
}
