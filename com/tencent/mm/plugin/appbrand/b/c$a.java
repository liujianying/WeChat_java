package com.tencent.mm.plugin.appbrand.b;

import android.os.Message;
import com.tencent.mm.plugin.appbrand.g;

final class c$a extends f {
    final /* synthetic */ c fjx;

    c$a(c cVar, h hVar, g gVar) {
        this.fjx = cVar;
        super(hVar, gVar);
    }

    public final String getName() {
        return this.fjx.mName + "|Background";
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 3:
                c.a(this.fjx, this.fjx.fjo);
                return true;
            case 12:
                super.jH(16);
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

    final void acx() {
        if (this.fjx.cjn() == this) {
            c.a(this.fjx, this.fjx.fjr);
            this.fjx.jG(1000);
        }
    }
}
