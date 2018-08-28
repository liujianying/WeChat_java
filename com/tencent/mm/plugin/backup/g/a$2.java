package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.model.am.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class a$2 implements Runnable {
    final /* synthetic */ a gYB;

    public a$2(a aVar) {
        this.gYB = aVar;
    }

    public final void run() {
        Iterator it = this.gYB.gYz.iterator();
        while (it.hasNext()) {
            a$a a_a = (a$a) it.next();
            if (a_a.type == 2 && a_a.obj != null && (a_a.obj instanceof String)) {
                String str = (String) a_a.obj;
                x.d("MicroMsg.BackupRecoverDelayData", "getContact:" + str);
                a.dBr.R(str, "");
            } else if (a_a.type == 1 && a_a.obj != null && (a_a.obj instanceof String)) {
                ao.bme().SU((String) a_a.obj);
            }
        }
        this.gYB.gYz.clear();
    }
}
