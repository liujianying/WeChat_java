package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.bi;

final class f$a extends d {
    private long gqR;
    final /* synthetic */ f gqS;

    private f$a(f fVar) {
        this.gqS = fVar;
    }

    /* synthetic */ f$a(f fVar, byte b) {
        this(fVar);
    }

    public final String getName() {
        return this.gqS.mName + "|Background";
    }

    public final boolean j(Message message) {
        if (2 != message.what) {
            return super.j(message);
        }
        this.gqS.b(this.gqS.gqO);
        return true;
    }

    public final void enter() {
        super.enter();
        this.gqR = bi.VF();
    }

    public final void exit() {
        super.exit();
        this.gqS.gqL = bi.VF() - this.gqR;
    }
}
