package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dw;
import com.tencent.mm.plugin.exdevice.model.e.39;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$23 extends c<dw> {
    final /* synthetic */ e iup;

    e$23(e eVar) {
        this.iup = eVar;
        this.sFo = dw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dw dwVar = (dw) bVar;
        e eVar = this.iup;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOpInChattingUIEvent");
        dwVar = dwVar;
        if (bi.oW(dwVar.bLH.userName)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceOpInChattingUIEventListener, userName is null");
            return false;
        }
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "This biz is binded a device, notify chatting view to dimiss connect fail tips");
        e.bj(dwVar.bLH.userName, -1);
        if ((dwVar.bLH.op != 0 && dwVar.bLH.op != 3) || !i.ivn.ex(false)) {
            return eVar.Y(dwVar.bLH.op, dwVar.bLH.userName);
        }
        i.ivn.a(dwVar.bLH.context, new 39(eVar, dwVar));
        return true;
    }
}
