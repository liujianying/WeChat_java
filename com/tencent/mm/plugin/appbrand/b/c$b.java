package com.tencent.mm.plugin.appbrand.b;

import android.os.Message;

final class c$b extends g {
    final /* synthetic */ c fjx;

    c$b(c cVar, h hVar) {
        this.fjx = cVar;
        super(hVar);
    }

    public final String getName() {
        return this.fjx.mName + "|BackgroundKeepNoChange";
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 3:
                c.a(this.fjx, this.fjx.fjo);
                return true;
            default:
                return super.j(message);
        }
    }
}
