package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.i;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.36;
import com.tencent.mm.protocal.c.aae;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.anh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class g$36$1 implements e {
    final /* synthetic */ i qjm;
    final /* synthetic */ 36 qjn;

    g$36$1(36 36, i iVar) {
        this.qjn = 36;
        this.qjm = iVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            aae aae = (aae) this.qjm.dZf.dIE.dIL;
            if (aae.iwS == 0) {
                List<anf> list = aae.rFI;
                StringBuilder stringBuilder = new StringBuilder();
                for (anf anf : list) {
                    List list2;
                    String str2 = anf.fMk + "," + anf.major;
                    if (g.p(this.qjn.qiK).containsKey(str2)) {
                        list2 = (List) g.p(this.qjn.qiK).get(str2);
                    } else {
                        list2 = new ArrayList();
                        g.p(this.qjn.qiK).put(str2, list2);
                    }
                    list2.add(anf);
                    stringBuilder.append("{uuid:" + anf.fMk + ",major:" + anf.major + ",minors:[");
                    Iterator it = anf.rPU.iterator();
                    while (it.hasNext()) {
                        anh anh = (anh) it.next();
                        stringBuilder.append(anh.rPV + "-" + anh.rPW + ",");
                    }
                    stringBuilder.append("]},");
                }
                x.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check callback]" + stringBuilder.toString());
            }
        }
        au.DF().b(1704, this);
        g.a(this.qjn.qiK, false);
    }
}
