package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.k.a;
import com.google.android.gms.common.api.o.e;
import java.util.Collections;

public final class n implements p {
    private final o aKG;

    public n(o oVar) {
        this.aKG = oVar;
    }

    public final <A extends b, R extends g, T extends a<R, A>> T a(T t) {
        this.aKG.aLq.add(t);
        return t;
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
    }

    public final <A extends b, T extends a<? extends g, A>> T b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void begin() {
        for (b disconnect : this.aKG.aLw.values()) {
            disconnect.disconnect();
        }
        this.aKG.aLy = Collections.emptySet();
    }

    public final void connect() {
        o oVar = this.aKG;
        oVar.aKI.lock();
        try {
            oVar.aLz = new m(oVar, oVar.aKX, oVar.aKY, oVar.aKf, oVar.aKg, oVar.aKI, oVar.mContext);
            oVar.aLz.begin();
            oVar.aLo.signalAll();
        } finally {
            oVar.aKI.unlock();
        }
    }

    public final void disconnect() {
        for (e cancel : this.aKG.aLq) {
            cancel.cancel();
        }
        this.aKG.aLq.clear();
        this.aKG.aLx.clear();
        this.aKG.oR();
    }

    public final void dm(int i) {
    }

    public final void e(Bundle bundle) {
    }

    public final String getName() {
        return "DISCONNECTED";
    }
}
