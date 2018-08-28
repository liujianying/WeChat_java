package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;

class o$4 implements c {
    final /* synthetic */ o aLG;
    final /* synthetic */ a aLH;
    final /* synthetic */ int aLI;

    o$4(o oVar, a aVar, int i) {
        this.aLG = oVar;
        this.aLH = aVar;
        this.aLI = i;
    }

    public final void a(ConnectionResult connectionResult) {
        this.aLG.aKI.lock();
        try {
            this.aLG.aLz.a(connectionResult, this.aLH, this.aLI);
        } finally {
            this.aLG.aKI.unlock();
        }
    }
}
