package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.5;
import com.tencent.mm.plugin.backup.bakoldlogic.c.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.Iterator;

class f$5$1 implements Runnable {
    final /* synthetic */ 5 ham;

    f$5$1(5 5) {
        this.ham = 5;
    }

    public final void run() {
        x.i("MicroMsg.RecoverPCServer", "readFromSdcard end");
        x.chR();
        a.asN().asO().gZV = 7;
        this.ham.haj.hae = 0;
        if (this.ham.haj.gZC != null) {
            this.ham.haj.gZC.aqO();
        } else {
            x.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
        }
        e.asZ();
        new b(8).ass();
        x.i("MicroMsg.RecoverPCServer", "recover ok");
        au.HU();
        c.DT().a(a.sVe, Boolean.valueOf(true));
        c asP = a.asN().asP();
        asP.gZy++;
        a.asN().asO().gZU = 7;
        this.ham.haj.cancel();
        com.tencent.mm.plugin.backup.bakoldlogic.d.a atn = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl().atn();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = atn.gYz.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.backup.bakoldlogic.d.a.a aVar = (com.tencent.mm.plugin.backup.bakoldlogic.d.a.a) it.next();
            if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
            } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
            }
        }
        x.d("MicroMsg.BakOldRecoverDelayData", "dump delay " + stringBuffer.toString());
    }
}
