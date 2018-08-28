package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.g.a.sc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<sc> {
    final /* synthetic */ a lHC;

    a$1(a aVar) {
        this.lHC = aVar;
        this.sFo = sc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sc scVar = (sc) bVar;
        a aVar = this.lHC;
        long j = scVar.ccT.ccU;
        x.i("MicroMsg.AbstractSendMsgFailNotification", "updateMsgIdInMsgList, oldMsgId:%d, newMsgId:%d", new Object[]{Long.valueOf(j), Long.valueOf(scVar.ccT.ccV)});
        if (aVar.lHt.ek(j)) {
            b bVar2 = aVar.lHt;
            int indexOf = bVar2.lHE.indexOf(Long.valueOf(j));
            if (indexOf != -1) {
                bVar2.lHE.set(indexOf, Long.valueOf(r4));
            }
        }
        return false;
    }
}
