package com.tencent.mm.plugin.appbrand.b;

import android.os.Message;
import com.tencent.mm.plugin.appbrand.g.a.f;
import com.tencent.mm.plugin.appbrand.g.a.h;
import com.tencent.mm.plugin.appbrand.g.g;
import com.tencent.mm.sdk.platformtools.x;

final class c$e extends g {
    final /* synthetic */ c fjx;

    c$e(c cVar, h hVar) {
        this.fjx = cVar;
        super(hVar);
    }

    public final String getName() {
        return this.fjx.mName + "|Suspend";
    }

    public final void enter() {
        super.enter();
        this.fjx.sJQ.sendEmptyMessageDelayed(11, ((long) this.fjx.fdO.fcu.frj) * 1000);
        g acy = acy();
        if (acy != null) {
            acy.pause();
            for (f fVar : this.fjx.fdO.fcy.fdR.fed.geA.values()) {
                fVar.gem.fcO = true;
            }
        }
    }

    public final void exit() {
        super.exit();
        this.fjx.sJQ.removeMessages(11);
        g acy = acy();
        if (acy != null) {
            acy.resume();
            for (f fVar : this.fjx.fdO.fcy.fdR.fed.geA.values()) {
                h hVar = fVar.gem;
                hVar.fcO = false;
                hVar.gev.interrupt();
            }
        }
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 3:
                c.a(this.fjx, this.fjx.fjo);
                return true;
            case 11:
                x.i(this.fjx.TAG, "suspend timeout");
                this.fjx.acu();
                return true;
            default:
                return super.j(message);
        }
    }

    private g acy() {
        return (g) this.fjx.fdO.fcy.fdQ.y(g.class);
    }
}
