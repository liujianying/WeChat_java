package com.tencent.mm.plugin.base.model;

import com.tencent.mm.sdk.platformtools.al.a;

class d$b implements a {
    private Runnable epp;

    d$b(Runnable runnable) {
        this.epp = runnable;
    }

    public final boolean vD() {
        if (this.epp != null) {
            this.epp.run();
        }
        return false;
    }
}
