package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;

final class f$c extends d {
    final /* synthetic */ f gqS;

    private f$c(f fVar) {
        this.gqS = fVar;
    }

    /* synthetic */ f$c(f fVar, byte b) {
        this(fVar);
    }

    public final String getName() {
        return this.gqS.mName + "|Init";
    }

    public final boolean j(Message message) {
        if (2 == message.what) {
            this.gqS.b(this.gqS.gqO);
            return true;
        } else if (1 != message.what) {
            return super.j(message);
        } else {
            this.gqS.b(this.gqS.gqP);
            return true;
        }
    }
}
