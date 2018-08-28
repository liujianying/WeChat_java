package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.t$a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class e$41 extends t$a {
    final /* synthetic */ e iup;

    e$41(e eVar) {
        this.iup = eVar;
    }

    public final void b(long j, int i, int i2, String str) {
        String str2 = "MicroMsg.exdevice.ExdeviceEventManager";
        String str3 = "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s";
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        if (str == null) {
            str = "null";
        }
        objArr[3] = str;
        x.d(str2, str3, objArr);
        e eVar = this.iup;
        String cY = b.cY(j);
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", new Object[]{cY, Boolean.valueOf(i2 == 0)});
        if (!(i2 == 0)) {
            List<e.b> linkedList;
            synchronized (eVar.itw) {
                linkedList = new LinkedList(eVar.itw);
            }
            for (e.b b : linkedList) {
                b.b(cY, null, false);
            }
            linkedList.clear();
            for (e.b b2 : eVar.itx.values()) {
                b2.b(cY, null, false);
            }
        }
    }
}
