package com.tencent.mm.plugin.appbrand.r;

import android.os.Message;
import com.tencent.mm.plugin.appbrand.report.d;

final class f$a extends d {
    final /* synthetic */ f gBG;

    private f$a(f fVar) {
        this.gBG = fVar;
    }

    /* synthetic */ f$a(f fVar, byte b) {
        this(fVar);
    }

    public final boolean j(Message message) {
        if (2 != message.what) {
            return super.j(message);
        }
        this.gBG.b(this.gBG.gBC);
        return true;
    }

    public final String getName() {
        return this.gBG.gBE + "|StateExecuting";
    }
}
