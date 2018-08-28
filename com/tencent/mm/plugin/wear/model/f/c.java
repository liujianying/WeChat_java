package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.g.a.tq;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.platformtools.x;

public abstract class c extends d {
    public abstract void send();

    protected final void execute() {
        if (a.bSl().pIM.bSq()) {
            tq tqVar = new tq();
            tqVar.cfq.bIH = 11;
            com.tencent.mm.sdk.b.a.sFg.m(tqVar);
            send();
            return;
        }
        x.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
    }
}
