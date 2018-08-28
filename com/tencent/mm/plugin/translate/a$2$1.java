package com.tencent.mm.plugin.translate;

import com.tencent.mm.g.a.rt;
import com.tencent.mm.plugin.translate.a.2;
import com.tencent.mm.plugin.translate.a.c;
import com.tencent.mm.plugin.translate.a.c$c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class a$2$1 implements Runnable {
    final /* synthetic */ rt oEo;
    final /* synthetic */ 2 oEp;

    a$2$1(2 2, rt rtVar) {
        this.oEp = 2;
        this.oEo = rtVar;
    }

    public final void run() {
        c cVar = this.oEp.oEl.oEg;
        String str = this.oEo.ccE.ccF;
        String str2 = this.oEo.ccE.id;
        int i = this.oEo.ccE.type;
        String str3 = this.oEo.ccE.bhd;
        boolean z = this.oEo.ccE.ccG;
        byte[] bArr = this.oEo.ccE.ccH;
        x.d("MicroMsg.TranslateServiceManager", "doTranslate msgId : %s, type: %d", new Object[]{str2, Integer.valueOf(i)});
        if (cVar.OB(str2)) {
            x.d("MicroMsg.TranslateServiceManager", "doTranslate msgId %s is inQueue", new Object[]{str2});
            return;
        }
        c$c c_c = new c$c(str, str2, i, str3, bArr);
        if (z) {
            ((LinkedList) cVar.oEs).add(0, c_c);
        } else {
            cVar.oEs.add(c_c);
        }
        cVar.oEt.put(c_c.id, Integer.valueOf(c_c.oEw));
        x.d("MicroMsg.TranslateServiceManager", "requestCount : %s", new Object[]{Integer.valueOf(cVar.htY)});
        cVar.bIR();
    }
}
