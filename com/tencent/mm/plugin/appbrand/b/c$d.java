package com.tencent.mm.plugin.appbrand.b;

import android.os.Message;

final class c$d extends g {
    final /* synthetic */ c fjx;

    c$d(c cVar, h hVar) {
        this.fjx = cVar;
        super(hVar);
    }

    public final String getName() {
        return this.fjx.mName + "|Foreground";
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 1:
                c.a(this.fjx, this.fjx.fjp);
                return true;
            default:
                return super.j(message);
        }
    }

    public final void enter() {
        super.enter();
    }

    public final void exit() {
        super.exit();
    }
}
