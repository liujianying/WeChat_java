package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.api.c.b;

class o$2 implements b {
    final /* synthetic */ o aLG;

    o$2(o oVar) {
        this.aLG = oVar;
    }

    public final void dm(int i) {
        this.aLG.aKI.lock();
        try {
            this.aLG.aLz.dm(i);
        } finally {
            this.aLG.aKI.unlock();
        }
    }

    public final void e(Bundle bundle) {
        this.aLG.aKI.lock();
        try {
            this.aLG.aLz.e(bundle);
        } finally {
            this.aLG.aKI.unlock();
        }
    }
}
