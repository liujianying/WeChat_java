package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.model.am;
import com.tencent.mm.plugin.backup.bakoldlogic.d.a.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class a$2 implements Runnable {
    final /* synthetic */ a haW;

    a$2(a aVar) {
        this.haW = aVar;
    }

    public final void run() {
        Iterator it = this.haW.gYz.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                String str = (String) aVar.obj;
                x.d("MicroMsg.BakOldRecoverDelayData", "getContact:" + str);
                am.a.dBr.R(str, "");
            } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                ao.bme().SU((String) aVar.obj);
            }
        }
        this.haW.gYz.clear();
    }
}
