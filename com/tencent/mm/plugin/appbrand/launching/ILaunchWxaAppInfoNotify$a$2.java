package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.b.b.a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;

class ILaunchWxaAppInfoNotify$a$2 implements a {
    final /* synthetic */ MMToClientEvent.a gfK;

    public ILaunchWxaAppInfoNotify$a$2(MMToClientEvent.a aVar) {
        this.gfK = aVar;
    }

    public final void a(com.tencent.mm.plugin.appbrand.b.a aVar) {
        if (aVar == com.tencent.mm.plugin.appbrand.b.a.fjh) {
            MMToClientEvent.b(this.gfK);
        }
    }
}
