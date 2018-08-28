package com.tencent.mm.plugin.appbrand.r;

import android.os.Message;
import com.tencent.mm.plugin.appbrand.report.d;

final class f$b extends d {
    final /* synthetic */ f gBG;

    private f$b(f fVar) {
        this.gBG = fVar;
    }

    /* synthetic */ f$b(f fVar, byte b) {
        this(fVar);
    }

    public final void enter() {
        super.enter();
        f.a(this.gBG);
    }

    public final boolean j(Message message) {
        if (1 != message.what && 2 != message.what) {
            return super.j(message);
        }
        f.a(this.gBG);
        return true;
    }

    public final String getName() {
        return this.gBG.gBE + "|StateIdle";
    }
}
